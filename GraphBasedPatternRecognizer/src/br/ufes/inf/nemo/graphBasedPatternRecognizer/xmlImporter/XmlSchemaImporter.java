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
import br.ufes.inf.nemo.ontoUml.model.Collective;
import br.ufes.inf.nemo.ontoUml.model.Generalization;
import br.ufes.inf.nemo.ontoUml.model.InstantiableTypes;
import br.ufes.inf.nemo.ontoUml.model.Kind;
import br.ufes.inf.nemo.ontoUml.model.Mixin;
import br.ufes.inf.nemo.ontoUml.model.Mode;
import br.ufes.inf.nemo.ontoUml.model.Phase;
import br.ufes.inf.nemo.ontoUml.model.Quality;
import br.ufes.inf.nemo.ontoUml.model.Quantity;
import br.ufes.inf.nemo.ontoUml.model.Relator;
import br.ufes.inf.nemo.ontoUml.model.Role;
import br.ufes.inf.nemo.ontoUml.model.RoleMixin;
import br.ufes.inf.nemo.ontoUml.model.SubKind;
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

		ModelingElement modelingElement = null;
		ModelingElementType modelingElementType;

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
					// TODO tenho que fazer diferente aqui. O caso de
					// generalizacao tenho que j� colocar os nomes e adicionar
					// no SpecificModel para cada iteracao
					modelingElement = new Generalization();
					((Generalization) modelingElement)
							.setOrigin((Class) specificModel.getModelingElements().get(element1));
					((Generalization) modelingElement)
							.setDestiny((Class) specificModel.getModelingElements().get(element2));
				}

				break;

			// Associations
			case InstantiableTypes.CHARACTERIZATION:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.MEDIATION:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.DERIVATION:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.DOMAINFORMALRELATION:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.MATERIALRELATION:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.COMPONENTOF:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.MEMBEROF:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.SUBCOLECTIONOF:
				// TODO implementar
				modelingElement = null;
				break;
			case InstantiableTypes.SUBQUANTITYOF:
				// TODO implementar
				modelingElement = null;
				break;

			default:
				modelingElement = null;
				break;
			}

			if (modelingElement != null) {
				modelingElement.setName(name);

				modelingElementType = new ModelingElementType();
				modelingElementType.setName(type);

				modelingElement.setModelingElementType(modelingElementType);

				specificModel.getModelingElements().add(modelingElement);
				specificModel.getModelingElementTypes().add(modelingElementType);
			}
		}

		return specificModel;

	}

	public File loadXmlFile(String path) throws FileNotFoundException {
		File file = new File(path);

		return file;
	}

}
