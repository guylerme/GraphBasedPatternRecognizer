package br.ufes.inf.nemo.patternDesigner.model;

public abstract class ModelingElement {

	private String name;
	private int id;
	private ModelingElementType modelingElementType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModelingElementType getModelingElementType() {
		return modelingElementType;
	}

	public void setModelingElementType(ModelingElementType modelingElementType) {
		this.modelingElementType = modelingElementType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
