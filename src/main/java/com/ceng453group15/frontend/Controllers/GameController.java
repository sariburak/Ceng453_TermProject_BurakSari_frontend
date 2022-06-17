package com.ceng453group15.frontend.Controllers;

import com.ceng453group15.frontend.DiceAnimation;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

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

    private Pane[] tiles;


    public GameController(){
        System.out.println("Constructor called");
    }

    @FXML
    public void initialize(){
        System.out.println("Initialize called");
        tiles = new Pane[]{start, city1, city2, city3, jail, city4, city5, city6, city7, city8,
            city9, city10, gotojail, city11, city12, city13
        };
    }

    public void mainPaneClicked(MouseEvent mouseEvent) {
        System.out.println("Mouse event on main pane is triggered");

        movePlayer(player1, 10);
        movePlayer(player2, 6);
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

    private void movePlayer(Circle player, int destination){
        //TODO: destination should be smaller than 16
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
}
