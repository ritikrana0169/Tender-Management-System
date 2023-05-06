package com.tender.service;

import java.util.List;
import java.util.Scanner;

import com.tender.daoImpl.VendorDaoImpl;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;

public class VendorService {
	VendorDaoImpl vendorDaoImpl=new VendorDaoImpl();
	
	public void getDataAndUpdateVendor(Scanner sc,int vendorId) {
		Vendor vendor=vendorDaoImpl.getVendorById(vendorId);
		System.out.println(vendor.toString());
		String oldPassword=vendor.getUserPasword();
		int i=0;
		while(i!=7) {
			System.out.println("1: Update User-Name");
			System.out.println("2: Update User-Password");
			System.out.println("3: Update Total Tender TakeOver");
			System.out.println("4: Update Total Experience");
			
			i=sc.nextInt();
			switch(i) {
			case 1:
				System.out.println("Enter New User-Name");
				vendor.setUserName(sc.next());
				break;
			case 2:
				System.out.println("Enter New User-Password");
				vendor.setUserPasword(sc.next());
				break;
			case 3:
				System.out.println("Enter Updated Total Tender TakeOver");
				vendor.setTotalTenderTakeOver(sc.nextInt());
				break;
			case 4:
				System.out.println("Enter Updated Total Experience");
				vendor.setExperienceInYears(sc.nextInt());
				break;
			case 7:
				System.out.println("Update Your Profile");
				System.out.println("Enter Your Old Password To Verify");
				String password=sc.next();
				if(!oldPassword.equals(password)) {
					System.out.println("Wrong Password Try Again");
					System.out.println("Profile Not Updated");
				}else {
					vendorDaoImpl.saveVendor(vendor);
					System.out.println("Profile Updated Successfully");
				}
				break;
			}
		}
	}
	
	
	
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
public void viewBidHistory(int id) {

	Vendor vendor=vendorDaoImpl.getVendorById(id);
	for(int i=0;i<vendor.getBidForList().size();i++) {
		Tender td=vendor.getBidForList().get(i);
		System.out.println("Tender Id-> "+td.getTenderId()+" Tender Name"+td.getTenderName());
		if(td.getVendor().getVendorCompanyName().equals("open")) {
			System.out.println("Tender Status-> Still Open");
		}else {
			System.out.println("Tender Status Assigned To-> "+td.getVendor().getVendorCompanyName());
		}
	}
	
}

}
