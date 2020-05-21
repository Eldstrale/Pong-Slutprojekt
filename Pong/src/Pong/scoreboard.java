package Pong;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

// scoreboard är en poängmätare som håller koll på varje spelares poäng samt visar dem på varera sida.

public class scoreboard extends Group {

	// skapar 2 texfält och poängmätare.
	Text left = new Text(30, 0, "0");
	Text right = new Text(-30, 0, "0");
	int leftscore = 0;
	int rightscore = 0;

	public scoreboard() {

		// lägger till textfälten samt ger dem rätt storlek och gränssnitt.
		left.setFill(Color.WHITE);
		left.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		getChildren().add(left);

		right.setFill(Color.WHITE);
		right.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		getChildren().add(right);
	}

	// lägger till en poäng till höger spelare och visar upp den samt aktiverar
	// restart metoden som startar en ny match.
	public void addright() {
		rightscore++;
		right.setText(Integer.toString(rightscore));
		restart();
	}

	// samma som ovan men poäng för vänster sida.
	public void addleft() {
		leftscore++;
		left.setText(Integer.toString(leftscore));
		restart();
	}

	// kollar om någon spelare har mer än 9 poäng och nollställer isåfall poängen,
	// den som först får 9 vinner helt enkelt.
	public void restart() {
		if (leftscore > 9 || rightscore > 9) {
			leftscore = -1;
			rightscore = -1;
			addright();
			addleft();
		}
	}
}
