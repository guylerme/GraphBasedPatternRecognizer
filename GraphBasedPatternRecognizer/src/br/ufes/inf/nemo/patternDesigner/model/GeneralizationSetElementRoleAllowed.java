package br.ufes.inf.nemo.patternDesigner.model;

import java.util.ArrayList;
import java.util.List;

public class GeneralizationSetElementRoleAllowed extends ElementRoleAllowed {

	List<ElementRoleAllowed> participantElements;

	public List<ElementRoleAllowed> getParticipantElements() {
		if (participantElements == null)
			participantElements = new ArrayList<ElementRoleAllowed>();
		return participantElements;
	}

	public void setParticipantElements(List<ElementRoleAllowed> participantElements) {
		this.participantElements = participantElements;
	}
	
	
}
