package br.ufes.inf.nemo.graphBasedPatternRecognizer.domain;

public class Edge {
	private String label;
	private Node origin;
	private Node destination;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Node getOrigin() {
		return origin;
	}

	public void setOrigin(Node origin) {
		this.origin = origin;
	}

	public Node getDestination() {
		return destination;
	}

	public void setDestination(Node destination) {
		this.destination = destination;
	}

}
