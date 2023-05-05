package com.tender.controller;

import java.util.Scanner;

import com.tender.entity.Vendor;
import com.tender.utils.DbUtils.GetConnection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

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

public void vendorSignUp(Scanner sc) {
	EntityManagerFactory emf=GetConnection.getEmf();
	EntityManager em=emf.createEntityManager();
	System.out.println("Enter Company Name");
	String companyName=sc.next();
	System.out.println("Enter User-Name");
	String userName=sc.next();
	System.out.println("Enter Password");
	String password=sc.next();
	System.out.println("Enter Total Tenders Take-Over");
	int tenderTakeOver=sc.nextInt();
	System.out.println("Enter Experience In Years");
	int experience=sc.nextInt();
	Vendor vendor=new Vendor(companyName,userName,password,tenderTakeOver,experience);
	em.getTransaction().begin();
	em.persist(vendor);
	em.getTransaction().commit();
	em.clear();
	System.out.println("Sign Up SuccessFull");
}

public Vendor vendorLogin(Scanner sc) {
	EntityManagerFactory emf=GetConnection.getEmf();
	EntityManager em=emf.createEntityManager();
	System.out.println("Enter Vendor User_Name");
	String username=sc.next();
	System.out.println("Enter Vendor Password");
	String password=sc.next();
	String sql = "SELECT * FROM vendor WHERE username LIKE :username AND userPasword LIKE :password";
	Query query=em.createNativeQuery(sql,Vendor.class);
	query.setParameter("username", username);
	query.setParameter("password", password);
	try {
		Vendor vendor=(Vendor) query.getSingleResult();
		if(vendor!=null) {
			return vendor;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
	
}


public void signUpOrLoginMenu(Scanner sc) {
	int i=0;
	while(i!=7) {
		System.out.println("1: SignUp Vendor");
		System.out.println("2: Login Vendor");
		System.out.println("7: Exit");
		i=sc.nextInt();
		switch(i) {
		case 1:
			vendorSignUp(sc);
			break;
		case 2:
			Vendor vendor=vendorLogin(sc);
			if(vendor!=null) {
				new VendorController().vendorMethod(sc,vendor);
			}else {
				
				System.out.println("Wrong Credentials");
			}
			
			break;
		case 7:
			System.out.println("Exited To Main Menu");
			break;
		}
	}	
}
}
