package com.ceng453group15.frontend.Controllers;

import com.ceng453group15.frontend.Game;
import com.ceng453group15.frontend.GameLogic.Player;
import com.ceng453group15.frontend.GameLogic.PlayerStates.DiceThrownState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.JailState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.OnTurnState;
import com.ceng453group15.frontend.GameLogic.PlayerStates.WaitState;
import com.ceng453group15.frontend.GameLogic.TurnObject;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.util.Objects;
import java.util.Random;

public class GameController {
    private final int TILE_COUNT = 16;
    @FXML
    public AnchorPane mainPane;
    @FXML
    public GridPane gridPane;
    @FXML
    public ImageView dice1;
    @FXML
    public ImageView dice2;
    @FXML
    public Text player1Budget;
    @FXML
    public Text player2Budget;
    @FXML
    public Circle player1;
    @FXML
    public Circle player2;
    @FXML
    public Pane start;
    @FXML
    public Pane city1;
    @FXML
    public Pane city2;
    @FXML
    public Pane city3;
    @FXML
    public Pane jail;
    @FXML
    public Pane city4;
    @FXML
    public Pane city5;
    @FXML
    public Pane city6;
    @FXML
    public Pane city7;
    @FXML
    public Pane city8;
    @FXML
    public Pane city9;
    @FXML
    public Pane city10;
    @FXML

    public Pane gotojail;
    @FXML
    public Pane city11;
    @FXML
    public Pane city12;
    @FXML
    public Pane city13;
    @FXML
    public Button buyPropertyBtn;
    @FXML
    public Button skipBtn;

    private Pane[] tiles;

    private Circle[] players;
    private Text[] budgets;

    private Game game;

    private final int playerCount = 2;


    public GameController(){
        System.out.println("Constructor called");
        game = new Game();
    }

    @FXML
    public void initialize(){
        System.out.println("Initialize called");
        tiles = new Pane[]{start, city1, city2, city3, jail, city4, city5, city6, city7, city8,
            city9, city10, gotojail, city11, city12, city13
        };
        setPlayer1Budget(1500);
        setPlayer2Budget(1500);

        for(int index: game.getFerryIndices()){
            Text text = getTextFromPane(tiles[index]);
            text.setText("Ferry");
            text.setLayoutX(45);
            text.setLayoutY(36);
        }

        Text text = getTextFromPane(tiles[game.getIndexOfPayTax()]);
        text.setText("Pay Tax");
        text.setLayoutX(45);
        text.setLayoutY(36);

        players = new Circle[2];
        players[0] = player1;
        players[1] = player2;

        budgets = new Text[2];
        budgets[0] = player1Budget;
        budgets[1] = player2Budget;
    }

    @FXML
    public void throwDices(){
        DiceAnimation diceAnimation = new DiceAnimation(300f, 300f, dice1, false);
        DiceAnimation diceAnimation1 = new DiceAnimation(300f, 150f, dice2, true);
        diceAnimation.play();
        diceAnimation1.play();
    }

    public void rollRealDices(){
        Random rand = new Random();
        int dice1Top = 1 + rand.nextInt(6);
        int dice2Top = 1 + rand.nextInt(6);
        changeDiceImage(dice1, dice1Top);
        changeDiceImage(dice2, dice2Top);
        System.out.println("Real dice result: " + dice1Top + ", " + dice2Top);

        if(TurnObject.getActivePlayer().getPlayerState() instanceof DiceThrownState)
                TurnObject.nextTurn();

        if(TurnObject.getActivePlayer().getPlayerState() instanceof WaitState || TurnObject.getActivePlayer().getPlayerState() instanceof JailState)
            TurnObject.nextTurn();

        if(TurnObject.getActivePlayer().getPlayerState() instanceof OnTurnState){
            TurnObject.getActivePlayer().move(dice1Top + dice2Top);
            movePlayer(players[TurnObject.activePlayerIndex()], TurnObject.getActivePlayer().getCurrent_pos());
        }

        updateBudget();
    }

    private void updateBudget(){
        budgets[TurnObject.activePlayerIndex()].setText(String.valueOf(TurnObject.getActivePlayer().getBudget()));
    }
    private void changeDiceImage(ImageView dice, int top){
        File f = new File("src/main/resources/images/Dice" + top + ".png");
        //System.out.println(f.toURI().toString());
        dice.setImage(new Image(f.toURI().toString()));
    }

    private void movePlayer(Circle player, int destination){
        //TODO: destination should be smaller than 16
        if(!Objects.equals(player.getParent(), tiles[destination]))
            tiles[destination].getChildren().add(player);
    }

    private Text getTextFromPane(Pane pane){
        for(Node child: pane.getChildren()){
            if(child instanceof Text){
                return (Text) child;
            }
        }
        return null;
    }

    private void setPlayer1Budget(int budget){
        player1Budget.setText(String.valueOf(budget));
    }

    private void setPlayer2Budget(int budget){
        player2Budget.setText(String.valueOf(budget));
    }

    @FXML
    public void buyProperty(ActionEvent event) {
        boolean success = TurnObject.getActivePlayer().buyProperty();
        updateBudget();

        if(success)
            tiles[TurnObject.getActivePlayer().getCurrent_pos()].getStyleClass().add("player"+TurnObject.activePlayerIndex());
    }

    @FXML
    public void skipTurn(ActionEvent event) {
        TurnObject.nextTurn();
    }

    private class DiceAnimation {
        private TranslateTransition translateTransition;
        private RotateTransition rotateTransition;
        private ParallelTransition parallelTransition;

        private ImageView dice;

        private Roller clock;

        private boolean activateRealDice;
        public DiceAnimation(double byX, double byY, ImageView dice, boolean activateRealDice){
            Duration duration = Duration.millis(500f);
            translateTransition = new TranslateTransition(duration, dice);
            translateTransition.setByX(byX);
            translateTransition.setByY(byY);
            translateTransition.setCycleCount(2);
            translateTransition.setAutoReverse(true);

            rotateTransition = new RotateTransition(duration, dice);
            rotateTransition.setCycleCount(2);
            rotateTransition.setByAngle(360);
            rotateTransition.setAutoReverse(true);

            parallelTransition = new ParallelTransition(translateTransition, rotateTransition);

            this.dice = dice;
            clock = new Roller();

            this.activateRealDice = activateRealDice;
        }

        public void play(){
            parallelTransition.play();
            clock.start();

            parallelTransition.statusProperty().addListener(new ChangeListener<Animation.Status>() {
                                                                @Override
                                                                public void changed(ObservableValue<? extends Animation.Status> observableValue, Animation.Status status, Animation.Status t1) {
                                                                    if(t1 == Animation.Status.STOPPED){
                                                                        clock.stop();
                                                                        if(activateRealDice)
                                                                            rollRealDices();
                                                                    }
                                                                }
                                                            }

            );
        }

        private class Roller extends AnimationTimer{
            private long FRAMES_PER_SEC = 20L;
            private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

            private long last = 0;
            private int lastR;
            @Override
            public void handle(long now) {
                if(now - last > INTERVAL){
                    lastR = 2 + (int)(Math.random() * 5);
                    //System.out.println("Dice image changed!" + lastR);
                    changeDiceImage((ImageView) dice, lastR);
                    last = now;
                }
            }

            public int getLastR() {
                return lastR;
            }
        }

        public int diceResult(){
            return clock.getLastR();
        }
    }

}
