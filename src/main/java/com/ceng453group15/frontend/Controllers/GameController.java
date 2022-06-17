package com.ceng453group15.frontend.Controllers;

import com.ceng453group15.frontend.DiceAnimation;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;

public class GameController {

    @FXML
    public AnchorPane mainPane;

    @FXML
    public Pane pane04;
    @FXML
    public ImageView dice1;
    @FXML
    public ImageView dice2;

    private ParallelTransition transitionDice1;
    private ParallelTransition transitionDice2;


    public void mainPaneClicked(MouseEvent mouseEvent) {
        System.out.println("Mouse event on main pane is triggered");

        /*for(Node node: pane04.getChildren()){
            Text text = (Text) node;
            System.out.println(text.getText());
            text.setText("Changed");
            text.setLayoutX(pane04.getLayoutX() + (pane04.getWidth() - text.getLayoutBounds().getWidth())/2);
        }*/
    }



    @FXML
    public void throwDices(){
        DiceAnimation diceAnimation = new DiceAnimation(300f, 300f, dice1);
        DiceAnimation diceAnimation1 = new DiceAnimation(300f, 150f, dice2);
        diceAnimation.play();
        diceAnimation1.play();
    }

    private void changeDiceImage(ImageView dice, int top){
        File f = new File("src/main/resources/images/Dice" + top + ".png");
        System.out.println(f.toURI().toString());
        dice.setImage(new Image(f.toURI().toString()));
    }
}
