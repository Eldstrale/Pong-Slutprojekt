package Pong;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//kulan som passas mellan racketen
public class ball extends Circle {

	// styr i vilken riktning kulan ska r�ra sig
	int dirrX = 1;
	int dirrY = 1;
	double angle = 30;
	Random r = new Random();

	// skapar kulan och placerar ut den på slumpmässig planhalva samt ger den en
	// slumpmässig riktning
	public ball() {
		setRadius(10);
		setFill(Color.WHITE);
		if (Math.random() >= 0.5) {
			setTranslateX(150);
			setTranslateY(250);
			dirrX = -1;
		} else {
			setTranslateX(650);
			setTranslateY(250);
			dirrX = 1;
		}
		ydirr();
	}

	// bestämmer hur kulan flyttas (jag fick lite hjälp av August med detta)
	public void move() {
		setTranslateX(getTranslateX() - Math.cos(Math.toRadians(angle)) * 8 * dirrX);
		setTranslateY(getTranslateY() - Math.sin(Math.toRadians(angle)) * 8 * dirrY);
	}

	// kollar om kulan studsar antingen vid taket eller golvet samt antingen ena
	// eller de andra racket och byter isåfall riktning.
	public void bounce(Bounds a, Bounds b) {
		if (getBoundsInParent().intersects(a)) {
			dirrX = -1;
			angle = 20 + (35 - 20) * r.nextDouble();
		}
		if (getBoundsInParent().intersects(b)) {
			dirrX = 1;
			angle = 20 + (35 - 20) * r.nextDouble();

		}
		if (getBoundsInParent().intersects(0, 0, 800, 0)) {
			dirrY *= -1;
		}
		if (getBoundsInParent().intersects(0, 500, 800, 0)) {
			dirrY *= -1;
		}
	}

	// kollar om det gjorts mål på vänster sida och servar isåfall på nytt samt
	// returnerar ja annars returnerar nej
	public boolean leftgoal() {
		if (getBoundsInParent().intersects(0, 0, 0, 500)) {
			setTranslateX(150);
			setTranslateY(250);
			dirrX = -1;
			ydirr();
			return true;
		} else {
			return false;
		}

	}

	// kollar om det gjorts mål på höger sida och servar då på nytt samt
	// returnerar ja annars returnerar nej
	public boolean rightgoal() {
		if (getBoundsInParent().intersects(800, 0, 0, 500)) {
			setTranslateX(650);
			setTranslateY(250);
			dirrX = 1;
			ydirr();
			return true;
		} else {
			return false;
		}
	}

	// sätter riktningen för bollen, upp / ner random
	public void ydirr() {
		if (Math.random() >= 0.5) {
			dirrY = 1;
		} else {
			dirrY = -1;
		}
	}

}
