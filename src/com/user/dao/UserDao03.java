package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.domain.User;

public class UserDao03 {
	
	//3-1 단계 - 인터페이스 도입 
	//3-2 단계 - 관계설정 책임의 분리 - 클라이언트 도입? 
	// 개방 폐쇄 원칙 OCP Open-Closed Principle
	// 전략패턴 
	private ConnectionMaker connectionMaker;
	
	public UserDao03(){
	}
	
	public UserDao03(ConnectionMaker _connectionMaker) {
		this.connectionMaker = _connectionMaker;
	}
	
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		
		Connection c = connectionMaker.makeConnection();
		
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
		
		Connection c = connectionMaker.makeConnection();
		
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
	
}
