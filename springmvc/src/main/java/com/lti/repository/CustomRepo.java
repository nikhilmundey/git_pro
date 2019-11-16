package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;

//Another name for Dao
//Instead of @Component, suggestion is to use @Repository

@Repository
public class CustomRepo {
	@PersistenceContext
	private EntityManager entityManager;
	@Transactional
	public void add(Customer customer){
		
		entityManager.persist(customer);
	}

}
