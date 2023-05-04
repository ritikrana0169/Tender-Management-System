package com.tender.controller;

import java.util.List;
import java.util.Scanner;

import com.tender.daoImpl.AdminDaoImpl;
import com.tender.dto.Admin;
import com.tender.dto.Vendor;

public class AdminController {
	Admin admin=new Admin();
	AdminDaoImpl adminDao=new AdminDaoImpl();
	
	public void administratorMethod(Scanner sc) throws InterruptedException {
		System.out.println("Administrator Pannel");
		int i=0;
		while(i!=7) {
			System.out.println("1: View all the vendors");
			System.out.println("2: Create new tenders");
			System.out.println("3: View All the Tenders");
			System.out.println("4: View All the Bids of a tender");
			System.out.println("5: Assign tender to a vendor");
			System.out.println("7: Logout");
			
			i=sc.nextInt();
			switch(i) {
			case 1:
				
				admin.setVendorList(adminDao.getAllVendors());
				printAllVendors(admin.getVendorList());
				Thread.sleep(4000);
//				adminViewAllVendors();
				break;
			case 2:
//				adminCreateNewTenders();
				adminDao.createTender(sc);
				Thread.sleep(4000);
				break;
			case 3:
//				adminViewAllTenders();
				break;
			case 4:
//				adminViewAllBidsOfaTender();
				break;
			case 5:
//				adminAssignTender();
				break;
			case 7:
				System.out.println("Admin Logged Out");
				break;
			}
		}
	}
	private void printAllVendors(List<Vendor> vendorList) {
		pattern();
	vendorList.forEach(s->System.out.println("\n"+s.toString()+"\n"));
	pattern();
	}
	
	
	static private void pattern() {
		System.out.println("\n \n   ----------------------------  \n");
	}
}
