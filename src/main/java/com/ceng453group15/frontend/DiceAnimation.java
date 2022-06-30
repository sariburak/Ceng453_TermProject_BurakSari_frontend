package com.ceng453group15.frontend;

import com.ceng453group15.frontend.Controllers.GameController;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class DiceAnimation {
    private TranslateTransition translateTransition;
    private RotateTransition rotateTransition;
    private ParallelTransition parallelTransition;

    private ImageView dice;

    private Roller clock;

    private GameController gameController;

    private boolean activateRealDice;
    public DiceAnimation(GameController gameController, double byX, double byY, ImageView dice, boolean activateRealDice){
        this.gameController = gameController;

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
                                                                        gameController.rollRealDices();
                                                                }
                                                            }
                                                        }

        );
    }

    private class Roller extends AnimationTimer {
        private long FRAMES_PER_SEC = 20L;
        private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        private long last = 0;
        private int lastR;
        @Override
        public void handle(long now) {
            if(now - last > INTERVAL){
                lastR = 2 + (int)(Math.random() * 5);
                //System.out.println("Dice image changed!" + lastR);
                gameController.changeDiceImage((ImageView) dice, lastR);
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