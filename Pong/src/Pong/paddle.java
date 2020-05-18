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

	// flyttar racketen upp�t tills de börjar l�mna rutan
	public void up() {
		if (!getBoundsInParent().intersects(0, 0, 800, 0)) {
			setTranslateY(getTranslateY() - 5);
		}

	}

	// flyttar racketen ner�t tills de börjar l�mna rutan
	public void down() {
		if (!getBoundsInParent().intersects(0, 500, 800, 0)) {
			setTranslateY(getTranslateY() + 5);
		}
	}
}
