package com.purchaseapp.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.purchaseapp.dao.UserDAO;
import com.purchaseapp.models.User;
import com.purchaseapp.models.User;
import com.purchaseapp.persistence.ConnectionDataBank;

public class UserService {
	@PersistenceContext(unitName="purchaseapp")
	 private final EntityManager entityManager;
	 
	 public UserService() {
		 entityManager = ConnectionDataBank.getConnection().getEntityManager();
	 }
	 
	 public void showConnectionBank() {
		 EntityTransaction transaction = entityManager.getTransaction();
		 
		 if(entityManager != null) {
			 System.out.println(entityManager.toString());
		 }
		 
		 if (transaction != null)
		 {
			 System.out.println("Connectado!");
		 }
	 }

	 public User add(User obj) {		
			return null;	
		}
		
		public User update() { 
			return null; 
		}
		
		public void deleteById() {
		}
		
		public void delete(User obj) {
		}
		
		public User getById() {
			return null;
		}
		
		public List<User> getAll() {
			return null;
		}
		
		public List<User> getAllSortedByName() {
			return null;
		} 
}
