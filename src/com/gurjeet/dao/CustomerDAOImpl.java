package com.gurjeet.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurjeet.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//need to inject SessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> q =session.createQuery("from Customer order by firstName",Customer.class);
		
		//execute query to get list of customers
		List<Customer> customers=q.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer newCust) {
		Session session=sessionFactory.getCurrentSession();
		
		//save/update cust as per for submitted
		session.saveOrUpdate(newCust);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Customer cust=session.get(Customer.class, id);
		return cust;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		
		//create delete query
		Query q=session.createQuery("delete from Customer where id=:custId");
		q.setParameter("custId", id);
		
		//execute query
		q.executeUpdate();
	}
	
	
	

}
