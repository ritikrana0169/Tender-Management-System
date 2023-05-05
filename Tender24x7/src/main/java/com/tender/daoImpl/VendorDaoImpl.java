package com.tender.daoImpl;

import java.util.List;

import com.tender.dao.VendorDao;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;
import com.tender.utils.DbUtils.GetConnection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class VendorDaoImpl implements VendorDao {

	@Override
	public Vendor getVendorById(int id) {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		Vendor vendor=em.find(Vendor.class, id);
		return vendor;
	}

	@Override
	public List<Vendor> getAllVendors() {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("Select v from Vendor v");
		List<Vendor> vendorList=query.getResultList();
		return vendorList;
	}

}
