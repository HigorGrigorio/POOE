package com.purchaseapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import com.purchaseapp.models.Client;

public class ClientDAO {
	private EntityManager entityManager;
	
	public ClientDAO(EntityManager entityManager) {
		this.setEntityManager(entityManager);
	}
	
	public void add(Client obj) {		
		getEntityManager().persist(obj);
	}
	
	public Client update(Client obj) { 
		return getEntityManager().merge(obj);
	}
	
	public void deleteById(Long id) {
		Client client = getById(id);
		getEntityManager()
			.remove(client);
	}
	
	public void delete(Client obj) {
		getEntityManager()
			.remove(obj);
	}
	
	public Client getById(Long id) {
		return getEntityManager()
				.find(Client.class, id);
	}
	
	public List<Client> getAll() {		
		return getEntityManager()
				.createQuery("select c from Client c", Client.class)
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
	
	public List<Client> getByName(String value) {
		return getEntityManager()
				.createQuery("select c from Client c where c.name = :name", Client.class)
				.setParameter("name", value)
				.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	} 
	
}
