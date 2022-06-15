package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;
import com.ceng453group15.frontend.GameLogic.Property;
import com.ceng453group15.frontend.GameLogic.PropertyType;
import com.ceng453group15.frontend.GameLogic.TileActions.GoToJailAction;
import com.ceng453group15.frontend.GameLogic.TileActions.PayRentAction;
import com.ceng453group15.frontend.GameLogic.TileActions.PayTaxAction;
import org.junit.jupiter.api.Test;

import static com.ceng453group15.frontend.GameLogic.GameConstants.DEFAULT_PLAYER_BUDGET;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionsTest {

    @Test
    void GoToJailAction_success(){
        Player player = new Player();

        GoToJailAction goToJailAction = new GoToJailAction();
        goToJailAction.execute(player);
        assertTrue(player.getPlayerState() instanceof JailState);
    }

    @Test
    void PayTaxAction(){
        Player player = new Player();
        PayTaxAction payTaxAction = new PayTaxAction();

        payTaxAction.execute(player);

        assertTrue(player.getBudget() == 1450);
        assertTrue(player.getPlayerState() instanceof WaitState);
    }

    @Test
    void PayRentAction_success(){
        int price = 100;
        Property property = new Property(price, PropertyType.REGULAR);
        Player owner = new Player();
        Player payer = new Player();
        PayRentAction action = new PayRentAction(property, owner);

        action.execute(payer);

        assertTrue(owner.getBudget() == DEFAULT_PLAYER_BUDGET + price * 0.1);
        assertTrue(payer.getBudget() == DEFAULT_PLAYER_BUDGET - price * 0.1);
        assertTrue(payer.getPlayerState() instanceof WaitState);
    }
}
