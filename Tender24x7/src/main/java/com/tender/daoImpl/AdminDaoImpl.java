package com.tender.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tender.dao.AdminDao;
import com.tender.entity.Admin;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;

public class AdminDaoImpl implements AdminDao{

	@Override
	public List<Vendor> getAllVendors() {
		Vendor v1=new Vendor();
		v1.setVendorCompanyName("abhiroop");
		Vendor v2=new Vendor();
		List<Vendor> vendorList=new ArrayList<>();
		vendorList.add(v1);
		vendorList.add(v2);
		return vendorList;
	}

	@Override
	public void createTender(Scanner sc) {
		
		System.out.println("Enter New Tender Details\n");
		System.out.println("Enter Tender Name");
		String tenderName=sc.next();
		Tender t1=new Tender();
		t1.setTenderName(tenderName);
//		saveTender();
	}

	@Override
	public List<Tender> getAllTenders() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
