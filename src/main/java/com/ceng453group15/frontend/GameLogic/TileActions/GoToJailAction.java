package com.ceng453group15.frontend.GameLogic.TileActions;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;

import static com.ceng453group15.frontend.GameLogic.GameConstants.JAIL_TILE_POS;

public class GoToJailAction implements TileAction {
    @Override
    public void execute(Player player) {
        player.setPlayerState(new JailState(player));
        player.setCurrent_pos(JAIL_TILE_POS);
    }
}
