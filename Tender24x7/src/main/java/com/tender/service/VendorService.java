package com.tender.service;

import java.util.List;
import java.util.Scanner;

import com.tender.entity.Tender;
import com.tender.entity.Vendor;

public class VendorService {
public Vendor vendorSignUp(Scanner sc) {
	System.out.println("Enter Company Name");
	String companyName=sc.next();
	System.out.println("Enter User-Name");
	String userName=sc.next();
	System.out.println("Enter User-Password");
	String userPassword=sc.next();
	System.out.println("Enter Total Tender TakeOver");
	int tenderTakeOver=sc.nextInt();
	System.out.println("Enter Experience In Years");
	int experienceYear=sc.nextInt();
	
	Vendor vendor=new Vendor(companyName,userName,userPassword,tenderTakeOver,experienceYear);
	return vendor;
}
public void printAllVendors(List<Vendor> vendorList) {
	vendorList.forEach(s->System.out.println(s.toString()));
}


}
