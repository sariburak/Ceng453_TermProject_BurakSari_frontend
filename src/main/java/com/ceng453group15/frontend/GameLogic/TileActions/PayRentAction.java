package com.ceng453group15.frontend.GameLogic.TileActions;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;
import com.ceng453group15.frontend.GameLogic.Property;
import com.ceng453group15.frontend.GameLogic.Tile;

//Player landed on an already bought Property
public class PayRentAction implements TileAction {
    private Player owner;
    private Tile tile;
    public PayRentAction(Tile tile, Player owner){
        this.tile = tile;
        this.owner = owner;
    }

    @Override
    public void execute(Player player) {
        //TODO: check if this cast fails

        Property tmp = (Property) tile;
        int price = tmp.getPrice();
        player.decreaseBudget(price);
        owner.increaseBudget(price);

        player.setPlayerState(new WaitState(player));
    }
}
