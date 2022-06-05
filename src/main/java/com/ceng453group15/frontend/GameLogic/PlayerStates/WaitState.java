package com.ceng453group15.frontend.GameLogic.PlayerStates;

import com.ceng453group15.frontend.GameLogic.Player;

//It's not player's turn yet
public class WaitState implements PlayerState {
    private Player player;
    public WaitState(Player player){
        this.player = player;
    }
    @Override
    public void throwDice() {
        System.out.println("Not your turn yet");
    }

    @Override
    public void buyProperty() {
        System.out.println("Not your turn yet");
    }
}
