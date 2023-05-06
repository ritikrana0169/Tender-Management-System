package com.tender.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bidId;
private Vendor byVendor;
private Tender forTender;
private int price;
public int getBidId() {
	return bidId;
}
public void setBidId(int bidId) {
	this.bidId = bidId;
}
public Vendor getByVendor() {
	return byVendor;
}
public void setByVendor(Vendor byVendor) {
	this.byVendor = byVendor;
}
public Tender getForTender() {
	return forTender;
}
public void setForTender(Tender forTender) {
	this.forTender = forTender;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Bid() {
	super();
	// TODO Auto-generated constructor stub
}
public Bid(Vendor byVendor, Tender forTender, int price) {
	super();
	this.byVendor = byVendor;
	this.forTender = forTender;
	this.price = price;
}
@Override
public String toString() {
	return "Bid [bidId=" + bidId + ", byVendor=" + byVendor + ", forTender=" + forTender + ", price=" + price + "]";
}

}
