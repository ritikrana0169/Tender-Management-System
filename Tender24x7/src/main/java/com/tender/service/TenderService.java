package com.tender.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.tender.daoImpl.BidDaoImpl;
import com.tender.daoImpl.TenderDaoImpl;
import com.tender.daoImpl.VendorDaoImpl;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;
import com.tender.exception.NoRecordFoundException;
import com.tender.exception.SomeThingWentWrongException;

public class TenderService {
	VendorDaoImpl vendorDaoImpl=new VendorDaoImpl();
	TenderDaoImpl tenderDaoImpl=new TenderDaoImpl();
	BidDaoImpl bidDaoImpl=new BidDaoImpl();
	
	public Tender createNewTender(Scanner sc) {
		System.out.println("Create New Tender\n");
		System.out.println("Enter Tender Name");
		String tenderName=sc.next();
		System.out.println("Enter Tender Closing Date in Format(DD-MM-YYYY)");
		String closingDateStr=sc.next();
		System.out.println("Enter Tender Minimum Expected Price");
		int tenderExpectedPrice=sc.nextInt();
		Date closingDate=null;
		try {
			 closingDate=new SimpleDateFormat("dd-MM-yyyy").parse(closingDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Date Input Assigning Close Date of 3 Months");
			closingDate=new Date();
		}
		Vendor vendor=vendorDaoImpl.getVendorById(-1);
		Tender tender=new Tender(tenderName,-1,closingDate,vendor,tenderExpectedPrice);
		return tender;
	}
	public void printAllTenders(List<Tender> tenderList) {
		tenderList.forEach(s->System.out.println(s.toString()));
	}
	
	public int bidByVendor(Scanner sc) {
		System.out.println("Enter Tender Id For Which You Want To Bid");
		
		return sc.nextInt();
	}
	
	public int priceForTender(Scanner sc) {
		System.out.println("Enter Your Bid Price");
		
		return sc.nextInt();
	}
	public int scanTenderId(Scanner sc) {
		System.out.println("Enter Tender Id ");
		
		return sc.nextInt();
	}
	public void printTenderBidHistory(List<Vendor> tenderBidHistory,int id) throws NoRecordFoundException {
		
		for(int i=0;i<tenderBidHistory.size();i++) {
			System.out.println("|⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃Ｂ Ｉ Ｄ⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|");
			System.out.println("| VENDOR ID ➤ "+tenderBidHistory.get(i).getVendorId());
			System.out.println("| VENDOR NAME ➤ "+tenderBidHistory.get(i).getVendorCompanyName());
			Integer price=bidDaoImpl.getBidPriceByTenderIdAndVendorId(id, tenderBidHistory.get(i).getVendorId());
			System.out.println("| VENDOR BID PRICE ➤ "+price);
			System.out.println("|⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|");
		}
	}
	public void assignVendor(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException{
		System.out.println("Enter Tender Id For Which You Want To Assign Vendor");
		int tenderId=sc.nextInt();
		System.out.println("Enter Vendor Id");
		int vendorId=sc.nextInt();
		try {
			Tender assignTender=tenderDaoImpl.getTenderByTenderId(tenderId);
			Vendor assignVendor=vendorDaoImpl.getVendorById(vendorId);
			
			int price=bidDaoImpl.getBidPriceByTenderIdAndVendorId(tenderId, vendorId);
			
			assignTender.setVendor(assignVendor);
			assignTender.setTakeOverBid(price);
			tenderDaoImpl.saveTender(assignTender);
			System.out.println("Tender Assigned To Vendor Id-> "+vendorId);
		} catch (NoRecordFoundException e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Try Again");
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		
		
	}
public void searchTenderById(Scanner sc) {
	System.out.println("Enter Tender Id");
	int id=sc.nextInt();
	Tender tender=tenderDaoImpl.getTenderByTenderId(id);
	if(tender!=null) {
		System.out.println(tender.toString());
		
	}
}
	
}
