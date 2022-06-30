package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.TileActions.TileAction;

import java.util.ArrayList;

public class Board {
    private static ArrayList<Tile> tiles = new ArrayList<>();

    public static void initializeBoard(ArrayList<Tile> tiles){
        Board.tiles = tiles;
    }
    public static boolean sellProperty(Player player) {
        //TODO:Check if this cast fails
        if(Board.tiles.get(player.getCurrent_pos()) instanceof Property){
            Property property = (Property) Board.tiles.get(player.getCurrent_pos());
            return property.getSold(player);
        }else{
            return false;
        }

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
