package com.eight.travel.dao;

import org.apache.ibatis.annotations.Mapper;

import com.eight.travel.dto.Member;

@Mapper
public interface MemberDao {
	
	public Member login(Member m) throws Exception;
	
	public void insertMember(Member m) throws Exception;
	
	public void updateMember(Member m) throws Exception;
	
	public void deleteMember(String email) throws Exception;
}
