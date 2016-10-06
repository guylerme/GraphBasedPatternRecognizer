package br.ufes.inf.nemo.patternDesigner.model;

import java.util.ArrayList;
import java.util.List;

public class ReferenceModel {

	private List<PatternIndividual> patternIndividuals;
	private List<ElementRole> elementRoles;
	private List<PatternType> patternTypes;

	public List<PatternIndividual> getPatternIndividuals() {
		if (patternIndividuals == null)
			patternIndividuals = new ArrayList<PatternIndividual>();
		return patternIndividuals;
	}

	public void setPatternIndividuals(List<PatternIndividual> patternIndividuals) {
		this.patternIndividuals = patternIndividuals;
	}

	public List<ElementRole> getElementRoles() {
		if (elementRoles == null)
			elementRoles = new ArrayList<ElementRole>();
		return elementRoles;
	}

	public void setElementRoles(List<ElementRole> elementRoles) {
		this.elementRoles = elementRoles;
	}

	public List<PatternType> getPatternTypes() {
		if (patternTypes == null)
			patternTypes = new ArrayList<PatternType>();
		return patternTypes;
	}

	public void setPatternTypes(List<PatternType> patternTypes) {
		this.patternTypes = patternTypes;
	}

}
