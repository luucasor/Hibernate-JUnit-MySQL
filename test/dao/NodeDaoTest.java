package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import model.Node;

public class NodeDaoTest {

	Node tree = null;
	
	@Before
	public void setUp(){
		this.tree = new Node();
		this.tree.setCode(001);
		this.tree.setDescription("Casa");
		this.tree.setNote("Nó criado para casa");
		this.tree.setParent(null);
	}
	
	@Test
	public void saveTest() {
		this.tree.setId(new NodeDao().save(this.tree));
		Assert.assertTrue(this.tree.getId() != null);
	}
	
	@After
	public void deleteTest(){
		Assert.assertTrue(new NodeDao().delete(this.tree));
	}

}
