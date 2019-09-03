package edu.depaul.se433.skeleton;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static edu.depaul.se433.StringUtil.pluralize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
	@Test
	@DisplayName("y ending -> ies ending")
	void yPlural() {
		String x= pluralize("puppy");
		assertEquals("puppies",x);
	}
	@Test
	@DisplayName("s ending -> es ending")
	void sEsPlural() {
		String x= pluralize("bus");
		assertEquals("buses",x);
	}
	@Test
	@DisplayName("ch ending -> es ending")
	void chEsPlural() {
		String x= pluralize("sandwich");
		assertEquals("sandwiches",x);
	}
	@Test
	@DisplayName("sh ending -> es ending")
	void shEsPlural() {
		String x= pluralize("dish");
		assertEquals("dishes",x);
	}
	@Test
	@DisplayName("ss ending -> es ending")
	void ssEsPlural() {
		String x= pluralize("truss");
		assertEquals("trusses",x);
	}
	@Test
	@DisplayName("s ending -> es ending")
	void zEsPlural() {
		String x= pluralize("blitz");
		assertEquals("blitzes",x);
	}
	@Test
	@DisplayName("Special Case z ending -> ss, es ending")
	void zzEsPlural() {
		String x= pluralize("fez");
		assertEquals("fezzes",x);
	}
	@Test
	@DisplayName("Special Case s ending -> ss, es ending")
	void ssSpecialEsPlural() {
		String x= pluralize("gas");
		assertEquals("gasses",x);
	}
	@Test
	@DisplayName("f ending -> ves ending")
	void fVesPlural() {
		String x= pluralize("wolf");
		assertEquals("wolves",x);
	}
	@Test
	@DisplayName("fe ending -> ves ending")
	void feVesPlural() {
		String x= pluralize("wife");
		assertEquals("wives",x);
	}
	@Test
	@DisplayName("Special Case f ending -> s ending")
	void fSpecialSPlural() {
		String x= pluralize("roof");
		assertEquals("roofs",x);
	}
	@Test
	@DisplayName("Consonant+ y ending -> s ending")
	void consYSPlural() {
		String x= pluralize("ray");
		assertEquals("rays",x);
	}
	@Test
	@DisplayName("Consonant+ y ending -> s ending")
	void consEYSPlural() {
		String x= pluralize("key");
		assertEquals("keys",x);
	}
	@Test
	@DisplayName("Consonant+ y ending -> s ending")
	void consOYSPlural() {
		String x= pluralize("boy");
		assertEquals("boys",x);
	}
	@Test
	@DisplayName("Consonant+ y ending -> s ending")
	void consUYSPlural() {
		String x= pluralize("guy");
		assertEquals("guys",x);
	}
	@Test
	@DisplayName("o ending -> es ending")
	void oEsPlural() {
		String x= pluralize("potato");
		assertEquals("potatoes",x);
	}
	@Test
	@DisplayName("o ending -> s ending")
	void oSpecialSPlural() {
		String x= pluralize("photo");
		assertEquals("photos",x);
	}
	@Test
	@DisplayName("us ending -> i ending")
	void usIPlural() {
		String x= pluralize("octopus");
		assertEquals("octopi",x);
	}
	@Test
	@DisplayName("is ending -> es ending")
	void isEsPlural() {
		String x= pluralize("analysis");
		assertEquals("analyses",x);
	}
	@Test
	@DisplayName("on ending -> a ending")
	void onAPlural() {
		String x= pluralize("phenomenon");
		assertEquals("phenomena",x);
	}
	@Test
	@DisplayName("no change")
	void noChangePlural() {
		String x= pluralize("sheep");
		assertEquals("sheep",x);
	}
	@Test
	@DisplayName("Special Case child -> children")
	void specialPlural() {
		String x= pluralize("child");
		assertEquals("children",x);
	}
	@Test
	@DisplayName("Special Case man -> men")
	void specialPlural2() {
		String x= pluralize("man");
		assertEquals("men",x);
	}
	@Test
	@DisplayName("Error invalid state input")
	void invalidState()
	{
		
		boolean thrown = false;
		try {
			String x = pluralize(null);
			
		}
		catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
		
	}
}

