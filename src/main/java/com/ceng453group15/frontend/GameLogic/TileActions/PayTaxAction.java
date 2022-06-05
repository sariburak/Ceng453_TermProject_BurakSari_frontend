package com.ceng453group15.frontend.GameLogic.TileActions;

import com.ceng453group15.frontend.GameLogic.Player;

import static com.ceng453group15.frontend.GameLogic.GameConstants.TAX_AMOUNT;

public class PayTaxAction implements TileAction {
    @Override
    public void execute(Player player) {
        player.decreaseBudget(TAX_AMOUNT);
    }
}
