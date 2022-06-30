package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    void player_initialization_success(){
        Player player = new Player();
        assertTrue(player.getBudget() == 1500);
        assertTrue(player.getCurrent_pos() == 0);
    }
}
