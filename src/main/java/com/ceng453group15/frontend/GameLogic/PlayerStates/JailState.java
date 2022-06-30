package com.ceng453group15.frontend.GameLogic.PlayerStates;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.TurnObject;

//Player is  in jail
public class JailState implements PlayerState{
    private Player player;
    //this field is special to this state
    private int remainingTurnCount;
    public JailState(Player player){
        this.player = player;
        this.remainingTurnCount = 1;
    }
    @Override
    public void move(int amount) {
        System.out.println("You are in jail");
    }

    @Override
    public boolean buyProperty() {
        System.out.println("You are in jail");
        return false;
    }

    public void getThroughOneTurnSentence(){
        if(remainingTurnCount <= 0){
            //Can get out of jail next turn
            player.setPlayerState(new WaitState(player));
            return;
        }
        remainingTurnCount--;
    }

    public int getRemainingTurnCount(){
        return remainingTurnCount;
    }
}
