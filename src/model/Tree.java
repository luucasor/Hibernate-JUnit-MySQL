package model;

import java.util.List;

import dao.NodeDao;

public class Tree {

	private List<Node> nodes;
	
	public Tree(){
		this.nodes = new NodeDao().getAllNodes();
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
}
