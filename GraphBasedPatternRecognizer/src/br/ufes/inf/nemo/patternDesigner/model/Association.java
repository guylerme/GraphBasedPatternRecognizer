package br.ufes.inf.nemo.patternDesigner.model;

public class Association extends ModelingElement {

	private ModelingElement origin;
	private ModelingElement destiny;

	public ModelingElement getOrigin() {
		return origin;
	}

	public void setOrigin(ModelingElement origin) {
		this.origin = origin;
	}

	public ModelingElement getDestiny() {
		return destiny;
	}

	public void setDestiny(ModelingElement destiny) {
		this.destiny = destiny;
	}

}
