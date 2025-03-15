package com.eight.travel.service;

import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eight.travel.dao.LoginDao;
import com.eight.travel.dao.MemberDao;
import com.eight.travel.dto.Login;
import com.eight.travel.dto.Member;
import com.eight.travel.util.OpenCrypt;


@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	LoginDao loginDao;
	
	public Login checkToken(String authorization) throws Exception {
		return loginDao.checkToken(authorization);
	}

	
	public Login tokenLogin(Member m) throws Exception {
		m = memberDao.login(m);
		if(m!=null) {
			String nickname = m.getEmail();
			if(nickname!=null && !nickname.trim().equals("")) {
				
				//member table에서 email과 pwd가 확인된 상황 즉 login ok
				String email = m.getEmail();
				
				//1. salt를 생성한다
				String salt = UUID.randomUUID().toString();
				System.out.println("salt: "+salt);
				
				//2. email을 hashing 한다
				byte[] originalHash = OpenCrypt.getSHA256(email, salt);
				
				//3. db에 저장하기 좋은 포맷으로 인코딩한다
				String myToken = OpenCrypt.byteArrayToHex(originalHash);
				System.out.println("myToken : " + myToken);
				
				//4. login table에 token 저장
				Login loginInfo = new Login(email, myToken, new Date());
				loginDao.insertToken(loginInfo);
				
				return loginInfo;
			}
		}
		
		return null;		 
	}
	
	public Member login(Member m) throws Exception {
		return memberDao.login(m);
	}
	
	public void insertMember(Member m) throws Exception {
		memberDao.insertMember(m);
	}
	
	public void updateMember(Member m) throws Exception {
		memberDao.updateMember(m);
	}
	
	public void deleteMember(String email) throws Exception {
		memberDao.deleteMember(email);
	}

	public void logout(String authorization) throws Exception {
		loginDao.deleteToken(authorization);
		
	}
}
