package com.tender.dao;

import java.util.List;

import com.tender.entity.Tender;

public interface TenderDao {

	public void saveTender(Tender td);
	public List<Tender> getAllTenders();
}
