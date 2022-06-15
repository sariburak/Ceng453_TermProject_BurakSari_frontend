package com.ceng453group15.frontend.GameLogic.TileActions;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;
import com.ceng453group15.frontend.GameLogic.Property;
import com.ceng453group15.frontend.GameLogic.Tile;

//Player landed on an already bought Property
public class PayRentAction implements TileAction {
    private Player owner;
    private Property property;
    public PayRentAction(Property property, Player owner){
        this.property = property;
        this.owner = owner;
    }

    @Override
    public void execute(Player player) {

        //TODO: no need for floating numbers, right?
        //TODO: add case for ferries
        int rent = (int) (property.getPrice() * 0.1);
        player.decreaseBudget(rent);
        owner.increaseBudget(rent);

        player.setPlayerState(new WaitState(player));
    }
}
