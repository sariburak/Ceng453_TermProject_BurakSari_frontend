package com.ceng453group15.frontend;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CustomPane extends Pane {
    Circle circle;
    Rectangle rectangle;

    public CustomPane(){
        circle = new Circle(50f);
        rectangle = new Rectangle(50f, 50f);
    }
}
