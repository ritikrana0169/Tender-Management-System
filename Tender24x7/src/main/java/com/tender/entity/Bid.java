package com.tender.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bidId;
private int byVendorId;
private int forTenderId;
private int price;
public int getBidId() {
	return bidId;
}
public void setBidId(int bidId) {
	this.bidId = bidId;
}

public int getByVendorId() {
	return byVendorId;
}
public void setByVendorId(int byVendorId) {
	this.byVendorId = byVendorId;
}
public int getForTenderId() {
	return forTenderId;
}
public void setForTenderId(int forTenderId) {
	this.forTenderId = forTenderId;
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
public Bid(int bidId, int byVendorId, int forTenderId, int price) {
	super();
	this.bidId = bidId;
	this.byVendorId = byVendorId;
	this.forTenderId = forTenderId;
	this.price = price;
}
@Override
public String toString() {
	return "Bid [bidId=" + bidId + ", byVendorId=" + byVendorId + ", forTenderId=" + forTenderId + ", price=" + price
			+ "]";
}


}
