package dao;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Node;
import model.Tree;

public class NodeDaoAllTest {
	
	Node node1 = null;
	Node node2 = null;
	Node node3 = null;
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	@Before
	public void setUp(){
		node1 = new Node();
		node1.setCode(001);
		node1.setDescription("Casa");
		node1.setNote("Nó criado para casa");
		node1.setParent(null);
		node1.setId(new NodeDao().save(node1));
		
		node2 = new Node();
		node2.setCode(002);
		node2.setDescription("Carro");
		node2.setNote("Nó criado para carro");
		node2.setParent(null);
		node2.setId(new NodeDao().save(node2));
		
		node3 = new Node();
		node3.setCode(003);
		node3.setDescription("Chevrolet");
		node3.setNote("Nó criado como filho de carro");
		node3.setParent(node2.getId());
		node3.setId(new NodeDao().save(node3));
		
		this.nodes.add(node1);
		this.nodes.add(node2);
		this.nodes.add(node3);
	}
	
	@Test
	public void saveTest() {
		Tree tree = new Tree();
		System.out.println("Tree: "+tree.getNodes().toString());
		Assert.assertTrue(tree.getNodes() != null);
	}
	
	@After
	public void removeAllTest(){
		Boolean del1 = new NodeDao().delete(node1);
		Boolean del2 = new NodeDao().delete(node2);
		Boolean del3 = new NodeDao().delete(node3);
		Assert.assertTrue(del1 && del2 && del3);
	}
}
