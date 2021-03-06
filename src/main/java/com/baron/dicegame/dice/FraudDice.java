package com.baron.dicegame.dice;

import com.baron.dicegame.Mode;



public class FraudDice extends Dice {

	private Mode mode = Mode.NORMAL;	//세기를 나타내는 모드
	
	//세기를 조절한다
	public void setMode(Mode mode){
		this.mode = mode;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	@Override
	public int cast() {
		while (true) {
			int score = super.cast();
			if (mode == Mode.STRONG && score <= 2) {
				continue;	//STRONG모드에서 2이하이면 다시 던진다
			}
			if (mode == Mode.WEAK && score >= 5) {
				continue;	//WEAK모드에서 5이상이면 다시 던진다
			}
			return score;
		}
	}
}
