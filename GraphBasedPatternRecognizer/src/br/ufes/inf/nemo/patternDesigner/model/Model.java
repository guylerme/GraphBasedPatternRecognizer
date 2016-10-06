package br.ufes.inf.nemo.patternDesigner.model;

public class Model {

	private String name;
	private ReferenceModel referenceModel;
	private SpecificModel specificModel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReferenceModel getReferenceModel() {
		return referenceModel;
	}

	public void setReferenceModel(ReferenceModel referenceModel) {
		this.referenceModel = referenceModel;
	}

	public SpecificModel getSpecificModel() {
		return specificModel;
	}

	public void setSpecificModel(SpecificModel specificModel) {
		this.specificModel = specificModel;
	}

}
