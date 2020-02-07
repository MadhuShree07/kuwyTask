package com.xworkz.kuwy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.kuwy.container.DBconnection;
import com.xworkz.kuwy.container.LoginImpl;

public class SpringTester {

	public static void main(String[] args) {
		try {
			ApplicationContext container = new ClassPathXmlApplicationContext("resources/spring.xml");
			LoginImpl ref = container.getBean(LoginImpl.class);
			ref.page();
			ref.getPassword();
			ref.getUsername();
			DBconnection refOfDBConnection = container.getBean(DBconnection.class);
			refOfDBConnection.operation();
			ClassPathXmlApplicationContext castingToImpl = (ClassPathXmlApplicationContext) container;
			castingToImpl.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
