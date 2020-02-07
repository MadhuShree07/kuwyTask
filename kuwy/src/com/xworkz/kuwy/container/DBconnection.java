package com.xworkz.kuwy.container;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBconnection {

	@Value("1")
	private String id;
	@Value("madhu")
	private String username;
	@Value("123")
	private String password;

	private Connection connection;
	private Statement stmt;

	public DBconnection() {
		System.out.println("created\t" + this.getClass().getSimpleName());
	}

	@PostConstruct
	public void initResource() {
		String query = "insert into kuwy.admin-master values(1,'madhu',123)";
		try {
			System.out.println("init the resources");
			System.out.println("id" + this.id);
			System.out.println("username" + this.username);
			System.out.println("password" + this.password);
			Class.forName(this.password);
			this.connection = DriverManager.getConnection(this.id, this.username, this.password);
			System.out.println("Resources connection is created" + this.connection);
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			stmt.execute(query);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void operation() {
		System.out.println("invoked operation");
		try {
			System.out.println(this.connection.isClosed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PreDestroy
	public void closeResources() {
		System.out.println("invoked close resources");
		try {
			this.connection.close();
			System.out.println("resources is closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
