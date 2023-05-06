package com.tender.dao;

import java.util.List;

import com.tender.entity.Tender;
import com.tender.entity.Vendor;

public interface VendorDao {

	public Vendor getVendorById(int id);
	public List<Vendor> getAllVendors();
	void saveVendor(Vendor vd);
	
}
