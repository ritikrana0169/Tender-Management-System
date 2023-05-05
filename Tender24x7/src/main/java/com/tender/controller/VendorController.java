package com.tender.controller;

import java.util.Scanner;

import com.tender.entity.Vendor;

public class VendorController {
	public void vendorMethod(Scanner sc,Vendor vendor) {
		System.out.println("Vendor Pannel\n\n");
		int i=0;
		while(i!=7) {
			System.out.println("Company Name-> "+vendor.getVendorCompanyName());
			System.out.println("1: Update his account details and change password");
			System.out.println("2: View all the current Tenders");
			System.out.println("3: Place a Bid against a Tender");
			System.out.println("4: View his own Bid History with bid status");
			System.out.println("5: Search for a tender by tender id or date range");
			System.out.println("7: Logout");
			
			i=sc.nextInt();
			switch(i) {
			case 1:
//				vendorLogin();
				break;
			case 2:
//				vendorUpdateDetails();
				break;
			case 3:
//				vendorViewAllTenders();
				break;
			case 4:
//				vendorPlaceBid();
				break;
			case 5:
//				viewAll();
				break;
			case 6:
//				adminAssignTender();
				break;
			case 7:
				System.out.println("Admin Logged Out");
				break;
			}
		}
	}
}
