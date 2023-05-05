package com.tender.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.tender.daoImpl.VendorDaoImpl;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;

public class TenderService {
	VendorDaoImpl vendorDaoImpl=new VendorDaoImpl();
	
	public Tender createNewTender(Scanner sc) {
		System.out.println("Create New Tender\n");
		System.out.println("Enter Tender Name");
		String tenderName=sc.next();
		System.out.println("Enter Tender Closing Date in Format(DD-MM-YYYY)");
		String closingDateStr=sc.next();
		Date closingDate=null;
		try {
			 closingDate=new SimpleDateFormat("dd-MM-yyyy").parse(closingDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Date Input Assigning Close Date of 3 Months");
			closingDate=new Date();
		}
		Vendor vendor=vendorDaoImpl.getVendorById(-1);
		Tender tender=new Tender(tenderName,-1,closingDate,vendor);
		return tender;
	}
	public void printAllTenders(List<Tender> tenderList) {
		tenderList.forEach(s->System.out.println(s.toString()));
	}
}
