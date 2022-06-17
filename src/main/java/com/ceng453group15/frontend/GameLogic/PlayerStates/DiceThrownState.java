package com.ceng453group15.frontend.GameLogic.PlayerStates;

import com.ceng453group15.frontend.GameLogic.Board;
import com.ceng453group15.frontend.GameLogic.Player;

//It's players turn and dice is thrown
public class DiceThrownState implements PlayerState {
    private Player player;
    public DiceThrownState(Player player){
        this.player = player;
    }
    @Override
    public void move(int amount) {
        //TODO: implement to be able to throw dice multiple times
        System.out.println("Already thrown dice");
    }

    @Override
    public boolean buyProperty() {
        return Board.sellProperty(player);
    }
}
