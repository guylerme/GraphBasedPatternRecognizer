package br.ufes.inf.nemo.patternDesigner.model;

import java.util.ArrayList;
import java.util.List;

public class PatternType {

	private String name;
	List<ElementRoleAllowed> elementRolesAllowed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ElementRoleAllowed> getElementRolesAllowed() {
		if (elementRolesAllowed==null)
			elementRolesAllowed = new ArrayList<ElementRoleAllowed>();
		return elementRolesAllowed;
	}

	public void setElementRolesAllowed(
			List<ElementRoleAllowed> elementRolesAllowed) {
		this.elementRolesAllowed = elementRolesAllowed;
	}

}
