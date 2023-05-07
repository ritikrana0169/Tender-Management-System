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
	private int tenderExpectedPrice;
	
	public int getTenderExpectedPrice() {
		return tenderExpectedPrice;
	}
	public void setTenderExpectedPrice(int tenderExpectedPrice) {
		this.tenderExpectedPrice = tenderExpectedPrice;
	}
	public int getTakeOverBid() {
		return takeOverBid;
	}
	public void setTakeOverBid(int takeOverBid) {
		this.takeOverBid = takeOverBid;
	}




	@ManyToMany
	@JoinTable(name="vendorBidsForTenders", joinColumns = {@JoinColumn(referencedColumnName = "tenderId")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "vendorId")})
    private List<Vendor> bidByList;
	@ManyToOne
	@JoinColumn(name ="fkVendorId")
	private Vendor vendor;

public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
public Tender() {
	super();
	// TODO Auto-generated constructor stub
}




public List<Vendor> getBidByList() {
	
	return bidByList;
}



public void setBidByList(List<Vendor> bidByList) {
	this.bidByList = bidByList;
}




public int getTenderId() {
	return tenderId;
}




public void setTenderId(int tenderId) {
	this.tenderId = tenderId;
}




public Tender(String tenderName, int takeOverBid, Date tenderClosingDate, Vendor vendor,int tenderExpectedPrice) {

	this.tenderName = tenderName;
	this.takeOverBid = takeOverBid;
	this.tenderClosingDate = tenderClosingDate;
	this.vendor = vendor;
	this.tenderExpectedPrice=tenderExpectedPrice;
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
	return"|⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃【T】【E】【N】【D】【E】【R】⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|"+
        "\n| TENDER ID ➤ " + tenderId + 
	    "\n| TENDER NAME ➤ " + tenderName + "\n"
	    + "| TAKEOVER BID ➤ " + takeOverBid
	  + "\n| TENDER CLOSING DATE ➤ " + tenderClosingDate + 
	    "\n| VENDOR ➤ " + vendor.getVendorCompanyName()
	   +"\n| MINIMUM EXPECTED BUDGET ➤ "+tenderExpectedPrice+ 
	    "\n|⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃|";
}


}
