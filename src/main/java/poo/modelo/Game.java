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
	private CardPokemon pokemonZ1, pokemonZ2;
	private boolean comecoJogo, preparoJ1, preparoJ2;
	private int pontosJ1 = 0, pontosJ2 = 0;
	
	public static Game getInstance() {
		return game;
	}

	private Game() {
		vidaPj1 = 0;
		vidaPj2 = 0;
		deckj1 = BancoDeDecks.getDeck(1);
		deckj2 = BancoDeDecks.getDeck(2); 
		maoj1 = new CardDeck(0);
		maoj2 = new CardDeck(0);
		mesaJ1 = new CardDeck(0);
		mesaJ2 = new CardDeck(0);
		zonaPrincipalJ1 = new CardDeck(0);
		zonaPrincipalJ2 = new CardDeck(0);
		player = 1;
		jogadas = maoj1.getNumberOfCards();
		observers = new LinkedList<>();
		comparadorPokemon = new CardPokemon("", "");
		comecoJogo = true;
	}

	public void nextPlayer() {
		player++;
		if (player == 3) {
			player = 1;
		}
		play(player);
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
	

	public void playComeco() {
		deckj1.shuffle();
		deckj2.shuffle();
		for (int i = 0; i < 7; i++){
			drawCardP1();
			drawCardP2();
		}
		garantePokemonJ1();
		garantePokemonJ2();
	}
	
	public void play(int proxJogador){
		GameEvent gameEvent = null;
		if (proxJogador == 1){
			if (zonaPrincipalJ1.getCard(0) == null){
				pontosJ2 = 6;
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ENDGAME, "");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			}
		}

		if (proxJogador == 2){
			if (zonaPrincipalJ2.getCard(0) == null){
				pontosJ1 = 6;
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ENDGAME, "");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			}
		}
	}

	public int getPontosJ1(){
		return pontosJ1;
	}

	public int getPontosJ2(){
		return pontosJ2;
	}
	public Boolean getComeco(){
		return comecoJogo;
	}

	public void preparacao(int nJogador){
		if (Game.getInstance().getComeco() == true){
			if (nJogador == 1){
				preparoJ1 = true;
				if (preparoJ2 == true){
					comecoJogo = false;
					play(1);
				}
			}
			if (nJogador == 2){
				preparoJ2 = true;
				if (preparoJ1 == true){
					comecoJogo = false;
					play(1);
				}
			}
		}
	}

	public void garantePokemonJ1(){
		boolean temCartaPokemonJ1 = false;
		while (temCartaPokemonJ1 == false){
			
			for (int i = 0; i < maoj1.getNumberOfCards(); i++) {
				if (maoj1.getCard(i).getClass() == comparadorPokemon.getClass()){
					CardPokemon aCard = (CardPokemon)maoj1.getCard(i);
					if (aCard.getCategoria() == Estagio.BASICO){
						temCartaPokemonJ1 = true;
					}
				}
			}
			if (temCartaPokemonJ1 == false){
				while (maoj1.getCard(0) != null) {
					deckj1.addCard(maoj1.getCard(0));
					maoj1.removeIndex(0);
				}
				deckj1.shuffle();
				for (int i = 0; i < 7; i++){
					drawCardP1();
				}
			}
		}
	}

	public void garantePokemonJ2(){
		boolean temCartaPokemonJ2 = false;
		while (temCartaPokemonJ2 == false){
			for (int i = 0; i < maoj2.getNumberOfCards(); i++) {
				if (maoj2.getCard(i).getClass() == comparadorPokemon.getClass()){
					CardPokemon aCard = (CardPokemon)maoj2.getCard(i);
					if (aCard.getCategoria() == Estagio.BASICO){
						temCartaPokemonJ2 = true;
					}
				}
			}
			if (temCartaPokemonJ2 == false){
				while (maoj2.getCard(0) != null) {
					deckj2.addCard(maoj2.getCard(0));
					maoj2.removeIndex(0);
				}
				deckj2.shuffle();
				for (int i = 0; i < 7; i++){
					drawCardP2();
				}
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

	public int getVez(){
		return player;
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
		if (getVez() == 1 || getComeco() == true){
			mesaJ1.addCard( maoj1.getSelectedCard());
			maoj1.removeSel();
		}
		
	}

	public void colocaReservaJ2(){
		if (getVez() == 2 || getComeco() == true){
			mesaJ2.addCard(maoj2.getSelectedCard());
			maoj2.removeSel();
		}
	}

	public void colocaZonaJ1(){
		if (getVez() == 1 || getComeco() == true){
			GameEvent gameEvent = null;
			if (zonaPrincipalJ1.getNumberOfCards() == 1){
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ZONETAKEN, "");
				
			}
			else{
				zonaPrincipalJ1.addCard(maoj1.getSelectedCard());
				vidaPj1 = ((CardPokemon)zonaPrincipalJ1.getCard(0)).getHp();
				pokemonZ1 = ((CardPokemon)zonaPrincipalJ1.getCard(0));
				maoj1.removeSel();
			}
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
		}
	}

	public void colocaZonaJ2(){
		if (getVez() == 2 || getComeco() == true){
			GameEvent gameEvent = null;
			if (zonaPrincipalJ2.getNumberOfCards() == 1){
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ZONETAKEN, "");
			}
			else{
				zonaPrincipalJ2.addCard(maoj2.getSelectedCard());
				vidaPj2 = ((CardPokemon)zonaPrincipalJ2.getCard(0)).getHp();
				pokemonZ2 = ((CardPokemon)zonaPrincipalJ2.getCard(0));
				maoj2.removeSel();
			}
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
		}
	}

	public int getVidaZ1(){
		Card PokemonZ1 = comparadorPokemon;
		for (int i = 0; i < zonaPrincipalJ1.getNumberOfCards(); i++){
			if (zonaPrincipalJ1.getCard(i).getClass() == comparadorPokemon.getClass()){
				PokemonZ1 = zonaPrincipalJ1.getCard(i);
		}
	}
		CardPokemon Pokemon = (CardPokemon) PokemonZ1;
		return Pokemon.getHp();
	}

	public void ataqueZ1(int NumeroAtaque){
		if (getVez() == 1){
			GameEvent gameEvent = null;
			if (zonaPrincipalJ2.getSelectedCard() != null){
				if (NumeroAtaque == 1){
					int dano = pokemonZ1.getAtaque(0).getDano();
					if (pokemonZ1.getTipo() == pokemonZ2.getFraqueza())
						dano *= 2;
					if (pokemonZ1.getTipo() == pokemonZ2.getResistencia())
						dano -= 20;
					if (dano < 0)
						dano = 0;
					vidaPj2 -= dano;
				}
				if (vidaPj2 <= 0) {
						vidaPj2 = 0;
						zonaPrincipalJ2.setSelectedCard(zonaPrincipalJ2.getCard(0));
						zonaPrincipalJ2.removeSel();
				}
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			}
			nextPlayer();
		}	
	}

	public void ataqueZ2(int NumeroAtaque){
		if (getVez() == 2){
			GameEvent gameEvent = null;
			if (zonaPrincipalJ1.getSelectedCard() != null){
				if (NumeroAtaque == 1){
					int dano = pokemonZ2.getAtaque(0).getDano();
					if (pokemonZ2.getTipo() == pokemonZ1.getFraqueza())
						dano *= 2;
					if (pokemonZ2.getTipo() == pokemonZ1.getResistencia())
						dano -= 20;
					if (dano < 0)
						dano = 0;
					vidaPj1 -= dano;
				}
				if (vidaPj1 <= 0) {
						vidaPj1 = 0;
						zonaPrincipalJ1.setSelectedCard(zonaPrincipalJ1.getCard(0));
						zonaPrincipalJ1.removeSel();
				}
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			}
			nextPlayer();
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


