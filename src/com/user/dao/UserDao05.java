package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.user.domain.User;

public class UserDao05 {
	
	//5-2 단계 DataSource 적용
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void add(User user) throws SQLException{
		
		Connection c = dataSource.getConnection();
		
		String sql = "insert into users values(?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws SQLException{
		
		Connection c = dataSource.getConnection();
		
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
