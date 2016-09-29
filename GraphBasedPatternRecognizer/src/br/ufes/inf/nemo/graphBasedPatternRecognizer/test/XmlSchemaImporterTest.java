package br.ufes.inf.nemo.graphBasedPatternRecognizer.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Test;

import br.ufes.inf.nemo.graphBasedPatternRecognizer.xmlImporter.XmlSchemaImporter;

public class XmlSchemaImporterTest {

	@Test
	public final void loadXmlFileTest() {
		String path = "C:/Users/cy85/Documents/Doutorado/Tese/Graph Based Pattern Recognizer/example1.refontouml";

		XmlSchemaImporter importer = new XmlSchemaImporter();

		try {
			assertNotNull(importer.loadXmlFile(path));
		} catch (FileNotFoundException e) {
			fail("File not found Exception");
		}
	}

	@Test
	public final void importXmlSchemaToModelTest() {
		String path = "C:/Users/cy85/Documents/Doutorado/Tese/Graph Based Pattern Recognizer/example1.refontouml";

		XmlSchemaImporter importer = new XmlSchemaImporter();

		try {
			assertNotNull(importer.importXmlSchemaToModel(importer
					.loadXmlFile(path)));
		} catch (FileNotFoundException e) {
			fail("File not found Exception");
		}
	}
}
