package com.baron.dicegame;

import java.util.ArrayList;
import java.util.List;

import com.baron.dicegame.player.Player;

public class Judge {

	private List<Player> allPlayers = new ArrayList<Player>();
	private Recorder recorder;
	
	public Judge(Recorder recorder) {
		this.recorder = recorder;
	}
	
	public void registerPlayer(Player player){
		allPlayers.add(player);
	}
	
	public void playGame(int roundCount){
		clearScroes();
		for (int i = 0; i < roundCount; i++) {
			playOneRound();
			recorder.printScores(allPlayers);
		}
		recorder.printWinner(getWinner());
	}

	private void clearScroes() {
		for (int i = 0; i < allPlayers.size(); i++) {
			Player player = (Player) allPlayers.get(i);
			player.clearTotalScore();
		}
	}

	private void playOneRound() {
		//순서대로 주사위를 던질 준비를 시킨다
		for (int i = 0; i < allPlayers.size(); i++) {
			Player player = (Player) allPlayers.get(i);
			player.prepare();
		}
		
		//순서대로 주사위를 던진다
		for (int i = 0; i < allPlayers.size(); i++) {
			Player player = (Player) allPlayers.get(i);
			player.play();
		}
	}
	
	//승자를 판정한다(무승부일 때의 반환값은 null)
	public Player getWinner(){
		//가장 높은 점수의 플레이어를 선택한다
		List<Player> winners = getPlayers(getHighScore());
		
		//한 사람일 때는 승자를 리턴하고, 두 사람일 때는 무승부
		if (winners.size() == 1) {
			return winners.get(0);
		}else {
			return null;
		}
	}

	private int getHighScore() {
		int highScore = Integer.MIN_VALUE;
		
		for (int i = 0; i < allPlayers.size(); i++) {
			
			Player player = (Player) allPlayers.get(i);
			
			if (player.getTotalScore() > highScore) {
				
				highScore = player.getTotalScore();
			}
		}
		return highScore;
	}
	
	private List<Player> getPlayers(int highScore) {
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < allPlayers.size(); i++) {
			Player player = (Player) allPlayers.get(i);
			if (player.getTotalScore() == highScore) {
				players.add(player);
			}
		}
		return players;
	}
}
