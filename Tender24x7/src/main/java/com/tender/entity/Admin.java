package com.tender.entity;

import java.util.ArrayList;
import java.util.List;

public class Admin {

	String userName="admin";
	List<Vendor> vendorList=new ArrayList<>();
	List<Tender> tenderList=new ArrayList<>();
	
	public List<Tender> getTenderList() {
		return tenderList;
	}
	

	public void setTenderList(List<Tender> tenderList) {
		this.tenderList = tenderList;
	}

	public List<Vendor> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<Vendor> vendorList) {
		this.vendorList = vendorList;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
