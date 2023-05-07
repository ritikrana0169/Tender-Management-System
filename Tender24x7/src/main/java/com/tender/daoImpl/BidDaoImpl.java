package com.tender.daoImpl;

import java.util.List;

import com.tender.dao.BidDao;
import com.tender.entity.Bid;
import com.tender.utils.DbUtils.GetConnection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class BidDaoImpl implements BidDao{

	@Override
	public void saveBid(Bid bid) {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(em.merge(bid));
		em.getTransaction().commit();
		em.close();
	}
public List<Integer> getTenderIdListForVendor(int id){
	EntityManagerFactory emf=GetConnection.getEmf();
	EntityManager em=emf.createEntityManager();
	Query query=em.createQuery("Select t.forTenderId from Bid t where t.byVendorId=:vendorID");
	query.setParameter("vendorID", id);
	List<Integer> tenderIdList=query.getResultList();
	return tenderIdList;
}
public Integer getBidPriceByTenderIdAndVendorId(int tdId,int vdId) {
	EntityManagerFactory emf=GetConnection.getEmf();
	EntityManager em=emf.createEntityManager();
	Query query=em.createQuery("Select t.price from Bid t where t.byVendorId=:vdID AND t.forTenderId=:tdID");
	query.setParameter("vdID", vdId);
	query.setParameter("tdID", tdId);
	Integer price=(Integer) query.getSingleResult();
	return price;
}
}
