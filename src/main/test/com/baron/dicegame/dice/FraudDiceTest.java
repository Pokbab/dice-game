package com.baron.dicegame.dice;

import static org.junit.Assert.*;

import org.junit.Test;

import com.baron.dicegame.Mode;


public class FraudDiceTest {

	@Test
	public void testCast_normal_mode() throws Exception {
		//Given
		FraudDice dice = new FraudDice();

		//When
		int actual = dice.cast();
		
		//Then
		assertTrue(actual > 0 || actual < 7);
	}
	
	@Test
	public void testCast_strong_mode() throws Exception {
		//Given
		FraudDice dice = new FraudDice();
		dice.setMode(Mode.STRONG);
		
		//When
		int actual = dice.cast();
		
		//Then
		assertTrue(actual > 2 || actual < 7);
	}
	
	@Test
	public void testCast_weak_mode() throws Exception {
		//Given
		FraudDice dice = new FraudDice();
		dice.setMode(Mode.WEAK);
		
		//When
		int actual = dice.cast();
		
		//Then
		assertTrue(actual > 0 || actual < 5);
	}
}
