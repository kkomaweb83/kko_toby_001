package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.domain.User;

public abstract class UserDao02 {
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		
		Connection c = getConnection();
		
		String sql = "insert into users values(?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		
		Connection c = getConnection();
		
		String sql = "select * from users where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		User user = new User();
		while(rs.next()){
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	//2단계 추상 클래스 - 상속을 통한 - 템플릿 메소드패턴, 팩토리 메소드패턴
	abstract public Connection getConnection() throws ClassNotFoundException, SQLException;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDao02 dao = new NUserDao02();
		
		User user = new User();
		user.setId("kkomaweb02");
		user.setName("왕대박");
		user.setPassword("999");
		
		dao.add(user);
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
		
	}
	
}
