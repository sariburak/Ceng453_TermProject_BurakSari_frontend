package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.*;
import com.ceng453group15.frontend.GameLogic.TileActions.PayRentAction;
import com.ceng453group15.frontend.GameLogic.TileActions.PayTaxAction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ceng453group15.frontend.GameLogic.GameConstants.DEFAULT_PLAYER_BUDGET;
import static com.ceng453group15.frontend.GameLogic.GameConstants.TAX_AMOUNT;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    @Test
    void initializeBoardTest_success(){
        Tile tile = new Tile(new PayTaxAction());
        Property property = new Property(100, PropertyType.REGULAR);
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        tiles.add(property);
        Board.initializeBoard(tiles);

        assertTrue(Board.getTiles().get(0) == tile);
        assertTrue(Board.getTiles().get(1) == property);
    }

    @Test
    void SellProperty_success(){
        Tile tile = new Tile(new PayTaxAction());
        Property property = new Property(100, PropertyType.REGULAR);
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        tiles.add(property);
        Board.initializeBoard(tiles);

        Player player = new Player();
        player.setCurrent_pos(1);
        Board.sellProperty(player);

        assertTrue(property.getDefaultAction() instanceof PayRentAction);
        PayRentAction action = (PayRentAction) property.getDefaultAction();
        assertTrue(action.getOwner() == player);
    }

    @Test
    void SellProperty_fail_property_already_owned(){
        Tile tile = new Tile(new PayTaxAction());
        Property property = new Property(100, PropertyType.REGULAR);
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        tiles.add(property);
        Board.initializeBoard(tiles);

        Player player = new Player();
        player.setCurrent_pos(1);
        Board.sellProperty(player);

        assertTrue(property.getDefaultAction() instanceof PayRentAction);
        PayRentAction action = (PayRentAction) property.getDefaultAction();
        assertTrue(action.getOwner() == player);

        Player player2 = new Player();
        player2.setCurrent_pos(1);
        PayRentAction action1 = (PayRentAction) property.getDefaultAction();
        assertTrue(action1.getOwner() != player2);
    }

    @Test
    void ExecuteTileAction_with_payTax_success(){
        Tile tile = new Tile(new PayTaxAction());
        Player player = new Player();
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);

        Board.initializeBoard(tiles);
        //Since player's default pos is 0, no need to update current_pos
        Board.executeTileAction(player);

        assertTrue(player.getBudget() == DEFAULT_PLAYER_BUDGET - TAX_AMOUNT);
    }
}
