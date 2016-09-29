package br.ufes.inf.nemo.graphBasedPatternRecognizer.xmlImporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import br.ufes.inf.nemo.ontoUml.model.Category;
import br.ufes.inf.nemo.ontoUml.model.Characterization;
import br.ufes.inf.nemo.ontoUml.model.Collective;
import br.ufes.inf.nemo.ontoUml.model.ComponentOf;
import br.ufes.inf.nemo.ontoUml.model.Derivation;
import br.ufes.inf.nemo.ontoUml.model.DomainFormalRelation;
import br.ufes.inf.nemo.ontoUml.model.Generalization;
import br.ufes.inf.nemo.ontoUml.model.InstantiableTypes;
import br.ufes.inf.nemo.ontoUml.model.Kind;
import br.ufes.inf.nemo.ontoUml.model.MaterialRelation;
import br.ufes.inf.nemo.ontoUml.model.Mediation;
import br.ufes.inf.nemo.ontoUml.model.MemberOf;
import br.ufes.inf.nemo.ontoUml.model.Mixin;
import br.ufes.inf.nemo.ontoUml.model.Mode;
import br.ufes.inf.nemo.ontoUml.model.Phase;
import br.ufes.inf.nemo.ontoUml.model.Quality;
import br.ufes.inf.nemo.ontoUml.model.Quantity;
import br.ufes.inf.nemo.ontoUml.model.Relator;
import br.ufes.inf.nemo.ontoUml.model.Role;
import br.ufes.inf.nemo.ontoUml.model.RoleMixin;
import br.ufes.inf.nemo.ontoUml.model.SubCollectionOf;
import br.ufes.inf.nemo.ontoUml.model.SubKind;
import br.ufes.inf.nemo.ontoUml.model.SubQuantityOf;
import br.ufes.inf.nemo.patternDesigner.model.Association;
import br.ufes.inf.nemo.patternDesigner.model.Class;
import br.ufes.inf.nemo.patternDesigner.model.ModelingElement;
import br.ufes.inf.nemo.patternDesigner.model.ModelingElementType;
import br.ufes.inf.nemo.patternDesigner.model.SpecificModel;

public class XmlSchemaImporter {
	private String path = "C:/Users/cy85/Documents/Doutorado/Tese/Graph Based Pattern Recognizer/example1.refontouml";

	public SpecificModel importXmlSchemaToModel(File fXmlFile) {
		SpecificModel specificModel = new SpecificModel();

		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		try {
			doc = builder.build(fXmlFile);
		} catch (JDOMException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		Element model = doc.getRootElement();

		List<Element> lista = model.getChildren();

		String name;
		String type;

		String element;

		ModelingElement origin, destiny;

		ModelingElement modelingElement = null;
		ModelingElementType modelingElementType;

		int counterId = 0;

		for (Element e : lista) {
			name = e.getAttributeValue("name");
			System.out.println("Nome " + name);

			Namespace XSI = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

			String fullType = e.getAttributeValue("type", XSI);
			type = fullType.split(":")[1];

			System.out.println("Tipo " + type);
			System.out.println("Visibilidade " + e.getAttributeValue("visibility"));

			switch (type.toLowerCase()) {
			// Classes
			case InstantiableTypes.MODE:
				modelingElement = new Mode();
				break;
			case InstantiableTypes.QUALITY:
				modelingElement = new Quality();
				break;
			case InstantiableTypes.RELATOR:
				modelingElement = new Relator();
				break;
			case InstantiableTypes.KIND:
				modelingElement = new Kind();
				break;
			case InstantiableTypes.QUANTITY:
				modelingElement = new Quantity();
				break;
			case InstantiableTypes.COLLECTIVE:
				modelingElement = new Collective();
				break;
			case InstantiableTypes.SUBKIND:
				modelingElement = new SubKind();
				break;
			case InstantiableTypes.PHASE:
				modelingElement = new Phase();
				break;
			case InstantiableTypes.ROLE:
				modelingElement = new Role();
				break;
			case InstantiableTypes.CATEGORY:
				modelingElement = new Category();
				break;
			case InstantiableTypes.MIXIN:
				modelingElement = new Mixin();
				break;
			case InstantiableTypes.ROLEMIXIN:
				modelingElement = new RoleMixin();
				break;

			case InstantiableTypes.GENERALIZATIONSET:
				String generalization = e.getAttributeValue("generalization");
				String[] genPart = generalization.split("//");
				String[] genSubPart;
				int element1 = 0;
				int element2 = 0;
				String element1Txt, element2Txt;
				for (int i = 1; i < genPart.length; i++) {
					genSubPart = genPart[i].split("/");
					element1Txt = genSubPart[0].split("\\.")[1];
					element2Txt = genSubPart[1].split("\\.")[1];
					if (!element1Txt.trim().equals("0"))
						element1 = Integer.parseInt(element1Txt);
					if (!element2Txt.trim().equals("0"))
						element2 = Integer.parseInt(element2Txt);

					modelingElement = new Generalization();
					((Generalization) modelingElement)
							.setOrigin((Class) specificModel.getModelingElements().get(element1));
					((Generalization) modelingElement)
							.setDestiny((Class) specificModel.getModelingElements().get(element2));

					modelingElement.setName(name);
					modelingElement.setId(counterId);

					modelingElementType = new ModelingElementType();
					modelingElementType.setName(type);

					modelingElement.setModelingElementType(modelingElementType);

					specificModel.getModelingElements().add(modelingElement);
					specificModel.getModelingElementTypes().add(modelingElementType);
				}

				counterId++;

				break;

			// Associations
			case InstantiableTypes.CHARACTERIZATION:
				modelingElement = new Characterization();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;
			case InstantiableTypes.MEDIATION:
				modelingElement = new Mediation();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;
			case InstantiableTypes.DERIVATION:
				modelingElement = new Derivation();
				// TODO Derivacao é diferente. Relaciona associacao com classe

				// TODO implementar instanciacao do modelo

				element = e.getChildren().get(0).getAttributeValue("type").split("\\.")[1];
				int intElement = 0;
				if (!element.equalsIgnoreCase("0"))
					intElement = Integer.parseInt(element);

				origin = null;

				for (ModelingElement e1 : specificModel.getModelingElements()) {
					if (e1.getId() == intElement)
						origin = (ModelingElement) e1;

				}

				element = e.getChildren().get(1).getAttributeValue("type").split("\\.")[1];
				intElement = 0;
				if (!element.equalsIgnoreCase("0"))
					intElement = Integer.parseInt(element);

				destiny = null;

				for (ModelingElement e1 : specificModel.getModelingElements()) {
					if (e1.getId() == intElement)
						destiny = (ModelingElement) e1;

				}

				((Association) modelingElement).setOrigin((ModelingElement) origin);
				((Association) modelingElement).setDestiny((ModelingElement) destiny);

				// modelingElement = extractAssociationData(specificModel, e,
				// modelingElement);

				break;
			case InstantiableTypes.DOMAINFORMALRELATION:
				modelingElement = new DomainFormalRelation();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;
			case InstantiableTypes.MATERIALRELATION:
				modelingElement = new MaterialRelation();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;
			case InstantiableTypes.COMPONENTOF:
				modelingElement = new ComponentOf();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;
			case InstantiableTypes.MEMBEROF:
				modelingElement = new MemberOf();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;
			case InstantiableTypes.SUBCOLLECTIONOF:
				modelingElement = new SubCollectionOf();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;
			case InstantiableTypes.SUBQUANTITYOF:
				modelingElement = new SubQuantityOf();
				modelingElement = extractAssociationData(specificModel, e, modelingElement);

				break;

			default:
				modelingElement = null;
				break;
			}

			if ((modelingElement != null) && (!type.equalsIgnoreCase(InstantiableTypes.GENERALIZATIONSET))) {
				modelingElement.setName(name);
				modelingElement.setId(counterId);
				counterId++;

				modelingElementType = new ModelingElementType();
				modelingElementType.setName(type);

				modelingElement.setModelingElementType(modelingElementType);

				specificModel.getModelingElements().add(modelingElement);
				specificModel.getModelingElementTypes().add(modelingElementType);
			}
		}

		return specificModel;

	}

	private ModelingElement extractAssociationData(SpecificModel specificModel, Element e,
			ModelingElement modelingElement) {
		String element;
		ModelingElement origin;
		ModelingElement destiny;

		element = e.getChildren().get(0).getAttributeValue("name");

		origin = null;

		for (ModelingElement e1 : specificModel.getModelingElements()) {
			if (e1.getName().equalsIgnoreCase(element))
				origin = (Class) e1;

		}

		element = e.getChildren().get(1).getAttributeValue("name");

		destiny = null;

		for (ModelingElement e1 : specificModel.getModelingElements()) {
			if (e1.getName().equalsIgnoreCase(element))
				destiny = (Class) e1;

		}

		((Association) modelingElement).setOrigin((Class) origin);
		((Association) modelingElement).setDestiny((Class) destiny);
		return modelingElement;
	}

	public File loadXmlFile(String path) throws FileNotFoundException {
		File file = new File(path);

		return file;
	}

}
