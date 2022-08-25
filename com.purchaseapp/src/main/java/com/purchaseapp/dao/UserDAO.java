package com.purchaseapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.purchaseapp.models.User;

public class UserDAO {
private EntityManager entityManager;
	
	public UserDAO(EntityManager entityManager) {
		this.setEntityManager(entityManager);
	}
	
	public void add(User obj) {		
		getEntityManager()
			.persist(obj);
	}
	
	public User update(User obj) { 
		return getEntityManager()
				.merge(obj);
	}
	
	public void deleteById(Integer id) {
		getEntityManager()
			.remove(getById(id));
	}
	
	public void delete(User obj) {
		getEntityManager()
			.remove(obj);
	}
	
	public User getById(Integer id) {
		return getEntityManager()
				.find(User.class, id);
	}
	
	public List<User> getAll() {		
		return getEntityManager()
				.createQuery("select u from User u", User.class)
				.getResultList();
	}
	
	/**
		@SuppressWarnings("unchecked")
		public List<Client> getAll() {		
			return getEntityManager()
					.createQuery("select c from Client c")
					.getResultList();
		}
	 */
	
	public List<User> getByUserName(String value) {
		return getEntityManager()
				.createQuery("select u from User u where u.username = :username", User.class)
				.setParameter("username", value)
				.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	} 
}
