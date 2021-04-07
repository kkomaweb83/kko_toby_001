package com.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.user.domain.User;

// 4 단계 - spring 빈팩토리(bean factory) / 애플리케이션 컨텍스트(application context) 적용
// 제어의 역전/Ioc
// 싱글톤 레지스트리
// DI 컨테이너
// 의존관게 주입/DI
public class UserDaoTest04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory04.class);
		
		UserDao03 dao = context.getBean("userDao", UserDao03.class);
		
		User user = new User();
		user.setId("kkomaweb04");
		user.setName("왕대박");
		user.setPassword("4444");
		
		dao.add(user);
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
		
	}
}
