package com.ceng453group15.frontend;

import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.util.Random;

public class DiceAnimation {
    private TranslateTransition translateTransition;
    private RotateTransition rotateTransition;
    private ParallelTransition parallelTransition;

    private ImageView dice;

    private Roller clock;
    public DiceAnimation(double byX, double byY, ImageView dice){
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

    }

    public void play(){
        parallelTransition.play();
        clock.start();

        parallelTransition.statusProperty().addListener(new ChangeListener<Animation.Status>() {
                @Override
                public void changed(ObservableValue<? extends Animation.Status> observableValue, Animation.Status status, Animation.Status t1) {
                    if(t1 == Animation.Status.STOPPED){
                        clock.stop();
                    }
                }
            }

        );
    }

    private void changeDiceImage(ImageView dice, int top){
        File f = new File("src/main/resources/images/Dice" + top + ".png");
        System.out.println(f.toURI().toString());
        dice.setImage(new Image(f.toURI().toString()));
    }

    private class Roller extends AnimationTimer{
        private long FRAMES_PER_SEC = 20L;
        private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        private long last = 0;
        @Override
        public void handle(long now) {
            if(now - last > INTERVAL){
                int r = 2 + (int)(Math.random() * 5);
                System.out.println("Dice image changed!" + r);
                changeDiceImage((ImageView) dice, r);
                last = now;
            }
        }
    }
}
