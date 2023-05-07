package com.tender.controller;

import java.util.List;
import java.util.Scanner;

import com.tender.daoImpl.BidDaoImpl;
import com.tender.daoImpl.TenderDaoImpl;
import com.tender.entity.Bid;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;
import com.tender.exception.NoRecordFoundException;
import com.tender.service.TenderService;
import com.tender.service.VendorService;

public class VendorController {
	
	public void vendorMethod(Scanner sc,Vendor vendor) throws NoRecordFoundException {
		TenderDaoImpl tenderDaoImpl=new TenderDaoImpl();
		TenderService tenderService=new TenderService();
		VendorService vendorService=new VendorService();
		BidDaoImpl bidDaoImpl=new BidDaoImpl();
		System.out.println("Vendor Pannel\n\n");
		int i=0;
		while(i!=7) {
			System.out.println("\r\n"
					+ "█░█ █▀▀ █▄░█ █▀▄ █▀█ █▀█\r\n"
					+ "▀▄▀ ██▄ █░▀█ █▄▀ █▄█ █▀▄⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|");
			System.out.println("| Company Name: "+vendor.getVendorCompanyName());
		    System.out.println("| Options:                                            |");
		    System.out.println("|        1: Update account details and change password|");
		    System.out.println("|        2: View all the current Tenders              |");
		    System.out.println("|        3: Place a Bid against a Tender              |");
		    System.out.println("|        4: View his own Bid History with bid status  |");
			System.out.println("|        5: Search for a tender by tender id          |");
			System.out.println("|        7: Logout                                    |");
		    System.out.println("|⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|");			
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
				if(!customTender.isEmpty()) {
					
					tenderService.printAllTenders(customTender);
					System.out.println("1: For Bid");
					System.out.println("2: For Exit");
					int k=sc.nextInt();
					if(k==1) {
						int bidTenderId=tenderService.bidByVendor(sc);
						int vendorBidPrice=tenderService.priceForTender(sc);
						Tender tender=tenderDaoImpl.getTenderByTenderId(bidTenderId);
						tender.getBidByList().add(vendor);
						Bid bid=new Bid();
						bid.setForTenderId(tender.getTenderId());
						bid.setByVendorId(vendor.getVendorId());
						bid.setPrice(vendorBidPrice);
						bidDaoImpl.saveBid(bid);
						tenderDaoImpl.saveTender(tender);
						System.out.println("Bidding SuccessFully");
					}
				}else {
					System.out.println("There Are No New Tenders For You Haven't Bid\n");
				}
//				vendorViewAllTenders();
				break;
			case 4:
				vendorService.viewBidHistory(vendor.getVendorId());
				
				break;
			case 5:
				tenderService.searchTenderById(sc);
				break;
			case 7:
				System.out.println("Vendor Logged Out");
				break;
			}
		}
	}
}
