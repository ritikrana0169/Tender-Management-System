package com.tender.dto;

import java.util.ArrayList;
import java.util.List;

public class Tender {
private String tenderName;
List<Vendor> bidByList=new ArrayList<>();

public Tender() {
	super();
	// TODO Auto-generated constructor stub
}

public Tender(String tenderName) {
	super();
	this.tenderName = tenderName;
}

public String getTenderName() {
	return tenderName;
}

public void setTenderName(String tenderName) {
	this.tenderName = tenderName;
}

@Override
public String toString() {
	return "Tender [tenderName=" + tenderName + "]";
}

}
