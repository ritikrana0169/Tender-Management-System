package com.tender.controller;

import java.util.Scanner;

public class LoginController {
public boolean adminLogin(Scanner sc) {
	System.out.println("Enter Admin User_Name");
	String username=sc.next();
	System.out.println("Enter Admin Password");
	String password=sc.next();
	if(username.equals("admin")  && password.equals("password")) {
		return true;
	}
	return false;
}
}
