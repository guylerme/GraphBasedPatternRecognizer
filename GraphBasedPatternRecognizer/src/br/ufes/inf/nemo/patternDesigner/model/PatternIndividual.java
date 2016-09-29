package br.ufes.inf.nemo.patternDesigner.model;

import java.util.List;

public class PatternIndividual {
	private String name;
	private List<ModelingElement> modelingElements;
	private PatternType patternType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ModelingElement> getModelingElements() {
		return modelingElements;
	}

	public void setModelingElements(List<ModelingElement> modelingElements) {
		this.modelingElements = modelingElements;
	}

	public PatternType getPatternType() {
		return patternType;
	}

	public void setPatternType(PatternType patternType) {
		this.patternType = patternType;
	}

}
