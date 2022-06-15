package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.TileActions.TileAction;

import java.util.Objects;

public class Tile {
    protected TileAction defaultAction;

    public Tile(){
        defaultAction = null;
    }
    public Tile(TileAction action){
        defaultAction = action;
    }

    public void executeDefaultAction(Player player){
        if(!Objects.isNull(defaultAction))
            defaultAction.execute(player);
    }

    public TileAction getDefaultAction() {
        return defaultAction;
    }

    public void setDefaultAction(TileAction defaultAction) {
        this.defaultAction = defaultAction;
    }

}
