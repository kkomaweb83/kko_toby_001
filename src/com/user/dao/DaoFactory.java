package com.user.dao;

public class DaoFactory {
	public UserDao03 userDao(){
		return new UserDao03(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
