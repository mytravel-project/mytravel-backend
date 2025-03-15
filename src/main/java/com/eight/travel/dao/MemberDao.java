package com.eight.travel.dao;

import org.apache.ibatis.annotations.Mapper;

import com.eight.travel.dto.Member;


@Mapper
public interface MemberDao {
		
	public void register(Member m) throws Exception;
	
	public void updateMember(Member m) throws Exception;
	
	public void deleteMember(String email) throws Exception;
	
	public boolean isEmailExists(String email);
}
