package com.eight.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eight.travel.dto.Member;
import com.eight.travel.service.MemberService;

@RestController
@CrossOrigin("http://192.168.0.38:5500")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
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
	
	@PostMapping("updateMember")
	public String updateMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.updateMember(m);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}

}
