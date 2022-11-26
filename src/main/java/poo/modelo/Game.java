package poo.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//import poo.modelo.GameEvent.Action;
//import poo.modelo.GameEvent.Target;

public class Game {
	private static Game game = new Game();
	private int vidaPj1, vidaPj2;
	private CardDeck maoj1, maoj2;
	private CardDeck deckj1, deckj2;
	private CardDeck mesaJ1, mesaJ2;
	private CardDeck zonaPrincipalJ1, zonaPrincipalJ2;
	private int player;
	private int jogadas;
	private List<GameListener> observers;
	private CardPokemon comparadorPokemon;
	
	public static Game getInstance() {
		return game;
	}

	private Game() {
		vidaPj1 = 0;
		vidaPj2 = 0;
		maoj1 = BancoDeDecks.getDeck(1);
		maoj2 = BancoDeDecks.getDeck(2); 
		deckj1 = new CardDeck(40);
		deckj2 = new CardDeck(40);
		mesaJ1 = new CardDeck(0);
		mesaJ2 = new CardDeck(0);
		zonaPrincipalJ1 = new CardDeck(0);
		zonaPrincipalJ2 = new CardDeck(0);
		player = 1;
		jogadas = maoj1.getNumberOfCards();
		observers = new LinkedList<>();
		comparadorPokemon = new CardPokemon("", "");
	}

	private void nextPlayer() {
		player++;
		if (player == 3) {
			player = 1;
		}
	}

	public int getVidaPj1() {
		return vidaPj1;
	}

	public int getVidaPj2() {
		return vidaPj2;
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

	public CardDeck getzonaPrincipalJ1() {
		return zonaPrincipalJ1;
	}

	public CardDeck getzonaPrincipalJ2() {
		return zonaPrincipalJ2;
	}
	

	public void play(CardDeck deckAcionado) {
		boolean inicioDeJogo;
		boolean temCartaPokemonJ1 = false;
		/* 
		while (temCartaPokemonJ1 == false){
			for (int i = 0; i < maoj1.getNumberOfCards(); i++) {
				if (maoj1.getCard(i) == null){
					temCartaPokemonJ1 = true;
				}
			}
		}
		*/
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
		GameEvent gameEvent = null;
		if (zonaPrincipalJ1.getNumberOfCards() == 1){
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ZONETAKEN, "");
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
		}
		else{
			zonaPrincipalJ1.addCard(maoj1.getSelectedCard());
			vidaPj1 = ((CardPokemon)maoj1.getSelectedCard()).getHp();
			maoj1.removeSel();
		}
	}

	public void colocaZonaJ2(){
		GameEvent gameEvent = null;
		if (zonaPrincipalJ2.getNumberOfCards() == 1){
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ZONETAKEN, "");
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
		}
		else{
			zonaPrincipalJ2.addCard(maoj2.getSelectedCard());
			vidaPj2 = ((CardPokemon)maoj2.getSelectedCard()).getHp();
			maoj2.removeSel();
		}
	}

	public int getVidaZ1(){
		Card PokemonZ1 = comparadorPokemon;
		Ataque ataque;
		for (int i = 0; i < zonaPrincipalJ1.getNumberOfCards(); i++){
			if (zonaPrincipalJ1.getCard(i).getClass() == comparadorPokemon.getClass()){
				PokemonZ1 = zonaPrincipalJ1.getCard(i);
		}
	}
		CardPokemon Pokemon = (CardPokemon) PokemonZ1;
		return Pokemon.getHp();
	}

	public void ataqueZ1(int NumeroAtaque){
		Card PokemonAtacante = comparadorPokemon;
		Card PokemonAtacado = comparadorPokemon;
		Ataque ataque;
		for (int i = 0; i < zonaPrincipalJ1.getNumberOfCards(); i++){
			if (zonaPrincipalJ1.getCard(i).getClass() == comparadorPokemon.getClass()){
				PokemonAtacante = zonaPrincipalJ1.getCard(i);
		}
		for (int j = 0; j < zonaPrincipalJ2.getNumberOfCards(); j++){
			if (zonaPrincipalJ2.getCard(j).getClass() == comparadorPokemon.getClass()){
				PokemonAtacado = zonaPrincipalJ2.getCard(j);
			}
		CardPokemon atacante = (CardPokemon) PokemonAtacante;
		CardPokemon atacado = (CardPokemon) PokemonAtacado;
		if (NumeroAtaque == 1){
			ataque = atacante.getAtaque(1);
			atacado.recebeDano(ataque.getDano());
		}
		}
	}
	}

	public String getIdCarta(int NJogador){
		if(NJogador == 1)
		return maoj1.getSelectedCard().getImageId();
		if(NJogador == 2)
		return maoj2.getSelectedCard().getImageId();
		if(NJogador == 3)
		return mesaJ1.getSelectedCard().getImageId();
		if(NJogador == 4)
		return mesaJ2.getSelectedCard().getImageId();
		if(NJogador == 5)
		return zonaPrincipalJ1.getSelectedCard().getImageId();
		if(NJogador == 6)
		return zonaPrincipalJ2.getSelectedCard().getImageId();
		
		return null;	
	}

	public void lerCarta(int NJogador){
		GameEvent gameEvent = null;
		if (NJogador == 1)
		gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.READCARDJ1, "");
		if (NJogador == 2)
		gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.READCARDJ2, "");
		if (NJogador == 3)
		gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.READCARDM1, "");
		if (NJogador == 4)
		gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.READCARDM2, "");
		if (NJogador == 5)
		gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.READCARDZ1, "");
		if (NJogador == 6)
		gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.READCARDZ2, "");
		
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}

	
}


