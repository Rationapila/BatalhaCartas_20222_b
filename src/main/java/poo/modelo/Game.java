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

	public void play(CardDeck deckAcionado) {
		GameEvent gameEvent = null;
		if (player == 3) {
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.MUSTCLEAN, "");
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
			return;
		}
		if (deckAcionado == maoj1) {
			if (player != 1) {	
				
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			} else {
				// Vira a carta
				maoj1.getSelectedCard().flip();
				// Proximo jogador
				nextPlayer();
				
			}
		} else if (deckAcionado == maoj2) {
			if (player != 2) {
				
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			} else {
				// Vira a carta
				maoj2.getSelectedCard().flip();
				// Verifica quem ganhou a rodada
				if (maoj1.getSelectedCard().getValue() > maoj2.getSelectedCard().getValue()) {
					ptsJ1++;
				} else if (maoj1.getSelectedCard().getValue() < maoj2.getSelectedCard().getValue()) {
					ptsJ2++;
				}
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
				// Próximo jogador
				nextPlayer();
				
			}
		}
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
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
		}
		Card c = deckj2.drawCard();
		maoj2.addCard(c);
	}
	
	
	public void addGameListener(GameListener listener) {
		observers.add(listener);
	}
}
