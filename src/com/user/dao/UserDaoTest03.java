package com.user.dao;

import java.sql.SQLException;

import com.user.domain.User;

public class UserDaoTest03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao03 dao = new UserDao03(connectionMaker);
		
		User user = new User();
		user.setId("kkomaweb03");
		user.setName("왕대박");
		user.setPassword("6666");
		
		dao.add(user);
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
		
	}
}
