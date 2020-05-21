package Pong;

// Mainklassens syfte är primärt att lagra de olika objekten och knyta dem samman för att 
// få spelet att fungera.

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	// används för att få mer "smooth" input (jaok lärde oss detta)
	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 500, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();

		// skapar ett höger- och vänster-racket samt placerar dem på rätt plats
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

		// skapar poängmätaren och placerar den på rätt plats
		scoreboard score = new scoreboard();
		root.getChildren().add(score);
		score.setTranslateX(400);
		score.setTranslateY(50);

		// animationstimer, fungerar ungefär som en while loop för javafx
		AnimationTimer at = new AnimationTimer() {

			@Override
			public void handle(long now) {

				// hanterar input (alltså racketen eftersom det är de som kontrolleras av
				// användaren)
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

				// aktiverar metoder
				boll.move();
				boll.bounce(left.getBoundsInParent(), right.getBoundsInParent());

				// kollar om bollen gått i mål och lägger till poäng
				if (boll.leftgoal()) {
					score.addleft();
				}
				if (boll.rightgoal()) {
					score.addright();
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