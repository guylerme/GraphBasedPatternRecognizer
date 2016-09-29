package br.ufes.inf.nemo.patternDesigner.model;

import java.util.List;

public class ReferenceModel {

	private List<PatternIndividual> patternIndividuals;
	private List<ElementRole> elementRoles;

	public List<PatternIndividual> getPatternIndividuals() {
		return patternIndividuals;
	}

	public void setPatternIndividuals(List<PatternIndividual> patternIndividuals) {
		this.patternIndividuals = patternIndividuals;
	}

	public List<ElementRole> getElementRoles() {
		return elementRoles;
	}

	public void setElementRoles(List<ElementRole> elementRoles) {
		this.elementRoles = elementRoles;
	}

}
