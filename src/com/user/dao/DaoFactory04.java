package com.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory04 {
	
	@Bean
	public UserDao03 userDao(){
		return new UserDao03(connectionMaker());
	}
	
	@Bean
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
