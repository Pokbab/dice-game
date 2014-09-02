package com.baron.dicegame.player;

import static org.junit.Assert.*;

import org.junit.Test;

import com.baron.dicegame.dice.Dice;
import com.baron.dicegame.dice.FraudDice;


public class FraudPlayerTest {

	@Test
	public void testPrepare() throws Exception {
		//Given
		Player rival = new Player("지우", new Dice());
		FraudPlayer player = new FraudPlayer("피카츄", new FraudDice(), rival);

		//When
		
		
		//Then

	}
}
