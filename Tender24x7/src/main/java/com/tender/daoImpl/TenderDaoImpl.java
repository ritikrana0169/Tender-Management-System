package com.tender.daoImpl;

import java.util.List;

import com.tender.dao.TenderDao;
import com.tender.entity.Tender;
import com.tender.utils.DbUtils.GetConnection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class TenderDaoImpl implements TenderDao{

	@Override
	public void saveTender(Tender td) {
		EntityManagerFactory emf=GetConnection.getEmf();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(td);
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



}
