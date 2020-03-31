package com.baufest.ingreso.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RepeatedCharactersTest {
	
	private RepeatedCharacters repeatedCharacters = new RepeatedCharacters();

	@Test
	public void isValidSimple() {
		String input = "a3o1oa3";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertTrue(this.repeatedCharacters.isValid("aa3311oo"));
	}
	
	@Test
	public void isValidWithSpaces() {
		String input = " ellemmeennttaall  mmaattssssnn";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertFalse(this.repeatedCharacters.isValid(" eelleemmeennttaall  mmii  qquueerriiddoo  wwaattssoonn"));
	}
	
	@Test
	public void isValidWithExtraChar() {
		String input = "aabbccc";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertFalse(this.repeatedCharacters.isValid("aaabbc"));
	}
}
