package com.ceng453group15.frontend.GameLogic;

import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.OnTurnState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;

import java.util.ArrayList;
import java.util.List;

public class TurnObject {
    private List<Player> players;
    private Player activePlayer;
    TurnObject(List<Player> players){
        this.players = new ArrayList<>(players);
        activePlayer = players.get(0);
    }

    //Passes the turn to the next player
    public void nextTurn(){
        //TODO: Should be called unless all players are in jail or wait state
        if(!(activePlayer.getPlayerState() instanceof WaitState)){
            System.out.println("You can not call this function yet!");
            return;
        }
        //Let turn pass to the next player
        //TODO: may be good to implement some mechanism to check all other players are in wait or jail

        //algorithm to skip players in jail
        //while a player found that is not in jail
        //while(true)
        //  activePlayer = get from new index
        //  if activePlayer's state is jail
        //      activePlayer jailTime--
        //      activePlayer = next player
        // else
        //      break
        while(true){
            int new_index = (players.indexOf(activePlayer) + 1) % players.size();
            activePlayer = players.get(new_index);
            if(activePlayer.getPlayerState() instanceof JailState){
                //TODO: could be better to implement getThroughOneTurnSentence method in player,
                //In that case, that method should be added to PlayerState interface
                JailState jailState = (JailState) activePlayer.getPlayerState();
                jailState.getThroughOneTurnSentence();
            }else{
                break;
            }
        }

        activePlayer.setPlayerState(new OnTurnState(activePlayer));
    }




}
