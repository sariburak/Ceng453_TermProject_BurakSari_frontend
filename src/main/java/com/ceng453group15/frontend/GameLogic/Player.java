package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.Board;
import com.ceng453group15.frontend.GameLogic.PlayerStates.DiceThrownState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.OnTurnState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.PlayerState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;

import java.util.Random;

import static com.ceng453group15.frontend.GameLogic.GameConstants.DEFAULT_PLAYER_BUDGET;
import static com.ceng453group15.frontend.GameLogic.GameConstants.TILE_COUNT;

public class Player{
    private int current_pos;

    private int budget;

    private PlayerState playerState;

    public  Player(){
        current_pos = 0;
        budget = DEFAULT_PLAYER_BUDGET;
        //It's not any of the players' turn as default
        playerState = new WaitState(this);
    }

    public void throwDiceAndMove() {
        playerState.throwDice();
    }

    public void buyProperty() {
        playerState.buyProperty();
    }

    public void increaseBudget(int increase){
        budget += increase;
    }

    public void decreaseBudget(int decrease){
        //TODO: check the end condition
        budget -=decrease;
    }
    public void setPlayerState(PlayerState state){
        playerState = state;
    }

    public PlayerState getPlayerState(){
        return playerState;
    }
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getCurrent_pos(){
        return this.current_pos;
    }

    public void setCurrent_pos(int new_pos){
        this.current_pos = new_pos;
    }
}
