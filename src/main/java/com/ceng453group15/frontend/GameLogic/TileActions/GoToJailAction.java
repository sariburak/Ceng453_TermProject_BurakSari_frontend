package com.ceng453group15.frontend.GameLogic.TileActions;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;

public class GoToJailAction implements TileAction {
    @Override
    public void execute(Player player) {
        player.setPlayerState(new JailState(player));
    }
}
