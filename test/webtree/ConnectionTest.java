package webtree;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import util.Hibernate;

public class ConnectionTest {
	
	@Test
	public void hibernateDaoOpenConnectionTest() {
		EntityManager em = Hibernate.getEntityManager();
		Assert.assertTrue(em.isOpen());
		em.close();
	}
}
