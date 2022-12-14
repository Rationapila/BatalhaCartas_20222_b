package poo.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import poo.modelo.CardPokemon;
import poo.modelo.Game;
import poo.modelo.GameEvent;
import poo.modelo.GameListener;

public class PlacarView extends GridPane implements GameListener {
	private TextField ptsJ1, ptsJ2;
	private TextField energiaJ1, energiaJ2;

	public PlacarView() {
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));

		Game.getInstance().addGameListener(this);

		ptsJ1 = new TextField();
		ptsJ2 = new TextField();

		ptsJ1.setText("" + Game.getInstance().getVidaPj1());
		ptsJ2.setText("" + Game.getInstance().getVidaPj2());

		this.add(new Label("Vida:"), 0, 0);
		this.add(ptsJ1, 1, 0);
		this.add(new Label("Vida:"), 0, 1);
		this.add(ptsJ2, 1, 1);
	}

	@Override
	public void notify(GameEvent event) {
		ptsJ1.setText("" + Game.getInstance().getVidaPj1());
		ptsJ2.setText("" + Game.getInstance().getVidaPj2());
	}
}
