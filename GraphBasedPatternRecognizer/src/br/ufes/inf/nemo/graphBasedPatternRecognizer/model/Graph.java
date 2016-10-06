package br.ufes.inf.nemo.graphBasedPatternRecognizer.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private String id;
	private List<Graph> subGraphs;
	private List<Node> nodes;
	private List<Edge> edges;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Graph> getSubGraphs() {
		if (subGraphs == null)
			subGraphs = new ArrayList<Graph>();
		return subGraphs;
	}

	public void setSubGraphs(List<Graph> subGraphs) {
		this.subGraphs = subGraphs;
	}

	public List<Node> getNodes() {
		if (nodes == null)
			nodes = new ArrayList<Node>();

		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		if (edges == null)
			edges = new ArrayList<Edge>();
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}
