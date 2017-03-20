package dao;

import javax.persistence.EntityManager;

import model.Node;
import util.Hibernate;

public class NodeDao extends Hibernate {

	NodeDao() {
		super();
	}

	public Long save(Node object) {
		EntityManager entityManager = Hibernate.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			if (object.getId() == null) {
				entityManager.persist(object);
			} else {
				object = entityManager.merge(object);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		
		return object.getId();
	}

	public boolean delete(Node object) {
		EntityManager entityManager = Hibernate.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Node node = entityManager.find(Node.class, object.getId());
			entityManager.remove(node);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return true;
	}
	
	public Node findById(Node object){
		EntityManager entityManager = Hibernate.getEntityManager();
		Node node = null;
		try {
			node = entityManager.find(Node.class, object.getId());
		} finally {
			entityManager.close();
		}
		return node;
	}
}
