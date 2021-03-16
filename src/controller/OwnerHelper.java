package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;
import model.Pets;


@SuppressWarnings("unused")
public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Java2MiniProject");
	public List<Pets> getPetsByOwnerId(int id) {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Pets> q = em.createQuery("SELECT p FROM Pets p WHERE p.owner.id = :i", Pets.class);
		q.setParameter("i", id);
		List<Pets> allPets = q.getResultList();
		
		return allPets;
	}
	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		return em.createQuery("SELECT o FROM Owner o").getResultList();
	}
	public void insertOwner(Owner owner) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(owner);
		em.getTransaction().commit();
		em.close();
	}
	public void deleteOwner(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select p from Owner p where p.id = :selectedId", Owner.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", id);

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		Owner result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public Owner searchForOwnerById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Owner found = em.find(Owner.class, id);
		em.close();
		return found;
	}
	public void editOwner(Owner owner, String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		owner.setOwnerName(name);
		em.merge(owner);
		em.getTransaction().commit();
		em.close();
	}
}
