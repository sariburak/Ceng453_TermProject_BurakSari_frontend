package com.ceng453group15.frontend;

import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;
import com.ceng453group15.frontend.GameLogic.TurnObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnObjectTest {
    @Test
    void TurnObject_Inıtialization_success(){
        Player player1 = new Player();
        Player player2 = new Player();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        TurnObject.initializeTurnObject(players);
        assertTrue(TurnObject.getActivePlayer() == player1);
    }

    @Test
    void TurnObject_GoToNextPlayerWhileNotTurnFinished(){
        Player player1 = new Player();
        Player player2 = new Player();

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        TurnObject.initializeTurnObject(players);

        assertTrue(TurnObject.getActivePlayer() == player1);

        //Shouldn't pass the turn
        TurnObject.nextTurn();

        assertTrue(TurnObject.getActivePlayer() == player1);
    }

    @Test
    void TurnObject_GoToNextPlayer_success(){
        Player player1 = new Player();
        Player player2 = new Player();

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        TurnObject.initializeTurnObject(players);

        assertTrue(TurnObject.getActivePlayer() == player1);

        player1.setPlayerState(new WaitState(player1));

        TurnObject.nextTurn();

        assertTrue(TurnObject.getActivePlayer() == player2);
    }
}
