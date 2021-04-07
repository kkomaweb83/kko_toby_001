package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao02 extends UserDao02 {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		String url = "jdbc:h2:tcp://localhost/~/test";
		//String url = "jdbc:h2:file:E://h2_data/test";
		String m_id = "sa";
		String password = "";
		Connection c = DriverManager.getConnection(url, m_id, password);
		
		return c;
	}

}
