package com.tender.dao;

import java.util.List;
import java.util.Scanner;

import com.tender.entity.Tender;
import com.tender.entity.Vendor;
import com.tender.exception.NoRecordFoundException;

public interface TenderDao {

	public void saveTender(Tender td);
	public List<Tender> getAllTenders();
	public List<Tender> getAllOpenTenders();
	public List<Tender> biddingForTender(Vendor vendor,Scanner sc) throws NoRecordFoundException;
}
