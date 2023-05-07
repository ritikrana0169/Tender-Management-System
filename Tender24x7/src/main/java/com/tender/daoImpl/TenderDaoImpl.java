package com.tender.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tender.dao.TenderDao;
import com.tender.entity.Tender;
import com.tender.entity.Vendor;
import com.tender.exception.NoRecordFoundException;
import com.tender.utils.DbUtils.GetConnection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class TenderDaoImpl implements TenderDao{
	BidDaoImpl bidDaoImpl=new BidDaoImpl();
	@Override
	public void saveTender(Tender td) {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(em.merge(td));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Tender> getAllTenders() {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("Select t from Tender t");
		List<Tender> tenderList=query.getResultList();
		return tenderList;
	}

	@Override
	public List<Tender> getAllOpenTenders() {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("Select t from Tender t where t.vendor.vendorId=-1");
		List<Tender> tenderList=query.getResultList();
		return tenderList;
	}

//	@Override
//	public void getAllOpenTendersByVendorId(int id) {
//		EntityManagerFactory emf=GetConnection.getEmf();
//		EntityManager em=emf.createEntityManager();
//		Query query=em.createQuery("Select t from Tender t where t.tenderId=1");
//		Tender tender=(Tender) query.getResultList().get(0);
//		query=em.createQuery("Select t from Vendor t where t.vendorId=1");
//		Vendor vendor=(Vendor) query.getSingleResult();
//		tender.getBidByList().add(vendor);
//		em.getTransaction().begin();
//		em.persist(tender);
//		em.getTransaction().commit();
//		em.close();
//	}
	
	public Tender getTenderByTenderId(int id) {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("Select t from Tender t where t.tenderId=:tenderID");
		query.setParameter("tenderID", id);
		Tender tender=(Tender) query.getSingleResult();
		return tender;
	}
	@Override
	public List<Tender> biddingForTender(Vendor vendor,Scanner sc) throws NoRecordFoundException {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("Select t.tenderId from Tender t where t.vendor.vendorId=-1");
		List<Integer> tenderIdList=query.getResultList();
		List<Tender> customTender=new ArrayList<>();
		List<Integer> bidListByVendor=bidDaoImpl.getTenderIdListForVendor(vendor.getVendorId());
		for(int i=0;i<bidListByVendor.size();i++) {
			tenderIdList.remove(Integer.valueOf(bidListByVendor.get(i)));
		}
		for(int i=0;i<tenderIdList.size();i++) {
			customTender.add(getTenderByTenderId(tenderIdList.get(i)));
		}
//		for(int i=0;i<tenderList.size();i++) {
//			boolean isAvailable=false;
//			for(int j=0;j<tenderList.get(i).getBidByList().size();j++) {
//				
//				if(tenderList.get(i).getBidByList().get(j).getVendorId()==vendor.getVendorId()) {
//					
//					isAvailable=true;
//				}
//			}
//			if(!isAvailable) {
//				customTender.add(tenderList.get(i));
//			}
//		}
		return customTender;
		
	}


}
