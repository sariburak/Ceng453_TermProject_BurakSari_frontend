package com.ceng453group15.frontend;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class DiceAnimation {
    private TranslateTransition translateTransition;
    private RotateTransition rotateTransition;
    private ParallelTransition parallelTransition;

    public DiceAnimation(double byX, double byY, Node dice){
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
    }

    public void play(){
        parallelTransition.play();
    }
}
