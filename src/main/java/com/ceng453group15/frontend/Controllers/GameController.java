package com.ceng453group15.frontend.Controllers;

import com.ceng453group15.frontend.CustomPane;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameController {

    @FXML
    public GridPane mainPane;

    @FXML
    public Pane pane04;

    public void mainPaneClicked(MouseEvent mouseEvent) {
        System.out.println("Mouse event on main pane is triggered");

        for(Node node: pane04.getChildren()){
            Text text = (Text) node;
            System.out.println(text.getText());
            text.setText("Changed");
            text.setLayoutX(pane04.getLayoutX() + (pane04.getWidth() - text.getLayoutBounds().getWidth())/2);
        }
    }
}
