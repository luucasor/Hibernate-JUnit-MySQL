package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {

	private static EntityManagerFactory instanceFactory;

	public static EntityManager getEntityManager() {

		if(instanceFactory == null){
			instanceFactory = Persistence.createEntityManagerFactory("webtreePU");
		}

		return instanceFactory.createEntityManager();
	}
}
