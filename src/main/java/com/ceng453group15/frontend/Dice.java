package com.ceng453group15.frontend;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Dice extends Shape {
    Circle circle;
    Rectangle rectangle;

    public Dice(){
        circle = new Circle(10f);
        rectangle = new Rectangle(50f, 50f);
    }
}
