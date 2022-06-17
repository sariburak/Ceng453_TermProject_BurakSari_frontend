package com.ceng453group15.frontend.GameLogic.PlayerStates;

import com.ceng453group15.frontend.GameLogic.Board;
import com.ceng453group15.frontend.GameLogic.Player;

import java.util.Random;

import static com.ceng453group15.frontend.GameLogic.GameConstants.TILE_COUNT;

//It's the player's turn now but dice is not thrown yet
public class OnTurnState implements PlayerState {
    private Player player;
    public OnTurnState(Player player){
        this.player = player;
    }
    @Override
    public void move(int amount) {
        if(amount + player.getCurrent_pos() >= Board.getTiles().size()){
            //Passed the starting point, gains 100 coins
            player.increaseBudget(100);
        }
        int new_pos = (player.getCurrent_pos() + amount) % Board.getTilesCount();

        //Update player position
        player.setCurrent_pos(new_pos);
        //Update player state
        player.setPlayerState(new DiceThrownState(player));
        //Execute tile action based on the new positions
        Board.executeTileAction(player);
    }

    @Override
    public boolean buyProperty() {
        System.out.println("Can not buy yet!");
        return false;
    }
}
