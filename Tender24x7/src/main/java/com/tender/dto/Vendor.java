package com.tender.dto;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
String vendorName="Ritik";

List<Tender> bidForList=new ArrayList<>();

public String getVendorName() {
	return vendorName;
}

public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}

public Vendor() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Vendor [vendorName=" + vendorName + "]";
}

}
