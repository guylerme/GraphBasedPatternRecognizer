package br.ufes.inf.nemo.patternDesigner.model;

public class Association extends ModelingElement {

	private Class origin;
	private Class destiny;

	public Class getOrigin() {
		return origin;
	}

	public void setOrigin(Class origin) {
		this.origin = origin;
	}

	public Class getDestiny() {
		return destiny;
	}

	public void setDestiny(Class destiny) {
		this.destiny = destiny;
	}

}
