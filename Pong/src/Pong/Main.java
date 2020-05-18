package Pong;

//Mainklassens syfte �r prim�rt att lagra de olika objekten och knyta dem samman f�r att f� spelet att fungera.

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	// anv�nds f�r att f� mer "smooth" input (jaok l�rde oss detta)
	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 500, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();

		// skapar ett h�ger- och v�nster-racket samt placerar dem p� r�tt plats
		paddle right = new paddle();
		root.getChildren().add(right);
		right.setTranslateX(760);
		right.setTranslateY(210);

		paddle left = new paddle();
		root.getChildren().add(left);
		left.setTranslateX(40);
		left.setTranslateY(210);
		
		// skapar bollen
		ball boll = new ball();
		root.getChildren().add(boll);

		// skapar po�ngm�taren och placerar den på rätt plats
		scoreboard score = new scoreboard();
		root.getChildren().add(score);
		score.setTranslateX(400);
		score.setTranslateY(50);

		// animationstimer, fungerar ungefär som en while loop f�r javafx
		AnimationTimer at = new AnimationTimer() {

			@Override
			public void handle(long now) {

				// hanterar input (alltså racketen eftersom de är de som kontrolleras av användaren)
				for (KeyCode key : keysPressed) {

					switch (key) {

					case UP:
						right.up();
						break;
					case DOWN:
						right.down();
						break;

					case W:
						left.up();
						break;
					case S:
						left.down();
						break;

					default:
						break;
					}

				}


			}
		};

		at.start();

		// tar input
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			if (!keysPressed.contains(key))
				keysPressed.add(key);
		});

		scene.setOnKeyReleased(e -> {
			KeyCode key = e.getCode();
			if (keysPressed.contains(key))
				keysPressed.remove(key);
		});

	}

	public static void main(String[] args) {
		launch();
	}

}