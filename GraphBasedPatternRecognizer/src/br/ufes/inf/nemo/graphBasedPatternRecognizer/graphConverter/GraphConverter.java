package br.ufes.inf.nemo.graphBasedPatternRecognizer.graphConverter;

import java.util.ArrayList;
import java.util.List;

import br.ufes.inf.nemo.graphBasedPatternRecognizer.model.Edge;
import br.ufes.inf.nemo.graphBasedPatternRecognizer.model.Graph;
import br.ufes.inf.nemo.graphBasedPatternRecognizer.model.Node;
import br.ufes.inf.nemo.patternDesigner.model.Association;
import br.ufes.inf.nemo.patternDesigner.model.AssociationElementRoleAllowed;
import br.ufes.inf.nemo.patternDesigner.model.ElementRoleAllowed;
import br.ufes.inf.nemo.patternDesigner.model.ModelingElement;
import br.ufes.inf.nemo.patternDesigner.model.PatternType;
import br.ufes.inf.nemo.patternDesigner.model.ReferenceModel;
import br.ufes.inf.nemo.patternDesigner.model.SpecificModel;
import br.ufes.inf.nemo.patternDesigner.model.Class;

public class GraphConverter {

	public Graph convertToGraph(SpecificModel model) {

		Graph graph = new Graph();

		Node node;

		Edge edge1, edge2;

		Class c;
		Association a;

		for (ModelingElement e : model.getModelingElements()) {
			if (e instanceof Class) {
				c = (Class) e;

				node = new Node();
				node.setName(c.getName());
				node.setLabel(c.getModelingElementType().getName());

				graph.getNodes().add(node);
			}

		}

		for (ModelingElement e : model.getModelingElements()) {
			if (e instanceof Association) {
				a = (Association) e;

				node = new Node();
				node.setName(a.getName());
				node.setLabel(a.getModelingElementType().getName());

				edge1 = new Edge();
				edge2 = new Edge();

				for (Node n : graph.getNodes()) {
					if (a.getOrigin().getName().equalsIgnoreCase(n.getName())) {
						edge1.setOrigin(n);
						edge1.setDestination(node);
					}
				}

				for (Node n : graph.getNodes()) {
					if (a.getDestiny().getName().equalsIgnoreCase(n.getName())) {
						edge2.setOrigin(node);
						edge2.setDestination(n);
					}
				}

				graph.getEdges().add(edge1);
				graph.getEdges().add(edge2);

			}

		}

		return graph;
	}

	public List<Graph> generateGraphsForPatterns(ReferenceModel referenceModel) {

		List<Graph> graphs = new ArrayList<Graph>();

		Graph graph;

		Node node;

		Edge edge1, edge2;

		AssociationElementRoleAllowed associationElementRoleAllowed;

		for (PatternType patternType : referenceModel.getPatternTypes()) {
			graph = new Graph();

			for (ElementRoleAllowed elementRoleAllowed : patternType
					.getElementRolesAllowed()) {
				if (elementRoleAllowed instanceof AssociationElementRoleAllowed) {
					associationElementRoleAllowed = (AssociationElementRoleAllowed) elementRoleAllowed;

					node = new Node();
					node.setName(associationElementRoleAllowed.getName());
					node.setLabel(associationElementRoleAllowed.getName());

					edge1 = new Edge();
					edge2 = new Edge();

					for (Node n : graph.getNodes()) {
						if (associationElementRoleAllowed.getSource().getName()
								.equalsIgnoreCase(n.getName())) {
							edge1.setOrigin(n);
							edge1.setDestination(node);
						}
					}

					for (Node n : graph.getNodes()) {
						if (associationElementRoleAllowed.getTarget().getName()
								.equalsIgnoreCase(n.getName())) {
							edge2.setOrigin(node);
							edge2.setDestination(n);
						}
					}

					graph.getEdges().add(edge1);
					graph.getEdges().add(edge2);

					graph.getNodes().add(node);
				} else {

					node = new Node();
					node.setName(elementRoleAllowed.getName());
					node.setLabel(elementRoleAllowed.getName());

					graph.getNodes().add(node);

				}

			}

			graphs.add(graph);
		}

		return graphs;
	}
}
