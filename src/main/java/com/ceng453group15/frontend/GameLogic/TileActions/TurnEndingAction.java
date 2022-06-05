package com.ceng453group15.frontend.GameLogic.TileActions;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;

//If an action is a turn-ending action, wrap with this decorator
// (currently, all actions are turn-ending actions)
public class TurnEndingAction implements TileAction{
    private TileAction action;

    TurnEndingAction(TileAction action){
        this.action = action;
    }
    @Override
    public void execute(Player player) {
        action.execute(player);
        player.setPlayerState(new WaitState(player));
    }
}
