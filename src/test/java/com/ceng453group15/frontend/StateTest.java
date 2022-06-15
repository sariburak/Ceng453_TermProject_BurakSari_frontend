package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.*;
import com.ceng453group15.frontend.GameLogic.PlayerStates.DiceThrownState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.OnTurnState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;
import com.ceng453group15.frontend.GameLogic.TileActions.PayRentAction;
import com.ceng453group15.frontend.GameLogic.TileActions.PayTaxAction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ceng453group15.frontend.GameLogic.GameConstants.DEFAULT_PLAYER_BUDGET;
import static com.ceng453group15.frontend.GameLogic.GameConstants.TAX_AMOUNT;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StateTest {
    @Test
    void JailState_ThrowDice_Test(){
        Player player = new Player();
        JailState state = new JailState(player);

        state.throwDice();
    }

    @Test
    void JailState_BuyProperty_Test(){
        Player player = new Player();
        JailState state = new JailState(player);

        state.buyProperty();
    }

    @Test
    void JailState_GetOutOfJail_Test(){
        Player player = new Player();
        JailState state = new JailState(player);
        player.setPlayerState(state);

        assertTrue(player.getPlayerState() instanceof JailState);
        assertTrue(state.getRemainingTurnCount() == 1);

        state.getThroughOneTurnSentence();
        assertTrue(player.getPlayerState() instanceof JailState);
        assertTrue(state.getRemainingTurnCount() == 0);

        state.getThroughOneTurnSentence();
        assertTrue(player.getPlayerState() instanceof WaitState);
    }

    @Test
    void DiceThrownState_ThrowDice_Test(){
        Player player = new Player();
        DiceThrownState state = new DiceThrownState(player);

        state.throwDice();
    }

    @Test
    void DiceThrownState_BuyProperty_Test(){
        Player player = new Player();
        Property property = new Property(100, PropertyType.REGULAR);
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(property);
        Board.initializeBoard(tiles);

        DiceThrownState state = new DiceThrownState(player);
        state.buyProperty();

        assertTrue(property.getDefaultAction() instanceof PayRentAction);
        PayRentAction action = (PayRentAction) property.getDefaultAction();
        assertTrue(action.getOwner() == player);
        assertTrue(player.getBudget() == DEFAULT_PLAYER_BUDGET - 100);
    }

    @Test
    void OnTurnState_throwDice_Test(){
        //TODO: add cases for tiles.count > 0

        Player player = new Player();
        Tile tile = new Tile(new PayTaxAction());
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);

        Board.initializeBoard(tiles);

        OnTurnState state = new OnTurnState(player);

        state.throwDice();

        assertTrue(player.getBudget() == DEFAULT_PLAYER_BUDGET - TAX_AMOUNT);
    }

    @Test
    void OnTurnState_buyProperty_Test(){
        Player player = new Player();
        OnTurnState state = new OnTurnState(player);

        state.buyProperty();
    }
}
