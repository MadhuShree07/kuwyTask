package com.xworkz.kuwy.container;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginImpl {

	private String username;
	private String password;

	public LoginImpl(String username, String password) {
		System.out.println("invoked username" + username);
		System.out.println("invoked password" + password);
		this.username = username;
		this.password = password;
	}

	public void page() {
		System.out.println("invoked page");
	}

	public String getUsername() {
		System.out.println("invoked username");
		return username;
	}

	public String getPassword() {
		System.out.println("invoked password");
		return password;
	}
}
