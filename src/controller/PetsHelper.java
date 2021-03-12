package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pets;

public class PetsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Java2MiniProject");
	
	public List<Pets> showAllPets(){
		// this method gets all items inside my database puts them in a list and then returns them
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Pets> allPets = em.createQuery("SELECT p FROM pets p").getResultList();
		return allPets;
	}
}
