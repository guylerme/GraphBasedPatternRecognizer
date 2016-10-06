package br.ufes.inf.nemo.graphBasedPatternRecognizer.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import br.ufes.inf.nemo.graphBasedPatternRecognizer.graphConverter.GraphConverter;
import br.ufes.inf.nemo.graphBasedPatternRecognizer.patternGenerator.PatternModelGenerator;
import br.ufes.inf.nemo.graphBasedPatternRecognizer.xmlImporter.XmlSchemaImporter;
import br.ufes.inf.nemo.patternDesigner.model.ReferenceModel;

public class GraphConverterTest {

	@Test
	public final void test() {

	}

	@Test
	public final void convertToGraphTest() {
		GraphConverter g = new GraphConverter();

		XmlSchemaImporter x = new XmlSchemaImporter();

		//String path = "C:/Users/cy85/Documents/Doutorado/Tese/Graph Based Pattern Recognizer/example1.refontouml";
		String path = "/Users/Guylerme/Documents/Guylerme/Estudo/Doutorado/Tese/Graph Grammar/example1.refontouml";

		try {
			g.convertToGraph(x.importXmlSchemaToModel(x.loadXmlFile(path)));
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public final void generateGraphsForPatternsTest() {
		GraphConverter g = new GraphConverter();

		PatternModelGenerator p = new PatternModelGenerator();

		ReferenceModel model = p.generateReferenceModel();

		assertNotNull(g.generateGraphsForPatterns(model));

	}

}
