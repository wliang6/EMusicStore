package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

/**
 * EMusicStore
 * @author Winnie Nov 17, 2016
 * ProductDaoImpl.java
 */

@Repository //Controller, Repository, Service - 3 similar annotations -- they all register this class to Spring container
@Transactional //Spring Hibernate would know how to deal with this transaction
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory; //defined in applicationContext.xml
	
	
	
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush(); //session update will be executed
	}
	
	
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush(); //session update will be executed
	}


	public Product getProductByID(String productID) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, productID);
		session.flush();
		return product;
	}


	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();
		return products;
	}


	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductByID(id));
		session.flush();
	}




}
