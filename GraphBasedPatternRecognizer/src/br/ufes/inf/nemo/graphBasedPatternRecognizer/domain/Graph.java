package br.ufes.inf.nemo.graphBasedPatternRecognizer.domain;

import java.util.Set;

public class Graph {

	private String id;
	private Set<Graph> subGraphs;
	private Set<Node> nodes;
	private Set<Edge> edges;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Graph> getSubGraphs() {
		return subGraphs;
	}

	public void setSubGraphs(Set<Graph> subGraphs) {
		this.subGraphs = subGraphs;
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

}
