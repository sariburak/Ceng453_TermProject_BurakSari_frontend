package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.TileActions.TileAction;

import java.util.ArrayList;

public class Board {
    private static ArrayList<Tile> tiles = new ArrayList<>();

    public static void initializeBoard(ArrayList<Tile> tiles){
        Board.tiles = tiles;
    }
    public static void sellProperty(Player player) {
        //TODO:Check if this cast fails
        Property property = (Property) Board.tiles.get(player.getCurrent_pos());
        property.getSold(player);
    }

    public static void executeTileAction(Player player) {
        Board.tiles.get(player.getCurrent_pos()).executeDefaultAction(player);
    }

    public static int getTilesCount(){
        return tiles.size();
    }

    public static ArrayList<Tile> getTiles(){
        return tiles;
    }
}
