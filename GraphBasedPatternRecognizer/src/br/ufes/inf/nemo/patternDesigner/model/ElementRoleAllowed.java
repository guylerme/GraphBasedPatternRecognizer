package br.ufes.inf.nemo.patternDesigner.model;

import java.util.List;

public class ElementRoleAllowed {

	private String name;
	private List<ModelingElementType> modelingElementTypes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ModelingElementType> getModelingElementTypes() {
		return modelingElementTypes;
	}

	public void setModelingElementTypes(
			List<ModelingElementType> modelingElementTypes) {
		this.modelingElementTypes = modelingElementTypes;
	}
}
