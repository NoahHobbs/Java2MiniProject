package controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PetsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Java2MiniProject");
	
}
