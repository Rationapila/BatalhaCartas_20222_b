package poo.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//import poo.modelo.GameEvent.Action;
//import poo.modelo.GameEvent.Target;

public class CardDeck {
	public  int ncards;
	private List<Card> cartas;
	private Card selected;
	private List<GameListener> observers;

	public CardDeck(int nroCartas) {
		ncards = nroCartas;
		cartas = new ArrayList<>(nroCartas);
		selected = null;
		Random r = new Random();
		for (int i = 0; i < nroCartas; i++) {
			int n = r.nextInt(10) + 1;
			Card c = new Card("C" + n, "img" + n);
			//c.flip();
			cartas.add(c);
		}
		observers = new LinkedList<>();
	}



	public List<Card> getCards() {
		return Collections.unmodifiableList(cartas);
	}

	public int getNumberOfCards() {
		return cartas.size();
	}

	public void shuffle(){
		Collections.shuffle(cartas);
	}

	public void removeSel() {
		if (selected == null) {
			return;
		}
		cartas.remove(selected);
		selected = null;
		GameEvent gameEvent = new GameEvent(this, GameEvent.Target.DECK, GameEvent.Action.REMOVESEL, "");
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}

	public void removeIndex(int index){
		if (cartas.get(index) == null) {
			return;
		}
		cartas.remove(cartas.get(index));
		GameEvent gameEvent = new GameEvent(this, GameEvent.Target.DECK, GameEvent.Action.REMOVESEL, "");
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}

	public void addCard(Card card) {
		System.out.println("add: "+ card);
		cartas.add(card);
		GameEvent gameEvent = new GameEvent(this, GameEvent.Target.DECK, GameEvent.Action.SHOWTABLE, "");
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}


	public Card drawCard(){
		Card c = cartas.get(0);
		cartas.remove(0);
		return c;
	}

	public void setSelectedCard(Card card) {
		selected = card;
	}

	public Card getSelectedCard() {
		return selected;
	}

	public void clear(){
		cartas.clear();
		selected = null;
		GameEvent gameEvent = new GameEvent(this, GameEvent.Target.DECK, GameEvent.Action.REMOVESEL, "");
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}

	public void addGameListener(GameListener listener) {
		observers.add(listener);
	}

	public Card getCard(int index){
		if (index >= cartas.size()) {
			return null;
		}
		return cartas.get(index);
	}

	public int getSize() {
		return cartas.size();
	}
}
