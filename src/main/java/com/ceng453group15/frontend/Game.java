package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.*;
import com.ceng453group15.frontend.GameLogic.TileActions.GoToJailAction;
import com.ceng453group15.frontend.GameLogic.TileActions.PayTaxAction;

import java.util.ArrayList;
import java.util.Random;

//Using for creating the board
public class Game {
    private int indexOfPayTax;
    private final int[] ferryIndices;

    public TurnObject turnObject;
    public Game(){
        //Hardcoded to two players fow now;

        ArrayList<Tile> tiles = new ArrayList<>();
        ArrayList<Boolean> assignedTiles = new ArrayList<>();

        for (int i=0; i<16; i++){
            assignedTiles.add(false);
        }

        //Add starting point
        tiles.add(new Tile());
        assignedTiles.set(0, true);

        //Creating properties for the rest of the board
        int startingPrice = 100;
        int endingPrice = 500;
        int interval = (endingPrice - startingPrice) / 15;
        int currentPrice = startingPrice;
        for(int i=0; i<15;i++){
            currentPrice += interval;
            System.out.println(String.valueOf(currentPrice));
            tiles.add(new Property(currentPrice, PropertyType.REGULAR));

        }
        System.out.println("Tiles size: " + tiles.size());
        //Placing jail/visit
        tiles.set(4, new Tile());
        assignedTiles.set(4, true);
        //Placing go to jail
        tiles.set(12, new Tile(new GoToJailAction()));
        assignedTiles.set(12, true);

        //Randomly place income tax
        int index = findAvailableSpaceRandomly(assignedTiles);
        tiles.set(index, new Tile(new PayTaxAction()));
        assignedTiles.set(index, true);
        indexOfPayTax = index;

        //Randomly placing ferries
        ferryIndices = new int[4];
        for(int i=0; i<4; i++){
            index = findAvailableSpaceRandomly(assignedTiles);
            tiles.set(index, new Property(250, PropertyType.FERRY));
            assignedTiles.set(index, true);
            ferryIndices[i] = index;
        }

        //should exactly 8 spaces be left as false
        for(boolean assignment: assignedTiles){
            if(!assignment){
                //should print 8 times, no more no lesss
                System.out.println("Call once for every property");
            }
        }

        Board.initializeBoard(tiles);

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());
        TurnObject.initializeTurnObject(players);
    }

    private int findAvailableSpaceRandomly(ArrayList<Boolean> spaces){
        Random rand = new Random();

        while(true){
            int index = rand.nextInt(16);
            //if space is available, return the index of the space
            if(!spaces.get(index).booleanValue()){
                System.out.println("Space available: " + index);
                return index;
            }
        }
    }

    public int[] getFerryIndices() {
        return ferryIndices;
    }

    public int getIndexOfPayTax() {
        return indexOfPayTax;
    }
}
