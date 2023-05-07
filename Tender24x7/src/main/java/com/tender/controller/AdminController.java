package com.tender.controller;

import java.util.List;
import java.util.Scanner;

import com.tender.daoImpl.AdminDaoImpl;
import com.tender.daoImpl.TenderDaoImpl;
import com.tender.daoImpl.VendorDaoImpl;
import com.tender.entity.Admin;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;
import com.tender.exception.NoRecordFoundException;
import com.tender.exception.SomeThingWentWrongException;
import com.tender.service.TenderService;
import com.tender.service.VendorService;


public class AdminController {
	Admin admin=new Admin();
	AdminDaoImpl adminDao=new AdminDaoImpl();
	TenderService tenderService=new TenderService();
	VendorService vendorService=new VendorService();
	TenderDaoImpl tenderDaoImpl=new TenderDaoImpl();
	VendorDaoImpl vendorDaoImpl=new VendorDaoImpl();
	public void administratorMethod(Scanner sc) throws InterruptedException, NoRecordFoundException {
		int i=0;
		while(i!=7) {
			
			System.out.println("\n"
					+ "▄▀█ █▀▄ █▀▄▀█ █ █▄░█\r\n"
					+ "█▀█ █▄▀ █░▀░█ █ █░▀█⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|");
		    System.out.println("| Options:                                       |");
		    System.out.println("|        1: View all the vendors                 |");
		    System.out.println("|        2: Create new tenders                   |");
		    System.out.println("|        3: View All the Tenders                 |");
		    System.out.println("|        4: View All the Bids of a tender        |");
			System.out.println("|        5: Assign tender to a vendor            |");
			System.out.println("|        7: Logout                               |");
		    System.out.println("|⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|");
			
			i=sc.nextInt();
			switch(i) {
			case 1:
				List<Vendor> vList=vendorDaoImpl.getAllVendors();
				vendorService.printAllVendors(vList);
				Thread.sleep(2000);
//				adminViewAllVendors();
				break;
			case 2:
//				adminCreateNewTenders();
				Tender tender=tenderService.createNewTender(sc);
				tenderDaoImpl.saveTender(tender);
				System.out.println("Tender Created SuccessFull\n");
				Thread.sleep(2000);
				break;
			case 3:
//				adminViewAllTenders();
				List<Tender> tList=tenderDaoImpl.getAllTenders();
				tenderService.printAllTenders(tList);
				Thread.sleep(2000);
				break;
			case 4:
				List<Tender> tOpenList=tenderDaoImpl.getAllOpenTenders();
				tenderService.printAllTenders(tOpenList);
				int tenderId=tenderService.scanTenderId(sc);
				Tender tenderObject=tenderDaoImpl.getTenderByTenderId(tenderId);
				tenderService.printTenderBidHistory(tenderObject.getBidByList(),tenderId);
				Thread.sleep(2000);
				break;
			case 5:
				try {
					tenderService.assignVendor(sc);
				} catch (SomeThingWentWrongException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
				Thread.sleep(2000);
				break;
			case 7:
				System.out.println("Admin Logged Out");
				Thread.sleep(2000);
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
