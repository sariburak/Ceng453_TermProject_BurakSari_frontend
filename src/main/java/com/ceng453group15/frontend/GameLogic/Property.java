package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;
import com.ceng453group15.frontend.GameLogic.TileActions.PayRentAction;

//Tiles that can be bought are Properties
public class Property extends Tile {
    private int price;
    //if owner == null, not bought yet
    //regular or ferry
    private PropertyType type;
    public Property(int price, PropertyType type){
        this.price = price;
        this.type = type;
    }

    public boolean getSold(Player player) {
        if(!(defaultAction instanceof PayRentAction) && player.getBudget() > price){
            player.decreaseBudget(price);
            setDefaultAction(new PayRentAction(this, player));
            player.setPlayerState(new WaitState(player));
            return true;
        }else{
            System.out.println("Can not buy this property!");
            return false;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }
}
