package com.purchaseapp.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.purchaseapp.dao.ClientDAO;
import com.purchaseapp.models.Client;
import com.purchaseapp.persistence.ConnectionDataBank;

public class ClientService {
	
	@PersistenceContext(unitName="purchaseapp")
	private final EntityManager entityManager;
	
	private ClientDAO dao;

	private EntityTransaction tx;
	
	public ClientService() {
		this.entityManager = ConnectionDataBank
				.getConnection()
				.getEntityManager();
		
		this.dao = new ClientDAO(entityManager);
	}

	public void add(Client obj) {		
		tx = getEntityManager().getTransaction();
		
		try {
			getTx().begin();
			getDao().add(obj);
			getTx().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			if(getTx().isActive()) {
				getTx().rollback();
			}
		} finally {
			getEntityManager().close();
		}
	}
	
	public Client update(Client obj) {		
		tx = getEntityManager().getTransaction();
		
		try {
			getTx().begin();
			Client client = getDao().update(obj);
			getTx().commit();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			
			if(getTx().isActive()) {
				getTx().rollback();
			}
		} finally {
			getEntityManager().close();
		}
		return null;
	}
	
	public void deleteById() {
	}
	
	public void delete(Client client) {
	}
	
	public Client getById(Long id) {
		return getDao().getById(id);

	}
	
	public List<Client> getAll() {
		return null;
	}
	
	public List<Client> getAllSortdByName() {
		return null;
	} 
	
	public EntityTransaction getTx() {
		return tx;
	}

	public void setTx(EntityTransaction tx) {
		this.tx = tx;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public ClientDAO getDao() {
		return dao;
	}

	public void setDao(ClientDAO dao) {
		this.dao = dao;
	}
}