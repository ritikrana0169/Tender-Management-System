package com.tender.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;
    private String vendorCompanyName;
    private String userName;
    private String userPasword;
    private int totalTenderTakeOver;
    private int experienceInYears;
    

    @ManyToMany(mappedBy = "bidByList", cascade = CascadeType.ALL)
    private List<Tender> bidForList;
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Tender> tenderList;



public Vendor() {
	super();
	// TODO Auto-generated constructor stub
}






@Override
public String toString() {
	return "Vendor [vendorId=" + vendorId + ", vendorCompanyName=" + vendorCompanyName + ", userName=" + userName
			+ ", totalTenderTakeOver=" + totalTenderTakeOver + ", experienceInYears=" + experienceInYears + "]";
}






public int getVendorId() {
	return vendorId;
}



public Vendor(String vendorCompanyName, String userName, String userPasword, int totalTenderTakeOver,
		int experienceInYears) {
	super();
	this.vendorCompanyName = vendorCompanyName;
	this.userName = userName;
	this.userPasword = userPasword;
	this.totalTenderTakeOver = totalTenderTakeOver;
	this.experienceInYears = experienceInYears;
}

public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}



public String getVendorCompanyName() {
	return vendorCompanyName;
}



public void setVendorCompanyName(String vendorCompanyName) {
	this.vendorCompanyName = vendorCompanyName;
}



public String getUserName() {
	return userName;
}



public void setUserName(String userName) {
	this.userName = userName;
}



public String getUserPasword() {
	return userPasword;
}



public void setUserPasword(String userPasword) {
	this.userPasword = userPasword;
}



public int getTotalTenderTakeOver() {
	return totalTenderTakeOver;
}



public void setTotalTenderTakeOver(int totalTenderTakeOver) {
	this.totalTenderTakeOver = totalTenderTakeOver;
}



public int getExperienceInYears() {
	return experienceInYears;
}



public void setExperienceInYears(int experienceInYears) {
	this.experienceInYears = experienceInYears;
}



public List<Tender> getBidForList() {
	return bidForList;
}



public void setBidForList(List<Tender> bidForList) {
	this.bidForList = bidForList;
}



public List<Tender> getTenderList() {
	return tenderList;
}



public void setTenderList(List<Tender> tenderList) {
	this.tenderList = tenderList;
}


}
