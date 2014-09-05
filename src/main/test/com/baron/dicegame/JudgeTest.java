package com.baron.dicegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.baron.dicegame.dice.Dice;
import com.baron.dicegame.player.Player;


public class JudgeTest {
	private Judge judge;
	
	@Before
	public void setUp() throws Exception {
		judge = new Judge(new Recorder());
		judge.registerPlayer(new Player("홍길동", new Dice()));
		judge.registerPlayer(new Player("김가네", new Dice()));
	}
	
	@Test
	public void testPlayGame() throws Exception {
		//Given
		

		//When
		judge.playGame(3);
		
		
		
		//Then

	}
}
