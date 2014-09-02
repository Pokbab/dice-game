package com.baron.dicegame.main;

import com.baron.dicegame.Judge;
import com.baron.dicegame.Recorder;
import com.baron.dicegame.dice.Dice;
import com.baron.dicegame.dice.FraudDice;
import com.baron.dicegame.player.FraudPlayer;
import com.baron.dicegame.player.Player;

public class DiceGame {
	
	private static final int ROUND_COUNT = 5; //한 게임의 라운드 수

	public static void main(String[] args) {

		Judge judge = new Judge(new Recorder());
		Player player= createPlayer(args);
		FraudPlayer computer = new FraudPlayer("컴퓨터", new FraudDice(), player);
		
		judge.registerPlayer(computer);
		judge.registerPlayer(player);
		judge.playGame(ROUND_COUNT);
	}

	private static Player createPlayer(String[] args) {
		
		String playerName = (args.length == 0)? "익명희망" : args[0];
		
		return new Player(playerName, new Dice());
	}

}
