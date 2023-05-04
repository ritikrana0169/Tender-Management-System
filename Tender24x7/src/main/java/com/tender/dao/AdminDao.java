package com.tender.dao;

import java.util.List;
import java.util.Scanner;

import com.tender.dto.Tender;
import com.tender.dto.Vendor;

public interface AdminDao {

	public List<Vendor> getAllVendors();
	public void createTender(Scanner sc);
	public List<Tender> getAllTenders();
}
