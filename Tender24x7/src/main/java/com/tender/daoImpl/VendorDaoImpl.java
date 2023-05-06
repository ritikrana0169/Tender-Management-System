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
	public void saveVendor(Vendor vd) {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(em.merge(vd));
		em.getTransaction().commit();
		em.close();
	}
	
	
	@Override
	public Vendor getVendorById(int id) {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("Select v from Vendor v where v.vendorId=:vendorID");
		query.setParameter("vendorID", id);
		Vendor vendor=(Vendor) query.getSingleResult();
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
