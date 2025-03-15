package com.eight.travel.dao;

import org.apache.ibatis.annotations.Mapper;

import com.eight.travel.dto.Login;

@Mapper
public interface LoginDao {	
	public void insertToken(Login login) throws Exception;

	public void deleteToken(String token) throws Exception;

	public Login checkToken(String authorization) throws Exception;
}
