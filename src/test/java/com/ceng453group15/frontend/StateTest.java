package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.*;
import com.ceng453group15.frontend.GameLogic.PlayerStates.DiceThrownState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.TileActions.PayRentAction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ceng453group15.frontend.GameLogic.GameConstants.DEFAULT_PLAYER_BUDGET;
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
}
