package com.tender.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbUtils {
public static class GetConnection{
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("tenderConnect");

	public static EntityManagerFactory getEmf() {
		return emf;
	}
	

	public static void setEmf(EntityManagerFactory emf) {
		GetConnection.emf = emf;
	}
}
}
