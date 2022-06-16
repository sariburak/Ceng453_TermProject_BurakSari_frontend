package com.ceng453group15.frontend;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @FXML
    public AnchorPane mainPane;
    @FXML
    public Text textToChange;

    @FXML
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("" + mouseEvent.getX() + ","+ mouseEvent.getY() + "," + mouseEvent.getZ());
        textToChange.setText("" + (int) mouseEvent.getX() + ", "+ (int) mouseEvent.getY());
    }

    @FXML
    public void textKeyPress(KeyEvent keyEvent) {
        System.out.println("Pressed smth");
        switch (keyEvent.getCode()){
            case UP:
                System.out.println("UP");
                textToChange.setY(textToChange.getX() + 5);
                break;
        }
    }
}
