package br.ufes.inf.nemo.graphBasedPatternRecognizer.patternGenerator;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.nemo.ontoUml.model.InstantiableTypes;
import br.ufes.inf.nemo.patternDesigner.model.AssociationElementRoleAllowed;
import br.ufes.inf.nemo.patternDesigner.model.ElementRoleAllowed;
import br.ufes.inf.nemo.patternDesigner.model.PatternType;
import br.ufes.inf.nemo.patternDesigner.model.ModelingElementType;
import br.ufes.inf.nemo.patternDesigner.model.ReferenceModel;

public class PatternModelGenerator {

	private final String SORTAL_TYPES = InstantiableTypes.KIND + ", " + InstantiableTypes.SUBKIND + ", "
			+ InstantiableTypes.ROLE + ", " + InstantiableTypes.PHASE + ", " + InstantiableTypes.COLLECTIVE + ", "
			+ InstantiableTypes.QUANTITY;
	private final String ROLE_TYPES = InstantiableTypes.ROLE;
	private final String RELATOR_TYPE = InstantiableTypes.RELATOR;
	private final String MATERIAL_RELATION = InstantiableTypes.MATERIALRELATION;
	private final String MEDIATION = InstantiableTypes.MEDIATION;
	private final String GENERALIZATION = InstantiableTypes.GENERALIZATIONSET;

	public PatternType generateRelatorPattern() {

		PatternType patternType = new PatternType();

		patternType.setName("Relator Pattern");

		ElementRoleAllowed substanceSortalA, substanceSortalB, roleA, roleB, relator, materialRelation, mediationA,
				mediationB, generalizationA, generalizationB;

		// Substance Sortal A
		substanceSortalA = new ElementRoleAllowed();
		substanceSortalA.setName("Substance Sortal A");

		substanceSortalA.setModelingElementTypes(this.createModelingElementTypeList(SORTAL_TYPES));

		// Substance Sortal B
		substanceSortalB = new ElementRoleAllowed();
		substanceSortalB.setName("Substance Sortal B");

		substanceSortalB.setModelingElementTypes(this.createModelingElementTypeList(SORTAL_TYPES));

		// Role A
		roleA = new ElementRoleAllowed();
		roleA.setName("Role A");

		roleA.setModelingElementTypes(this.createModelingElementTypeList(ROLE_TYPES));

		// Role B
		roleB = new ElementRoleAllowed();
		roleB.setName("Role B");

		roleB.setModelingElementTypes(this.createModelingElementTypeList(ROLE_TYPES));

		// Relator
		relator = new ElementRoleAllowed();
		relator.setName("Relator");

		relator.setModelingElementTypes(this.createModelingElementTypeList(RELATOR_TYPE));

		// Material Relation
		materialRelation = new AssociationElementRoleAllowed();
		materialRelation.setName("Material Relation");
		((AssociationElementRoleAllowed) materialRelation).setSource(roleA);
		((AssociationElementRoleAllowed) materialRelation).setTarget(roleB);

		materialRelation.setModelingElementTypes(this.createModelingElementTypeList(MATERIAL_RELATION));

		// Mediation A
		mediationA = new AssociationElementRoleAllowed();
		mediationA.setName("Mediation A");
		((AssociationElementRoleAllowed) mediationA).setSource(roleA);
		((AssociationElementRoleAllowed) mediationA).setTarget(relator);

		mediationA.setModelingElementTypes(this.createModelingElementTypeList(MEDIATION));

		// Mediation B
		mediationB = new AssociationElementRoleAllowed();
		mediationB.setName("Mediation B");
		((AssociationElementRoleAllowed) mediationB).setSource(roleB);
		((AssociationElementRoleAllowed) mediationB).setTarget(relator);

		mediationB.setModelingElementTypes(this.createModelingElementTypeList(MEDIATION));

		// Generalization A
		generalizationA = new AssociationElementRoleAllowed();
		generalizationA.setName("Generalization A");
		((AssociationElementRoleAllowed) generalizationA).setSource(roleA);
		((AssociationElementRoleAllowed) generalizationA).setTarget(substanceSortalA);

		generalizationA.setModelingElementTypes(this.createModelingElementTypeList(GENERALIZATION));

		// Generalization B
		generalizationB = new AssociationElementRoleAllowed();
		generalizationB.setName("Generalization B");
		((AssociationElementRoleAllowed) generalizationB).setSource(roleB);
		((AssociationElementRoleAllowed) generalizationB).setTarget(substanceSortalB);

		generalizationB.setModelingElementTypes(this.createModelingElementTypeList(GENERALIZATION));

		// add to pattern type
		patternType.getElementRolesAllowed().add(substanceSortalA);
		patternType.getElementRolesAllowed().add(substanceSortalB);
		patternType.getElementRolesAllowed().add(roleA);
		patternType.getElementRolesAllowed().add(roleB);
		patternType.getElementRolesAllowed().add(relator);
		patternType.getElementRolesAllowed().add(materialRelation);
		patternType.getElementRolesAllowed().add(mediationA);
		patternType.getElementRolesAllowed().add(mediationB);
		patternType.getElementRolesAllowed().add(generalizationA);
		patternType.getElementRolesAllowed().add(generalizationB);

		return patternType;

	}

	public PatternType generateKindPartitionPattern() {
		PatternType patternType = new PatternType();

		patternType.setName("Kind Partition Pattern");

		ElementRoleAllowed general, specific, generalization;

		// General
		general = new ElementRoleAllowed();
		general.setName("General");

		general.setModelingElementTypes(this.createModelingElementTypeList(InstantiableTypes.CATEGORY));

		// Specific
		specific = new ElementRoleAllowed();
		specific.setName("Specific");

		general.setModelingElementTypes(this.createModelingElementTypeList(InstantiableTypes.KIND));

		// Generalization
		generalization = new AssociationElementRoleAllowed();
		generalization.setName("Generalization");
		((AssociationElementRoleAllowed) generalization).setSource(specific);
		((AssociationElementRoleAllowed) generalization).setTarget(general);

		// add to pattern type
		patternType.getElementRolesAllowed().add(general);
		patternType.getElementRolesAllowed().add(specific);
		patternType.getElementRolesAllowed().add(generalization);

		return patternType;
	}

	public PatternType generatePhasePartitionPattern() {
		PatternType patternType = new PatternType();

		patternType.setName("Phase Partition Pattern");

		ElementRoleAllowed sortal, phase, generalization;

		// General
		sortal = new ElementRoleAllowed();
		sortal.setName("Sortal");

		sortal.setModelingElementTypes(this.createModelingElementTypeList(this.SORTAL_TYPES));

		// Specific
		phase = new ElementRoleAllowed();
		phase.setName("Phase");

		sortal.setModelingElementTypes(this.createModelingElementTypeList(InstantiableTypes.PHASE));

		// Generalization
		generalization = new AssociationElementRoleAllowed();
		generalization.setName("Generalization");
		((AssociationElementRoleAllowed) generalization).setSource(phase);
		((AssociationElementRoleAllowed) generalization).setTarget(sortal);

		// add to pattern type
		patternType.getElementRolesAllowed().add(sortal);
		patternType.getElementRolesAllowed().add(phase);
		patternType.getElementRolesAllowed().add(generalization);

		return patternType;
	}

	public PatternType generateQuantityPartitionPattern() {
		PatternType patternType = new PatternType();

		patternType.setName("Quantity Partition Pattern");

		ElementRoleAllowed general, specific, generalization;

		// General
		general = new ElementRoleAllowed();
		general.setName("General");

		general.setModelingElementTypes(this.createModelingElementTypeList(InstantiableTypes.CATEGORY));

		// Specific
		specific = new ElementRoleAllowed();
		specific.setName("Specific");

		general.setModelingElementTypes(this.createModelingElementTypeList(InstantiableTypes.QUANTITY));

		// Generalization
		generalization = new AssociationElementRoleAllowed();
		generalization.setName("Generalization");
		((AssociationElementRoleAllowed) generalization).setSource(specific);
		((AssociationElementRoleAllowed) generalization).setTarget(general);

		// add to pattern type
		patternType.getElementRolesAllowed().add(general);
		patternType.getElementRolesAllowed().add(specific);
		patternType.getElementRolesAllowed().add(generalization);

		return patternType;
	}

	public PatternType generateRolePartitionPattern() {
		PatternType patternType = new PatternType();

		patternType.setName("Role Partition Pattern");

		ElementRoleAllowed sortal, role, generalization;

		// General
		sortal = new ElementRoleAllowed();
		sortal.setName("Sortal");

		sortal.setModelingElementTypes(this.createModelingElementTypeList(this.SORTAL_TYPES));

		// Specific
		role = new ElementRoleAllowed();
		role.setName("Role");

		sortal.setModelingElementTypes(this.createModelingElementTypeList(InstantiableTypes.ROLE));

		// Generalization
		generalization = new AssociationElementRoleAllowed();
		generalization.setName("Generalization");
		((AssociationElementRoleAllowed) generalization).setSource(role);
		((AssociationElementRoleAllowed) generalization).setTarget(sortal);

		// add to pattern type
		patternType.getElementRolesAllowed().add(sortal);
		patternType.getElementRolesAllowed().add(role);
		patternType.getElementRolesAllowed().add(generalization);

		return patternType;
	}

	public PatternType generateSubkindPartitionPattern() {
		PatternType patternType = new PatternType();

		patternType.setName("Subkind Partition Pattern");

		ElementRoleAllowed sortal, subkind, generalization;

		// General
		sortal = new ElementRoleAllowed();
		sortal.setName("Sortal");

		sortal.setModelingElementTypes(this.createModelingElementTypeList(this.SORTAL_TYPES));

		// Specific
		subkind = new ElementRoleAllowed();
		subkind.setName("Subkind");

		sortal.setModelingElementTypes(this.createModelingElementTypeList(InstantiableTypes.KIND + ","
				+ InstantiableTypes.SUBKIND + "," + InstantiableTypes.COLLECTIVE + "," + InstantiableTypes.QUANTITY));

		// Generalization
		generalization = new AssociationElementRoleAllowed();
		generalization.setName("Generalization");
		((AssociationElementRoleAllowed) generalization).setSource(subkind);
		((AssociationElementRoleAllowed) generalization).setTarget(sortal);

		// add to pattern type
		patternType.getElementRolesAllowed().add(sortal);
		patternType.getElementRolesAllowed().add(subkind);
		patternType.getElementRolesAllowed().add(generalization);

		return patternType;
	}

	private List<ModelingElementType> createModelingElementTypeList(String types) {

		List<ModelingElementType> typeList = new ArrayList<ModelingElementType>();

		ModelingElementType mdt;

		for (String type : types.split(",")) {
			mdt = new ModelingElementType();

			mdt.setName(type.trim());

			typeList.add(mdt);
		}

		return typeList;
	}

	//TODO Implementar os demais padrões
	//TODO Rever a questão dos padrões partitions, pois entra o conceito de generalization set, ou seja, para participar do padrão tem que estar na mesma generalization set
	//TODO Mudar a forma de implementar a generalization, criando um novo no generalization set que seja o ponto de contato entre pai e filhos
	//TODO Verificar como verificar padrões de partição para N filhos
	
	
	public ReferenceModel generateReferenceModel() {
		ReferenceModel model = new ReferenceModel();
		model.getPatternTypes().add(this.generateRelatorPattern());

		return model;
	}
}
