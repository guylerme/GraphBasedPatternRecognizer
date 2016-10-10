package br.ufes.inf.nemo.ontoUml.model;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.nemo.patternDesigner.model.ModelingElement;

public class GeneralizationSet extends ModelingElement {

	private List<ModelingElement> participantElements;

	public List<ModelingElement> getParticipantElements() {
		if (participantElements == null)
			participantElements = new ArrayList<ModelingElement>();
		return participantElements;
	}

	public void setParticipantElements(List<ModelingElement> participantElements) {
		this.participantElements = participantElements;
	}

}
