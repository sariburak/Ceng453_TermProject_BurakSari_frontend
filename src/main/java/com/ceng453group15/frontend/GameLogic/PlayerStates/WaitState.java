package com.ceng453group15.frontend.GameLogic.PlayerStates;

import com.ceng453group15.frontend.GameLogic.Player;

//It's not player's turn yet
public class WaitState implements PlayerState {
    private Player player;
    public WaitState(Player player){
        this.player = player;
    }
    @Override
    public void move(int amount) {
        System.out.println("Not your turn yet");
    }

    @Override
    public boolean buyProperty() {
        System.out.println("Not your turn yet");
        return false;
    }
}
