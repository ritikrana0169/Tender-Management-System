package com.tender.controller;

import java.util.Scanner;

public class VendorController {
	public void vendorMethod(Scanner sc) {
		System.out.println("Administrator Pannel");
		int i=0;
		while(i!=7) {
			System.out.println("1: Login with his account");
			System.out.println("2: Update his account details and change password");
			System.out.println("3: View all the current Tenders");
			System.out.println("4: Place a Bid against a Tender");
			System.out.println("5: View his own Bid History with bid status");
			System.out.println("6: Search for a tender by tender id or date range");
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
