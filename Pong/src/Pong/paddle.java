package Pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//skapar en kvadrat, alltså racketen
public class paddle extends Rectangle {

	public paddle() {
		setHeight(80);
		setWidth(10);
		setFill(Color.WHITE);

}