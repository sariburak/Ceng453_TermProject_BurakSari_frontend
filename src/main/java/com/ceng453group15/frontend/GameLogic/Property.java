package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.TileActions.PayRentAction;

//Tiles that can be bought are Properties
public class Property extends Tile {
    private int price;
    //if owner == null, not bought yet
    private Player owner;
    //regular or ferry
    private PropertyType type;
    public Property(int price, PropertyType type){
        this.price = price;
        this.type = type;
        this.owner = null;
    }

    public void getSold(Player player) {
        if(owner == null && player.getBudget() > price){
            player.decreaseBudget(price);
            owner = player;
            setDefaultAction(new PayRentAction(this, player));
        }else{
            System.out.println("Can not buy this property!");
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

    public Player getOwner(){
        return this.owner;
    }

    public void setOwner(Player player){
        //Sets owner without any money exchange
        this.owner = player;
    }
}
