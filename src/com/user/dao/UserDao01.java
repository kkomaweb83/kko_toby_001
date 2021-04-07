package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.domain.User;

public class UserDao01 {
	
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
	
	//1단게 리팩토링(refactoring) - 관심사의 분리(Separation of Concerns)
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.h2.Driver");
		String url = "jdbc:h2:tcp://localhost/~/test";
		String m_id = "sa";
		String password = "";
		Connection c = DriverManager.getConnection(url, m_id, password);
		
		return c;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDao01 dao = new UserDao01();
		
		User user = new User();
		user.setId("kkomaweb01");
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
