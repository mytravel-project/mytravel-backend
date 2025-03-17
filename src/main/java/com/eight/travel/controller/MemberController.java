package com.eight.travel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.eight.travel.dto.Login;
import com.eight.travel.dto.Member;
import com.eight.travel.service.LoginAttemptService;
import com.eight.travel.service.MemberService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://192.168.0.38:5500"})

public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	LoginAttemptService loginAttemptService;

	@PostMapping("/register")
	public String insertMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.insertMember(m);
			return "환영합니다";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "회원 가입 실패";
		}  

	}
	
	@PostMapping("isEmailExists")
	public Map<String, Boolean> isEmailExists(@RequestBody Member m) {
		String email = m.getEmail();
		boolean exists = memberService.isEmailExists(email);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("exists", exists);
		
		return response;
	}
	
	@PostMapping("isNicknameExists")
	public Map<String, Boolean> isNicknameExists(@RequestBody Member m) {
		String nickname = m.getNickname();
		boolean exists = memberService.isNicknameExists(nickname);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("exists", exists);
		
		return response;
	}
	
	@PostMapping("logout")
	public void logout(@RequestHeader String authorization) {
		System.out.println(authorization);
		try {
			memberService.logout(authorization);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("tokenLogin")
	public Map<String,String> tokenLogin(@RequestBody Member m) {
		System.out.println(m);
		
		Map<String,String> responseMap = new HashMap<>();
		
		String email = m.getEmail();
        if (email == null || email.trim().isEmpty()) {
            responseMap.put("msg", "이메일을 입력하세요.");
            return responseMap;
        }
        if (loginAttemptService.isBlocked(email)) {
            responseMap.put("msg", "로그인 시도 횟수가 초과되었습니다. 15분 후 다시 시도하세요.");
            return responseMap;
        }
		
		try {
			Login loginInfo = memberService.tokenLogin(m);
			
			if(loginInfo != null && loginInfo.getEmail() != null && loginInfo.getToken() != null) {
				responseMap.put("nickname", memberService.getNicknameByEmail(loginInfo.getEmail()));
				responseMap.put("Authorization", loginInfo.getToken());
				
				// 로그인 성공 시 실패 횟수 초기화
                loginAttemptService.resetAttempts(email);
			}
			else {
				loginAttemptService.loginFailed(email);
                responseMap.put("msg", "로그인 실패! 이메일 또는 비밀번호를 확인하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseMap.put("msg", "다시 로그인 해주세요");
		}
		return responseMap;
	}
	
	@PostMapping("updateMember")
	public String updateMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.updateMember(m);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}
	
	@PostMapping("deleteMember")
	public String deleteMember(@RequestBody String email) {
		System.out.println(email);
		try {
			memberService.deleteMember(email);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}
}
