package com.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.user.domain.User;

//5-1 단계 - 애플리케이션 컨텍스트 변경 DaoFactory --> XML 설정정보 applicationContext.xml 로 
public class UserDaoTest05 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory05.class);
		
		UserDao05 dao = context.getBean("userDao", UserDao05.class);
		
		User user = new User();
		user.setId("kkomaweb07");
		user.setName("왕대박");
		user.setPassword("777");
		
		dao.add(user);
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
		
	}
}
