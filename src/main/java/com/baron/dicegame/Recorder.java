package com.baron.dicegame;

import java.util.List;

import com.baron.dicegame.dice.Dice;
import com.baron.dicegame.dice.FraudDice;
import com.baron.dicegame.player.Player;

public class Recorder {

	//모든 플레이어의 스코어를 기록한다
	public void printScores(List<Player> players) {
		System.out.print("[ ");
		
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			System.out.print(player.getName() + ":" + player.getTotalScore() +
					getDiceMode(player.getDice()) + " ");
		}
		
		System.out.println("]");
	}

	//주사위의 상태를 표현하는 문자열을 반환한다
	private String getDiceMode(Dice dice) {
		if (!(dice instanceof FraudDice)) {
			return "";
		}
		
		FraudDice fraudDice = (FraudDice) dice;
		if (fraudDice.getMode() == Mode.NORMAL) {
			return "[NORMAL]";
		}else if (fraudDice.getMode() == Mode.STRONG) {
			return "[STRONG]";
		}else{
			return "[WEAK]";
		}
	}
	
	//승자를 기록한다
	public void printWinner(Player winner){
		if (winner != null) {
			System.out.println(winner.getName() + "의 승리!");
		}else {
			System.out.println("무승부!");
		}
	}
}
