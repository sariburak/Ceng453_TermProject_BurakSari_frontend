package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.Tile;
import com.ceng453group15.frontend.GameLogic.TileActions.GoToJailAction;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TileTest {
    @Test
    void Tile_initialization_with_defaultaction_null_success(){
        Tile tile = new Tile();

        assertTrue(Objects.isNull(tile.getDefaultAction()));
    }

    @Test
    void Tile_execute_default_action_success_with_jaiLStata(){
        Player player = new Player();
        Tile tile = new Tile(new GoToJailAction());

        tile.executeDefaultAction(player);

        assertTrue(player.getPlayerState() instanceof JailState);
    }
}
