package br.ufes.inf.nemo.graphBasedPatternRecognizer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufes.inf.nemo.graphBasedPatternRecognizer.patternGenerator.PatternModelGenerator;

public class PatternModelGeneratorTest {

	PatternModelGenerator pmg = new PatternModelGenerator();

	@Test
	public final void generateRelatorPatternTest() {
		assertNotNull(pmg.generateRelatorPattern());
	}

	@Test
	public final void generateKindPartitionPatternTest() {
		assertNotNull(pmg.generateKindPartitionPattern());
	}

	@Test
	public final void generateSubKindPartitionPatternTest() {
		assertNotNull(pmg.generateSubkindPartitionPattern());
	}

	@Test
	public final void generateRolPartitionPatternTest() {
		assertNotNull(pmg.generateRolePartitionPattern());
	}

	@Test
	public final void generatePhasePartitionPatternTest() {
		assertNotNull(pmg.generatePhasePartitionPattern());
	}

	@Test
	public final void generateQuantityPartitionPatternTest() {
		assertNotNull(pmg.generateQuantityPartitionPattern());
	}

}
