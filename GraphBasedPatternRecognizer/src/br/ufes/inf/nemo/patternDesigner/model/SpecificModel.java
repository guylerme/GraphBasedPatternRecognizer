package br.ufes.inf.nemo.patternDesigner.model;

import java.util.ArrayList;
import java.util.List;

public class SpecificModel {

	private List<ModelingElement> modelingElements;
	private List<ModelingElementType> modelingElementTypes;

	public List<ModelingElement> getModelingElements() {
		if (modelingElements == null)
			modelingElements = new ArrayList<ModelingElement>();

		return modelingElements;
	}

	public void setModelingElements(List<ModelingElement> modelingElements) {
		this.modelingElements = modelingElements;
	}

	public List<ModelingElementType> getModelingElementTypes() {
		if (modelingElementTypes == null)
			modelingElementTypes = new ArrayList<ModelingElementType>();
		return modelingElementTypes;
	}

	public void setModelingElementTypes(
			List<ModelingElementType> modelingElementTypes) {
		this.modelingElementTypes = modelingElementTypes;
	}

}
