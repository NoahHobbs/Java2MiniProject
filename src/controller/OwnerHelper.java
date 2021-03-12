package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;
import model.Pets;



public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Java2MiniProject");
	public List<Pets> getPetsByOwnerId(int id) {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Pets> typedQuery = em.createQuery("SELECT p FROM pet p WHERE p.ownerId == :id" , Pets.class);
		typedQuery.setParameter("id", id);
		List<Pets> allPets = typedQuery.getResultList();
		return allPets;
	}
	public List<Owner> getAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		return em.createQuery("SELECT o FROM owner o").getResultList();
	}
}
