package br.ufes.inf.nemo.patternDesigner.model;

public class ElementRole {

	private String name;
	private ElementRoleAllowed elementRoleAllowed;
	private ModelingElement modelingElement;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ElementRoleAllowed getElementRoleAllowed() {
		return elementRoleAllowed;
	}

	public void setElementRoleAllowed(ElementRoleAllowed elementRoleAllowed) {
		this.elementRoleAllowed = elementRoleAllowed;
	}

	public ModelingElement getModelingElement() {
		return modelingElement;
	}

	public void setModelingElement(ModelingElement modelingElement) {
		this.modelingElement = modelingElement;
	}

}
