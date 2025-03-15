package com.eight.travel.service;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eight.travel.dao.MemberDao;
import com.eight.travel.dao.SaltDao;
import com.eight.travel.dto.Member;
import com.eight.travel.dto.SaltInfo;
import com.eight.travel.util.OpenCrypt;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	SaltDao saltDao;
	
	public void insertMember(Member m) throws Exception{
		
		// 이메일 유효성 검사
		String email = m.getEmail();
	    if (!isValidEmail(email)) {
	        throw new Exception("유효하지 않은 이메일 형식입니다.");
	    }
	    
	    //이메일 중복 검사
	    if (isEmailExists(email)) {
	    	throw new Exception("이미 가입된 이메일입니다.");
	    }
	    
	    //닉네임 유효성 검사
	    String nickname = m.getNickname();
	    if(!isValidNickname(nickname)) {
	    	throw new Exception("닉네임은 2자리 이상 15자리 이하이며, 특수문자를 사용할 수 없습니다.");
	    }
	    
	    //닉네임 중복 검사
	    if (isNicknameExists(nickname)) {
	    	throw new Exception("이미 존재하는 닉네임입니다.");
	    }
		
		// 패스워드 유효성 검사
	    String pwd = m.getPassword();
	    if (!isValidPassword(pwd)) {
	        throw new Exception("패스워드는 8자리 이상이어야 하며, 특수문자와 숫자를 포함해야 합니다.");
	    }
	    
	    // 패스워드 암호화
	    //1. salt를 생성한다
		String salt = UUID.randomUUID().toString();
		System.out.println("salt:"+ salt);
		//2. pwd를 hashing 한다
		byte[] originalHash = OpenCrypt.getSHA256(pwd, salt);
		//3. db에 저장하기 좋은 포맷으로 인코딩한다
		String pwdHash=OpenCrypt.byteArrayToHex(originalHash);
		System.out.println("pwdHash : "+pwdHash);
	    
		m.setPassword(pwdHash);
	    
		saltDao.insertSalt(new SaltInfo(email, salt, new Date()));
		memberDao.register(m);
	}
	
	public void updateMember(Member m) throws Exception{
		memberDao.updateMember(m);
	}
	
	public void deleteMember(String email) throws Exception{
		memberDao.deleteMember(email);
	}
	
	//닉네임 중복 검사 메서드
	private boolean isNicknameExists(String nickname) {
		return memberDao.isNicknameExists(nickname);
	}
	
	//닉네임 유효성 검사 메서드
	private boolean isValidNickname(String nickname) {
		String nicknamePattern = "^[a-zA-Z0-9가-힣]{2,15}$";
		return Pattern.matches(nicknamePattern, nickname);
	}
	
	
	// 이메일 유효성 검사 메서드
	private boolean isValidEmail(String email) {
	    // 이메일 패턴
	    String emailPattern = "^(?!.*\\.\\.+)[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{1,255}\\.[a-zA-Z]{2,6}$";
	    return Pattern.matches(emailPattern, email);
	}
	
	//이메일 중복 검사 메서드
	private boolean isEmailExists(String email) {
		return memberDao.isEmailExists(email);
	}

	// 패스워드 유효성 검사 메서드
	private boolean isValidPassword(String password) {
	    // 패스워드 패턴: 8자리 이상, 숫자 포함, 특수문자 포함
	    String passwordPattern = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])[\\S]{8,}$";
	    return Pattern.matches(passwordPattern, password);
	}

}
