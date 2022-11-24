package poo.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//import poo.modelo.GameEvent.Action;
//import poo.modelo.GameEvent.Target;

public class Game {
	private static Game game = new Game();
	private int ptsJ1, ptsJ2;
	private CardDeck maoj1, maoj2;
	private CardDeck deckj1, deckj2;
	private CardDeck mesaJ1, mesaJ2;
	private CardDeck zonaPrincipal;
	private int player;
	private int jogadas;
	private List<GameListener> observers;
	
	public static Game getInstance() {
		return game;
	}

	private Game() {
		ptsJ1 = 0;
		ptsJ2 = 0;
		maoj1 = new CardDeck(6);
		maoj2 = new CardDeck(6);
		deckj1 = new CardDeck(5);
		deckj2 = new CardDeck(5);
		mesaJ1 = new CardDeck(0);
		mesaJ2 = new CardDeck(0);
		zonaPrincipal = new CardDeck(0);
		
		player = 1;
		jogadas = maoj1.getNumberOfCards();
		observers = new LinkedList<>();
	}

	private void nextPlayer() {
		player++;
		if (player == 4) {
			player = 1;
		}
	}

	public int getPtsJ1() {
		return ptsJ1;
	}

	public int getPtsJ2() {
		return ptsJ2;
	}

	public CardDeck getmaoj1() {
		return maoj1;
	}

	public CardDeck getmaoj2() {
		return maoj2;
	}

	public CardDeck getMesaJ1() {
		return mesaJ1;
	}

	public CardDeck getMesaJ2() {
		return mesaJ2;
	}

	public CardDeck getZonaPrincipal() {
		return zonaPrincipal;
	}
	

	public void play(CardDeck deckAcionado) {
		
				// Vira a carta
				maoj1.getSelectedCard();
				// Proximo jogador
				
			
				maoj2.getSelectedCard();
				
	}
	
	// Acionada pelo botao de limpar
	public void removeSelected() {
		GameEvent gameEvent = null;
		if (player != 3) {
			return;
		}
		jogadas--;
		if (jogadas == 0) {
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ENDGAME, "");
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
		}
		
		mesaJ1.addCard( maoj1.getSelectedCard() );
		//maoj1.addCard( maoj1.getSelectedCard() );
		maoj1.removeSel();
		
		mesaJ2.addCard( maoj2.getSelectedCard() );
		//maoj2.addCard( maoj2.getSelectedCard() );
		maoj2.removeSel();
		nextPlayer();
	}

	
	public void drawCardP1(){
		GameEvent gameEvent = null;
		if (deckj1.getNumberOfCards() <= 0){
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.NOCARDS, "");

		}

		Card c = deckj1.drawCard();
		maoj1.addCard(c);
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}

	public void drawCardP2(){
		GameEvent gameEvent = null;
		if (deckj2.getNumberOfCards() <= 0){
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.NOCARDS, "");
		}
		Card c = deckj2.drawCard();
		maoj2.addCard(c);
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}
	
	
	public void addGameListener(GameListener listener) {
		observers.add(listener);
	}

	public void colocaReservaJ1(){
		mesaJ1.addCard( maoj1.getSelectedCard());
		maoj1.removeSel();
	}

	public void colocaReservaJ2(){
		mesaJ2.addCard(maoj2.getSelectedCard());
		maoj2.removeSel();
	}

	public void colocaZonaJ1(){
		zonaPrincipal.addCard(maoj1.getSelectedCard());
		maoj1.removeSel();
	}

	public void colocaZonaJ2(){
		zonaPrincipal.addCard(maoj2.getSelectedCard());
		maoj2.removeSel();
	}

	
}


