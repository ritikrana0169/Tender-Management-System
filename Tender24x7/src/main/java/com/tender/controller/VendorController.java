package com.tender.controller;

import java.util.List;
import java.util.Scanner;

import com.tender.daoImpl.TenderDaoImpl;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;
import com.tender.service.TenderService;
import com.tender.service.VendorService;

public class VendorController {
	
	public void vendorMethod(Scanner sc,Vendor vendor) {
		TenderDaoImpl tenderDaoImpl=new TenderDaoImpl();
		TenderService tenderService=new TenderService();
		VendorService vendorService=new VendorService();
		System.out.println("Vendor Pannel\n\n");
		int i=0;
		while(i!=7) {
			System.out.println("Company Name-> "+vendor.getVendorCompanyName());
			System.out.println("1: Update his account details and change password");
			System.out.println("2: View all the current Tenders");
			System.out.println("3: Place a Bid against a Tender");
			System.out.println("4: View his own Bid History with bid status");
			System.out.println("5: Search for a tender by tender id");
			System.out.println("7: Logout");
			
			i=sc.nextInt();
			switch(i) {
			case 1:
				vendorService.getDataAndUpdateVendor(sc,vendor.getVendorId());
				break;
			case 2:
				List<Tender> tenderList=tenderDaoImpl.getAllOpenTenders();
				tenderService.printAllTenders(tenderList);
				break;
			case 3:
				List<Tender> customTender=tenderDaoImpl.biddingForTender(vendor,sc);
				tenderService.printAllTenders(customTender);
				int bidTenderId=tenderService.bidByVendor(sc);
				Tender tender=tenderDaoImpl.getTenderByTenderId(bidTenderId);
				tender.getBidByList().add(vendor);
				tenderDaoImpl.saveTender(tender);
				System.out.println("Bidding SuccessFully");
//				vendorViewAllTenders();
				break;
			case 4:
				vendorService.viewBidHistory(vendor.getVendorId());
				
				break;
			case 5:
				tenderService.searchTenderById(sc);
				break;
			case 7:
				System.out.println("Admin Logged Out");
				break;
			}
		}
	}
}
