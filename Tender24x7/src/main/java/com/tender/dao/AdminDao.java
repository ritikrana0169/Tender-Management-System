package com.tender.dao;

import java.util.List;
import java.util.Scanner;

import com.tender.entity.Tender;
import com.tender.entity.Vendor;

public interface AdminDao {

	public List<Vendor> getAllVendors();
	public void createTender(Scanner sc);
	public List<Tender> getAllTenders();
}
