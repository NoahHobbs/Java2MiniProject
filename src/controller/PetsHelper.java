package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pets;

public class PetsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Java2MiniProject");
	
	public List<Pets> showAllPets(){
		// this method gets all items inside my database puts them in a list and then returns them
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Pets> allPets = em.createQuery("SELECT p FROM Pets p").getResultList();
		return allPets;
	}
	
	public void insertPet(Pets pet) {
		// This method inserts cars into my database
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pet);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deletePet(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pets> typedQuery = em.createQuery("select p from Pets p where p.id = :selectedId", Pets.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", id);

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		Pets result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
