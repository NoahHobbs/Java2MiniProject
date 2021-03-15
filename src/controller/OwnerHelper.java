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
		List<Pets> pets = new ArrayList<Pets>(0);
		@SuppressWarnings("unchecked")
		List<Pets> allPets = em.createQuery("SELECT p FROM Pets p").getResultList();
		for (Pets p:allPets){
			try{
				if(p.getOwner().getId() == id) {
					pets.add(p);
				}
			}catch(Exception e) {
				
			}
		}
		return pets;
	}
	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		return em.createQuery("SELECT o FROM Owner o").getResultList();
	}
}
