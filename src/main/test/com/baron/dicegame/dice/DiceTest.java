package com.baron.dicegame.dice;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testCast() throws Exception {
		//Given
		Dice dice = new Dice();

		//When
		int actual = dice.cast();

		//Then
		assertTrue(actual > 0 || actual < 7);
	}
}
