package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.TileActions.TileAction;

import java.util.ArrayList;

public class Board {
    private static ArrayList<Tile> tiles = new ArrayList<>();

    public static void initializeBoard(ArrayList<Tile> tiles){
        Board.tiles = tiles;
    }
    public static void sellProperty(Player player) {
        Board.tiles.get(player.getCurrent_pos()).getSold(player);
    }

    public static void executeTileAction(Player player) {
        Board.tiles.get(player.getCurrent_pos()).executeDefaultAction(player);
    }
}
