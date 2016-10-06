package br.ufes.inf.nemo.patternDesigner.model;

public class AssociationElementRoleAllowed extends ElementRoleAllowed{

	private ElementRoleAllowed source;
	private ElementRoleAllowed target;

	public ElementRoleAllowed getSource() {
		return source;
	}

	public void setSource(ElementRoleAllowed source) {
		this.source = source;
	}

	public ElementRoleAllowed getTarget() {
		return target;
	}

	public void setTarget(ElementRoleAllowed target) {
		this.target = target;
	}

}
