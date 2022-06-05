package com.ceng453group15.frontend.GameLogic;

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
        //TODO: may need to add more action later
        defaultAction = null;
    }

    @Override
    public void getSold(Player player) {
        if(owner == null && player.getBudget() > price){
            player.decreaseBudget(price);
            owner = player;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
