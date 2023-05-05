package com.tender.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Tender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tenderId;
	private String tenderName;
	private int takeOverBid;
	private Date tenderClosingDate;
	
	
	@ManyToMany
	@JoinTable(name="vendorBidsForTenders", joinColumns = {@JoinColumn(referencedColumnName = "tenderId")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "vendorId")})
    private List<Vendor> bidByList;
	@ManyToOne
	@JoinColumn(name ="fkVendorId")
	private Vendor vendor;

public Tender() {
	super();
	// TODO Auto-generated constructor stub
}




public Tender(String tenderName, int takeOverBid, Date tenderClosingDate, Vendor vendor) {

	this.tenderName = tenderName;
	this.takeOverBid = takeOverBid;
	this.tenderClosingDate = tenderClosingDate;
	this.vendor = vendor;
}




public Date getTenderClosingDate() {
	return tenderClosingDate;
}

public void setTenderClosingDate(Date tenderClosingDate) {
	this.tenderClosingDate = tenderClosingDate;
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
	return "Tender [tenderId=" + tenderId + ", tenderName=" + tenderName + ", takeOverBid=" + takeOverBid
			+ ", tenderClosingDate=" + tenderClosingDate + ", vendor=" + vendor.getVendorCompanyName() + "]";
}


}
