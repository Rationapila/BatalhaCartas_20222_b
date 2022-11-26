package poo.modelo;

public class BancoDeDecks {
    
    public static CardDeck getDeck(int nDeck){
        CardDeck deckj1 = new CardDeck(0);
        CardDeck deckj2 = new CardDeck(0);

        //Cartas do Jogador 1:
        Ataque drool = new Ataque (2, 30, Type.INCOLOR);
        CardPokemon licktung = new CardPokemon("1", "1", 110, 4, Type.INCOLOR,
        Estagio.BASICO, Type.LUTADOR, null);
        licktung.addAtaque(drool);

        //Cartas do jogador 2:
        Ataque punch = new Ataque(1, 10, Type.INCOLOR);
        CardPokemon pancham = new CardPokemon("2", "2", 70, 2, Type.LUTADOR, 
        Estagio.BASICO, Type.SOMBRIO, null);
        pancham.addAtaque(punch);



        deckj1.addCard(licktung);
        deckj2.addCard(pancham);
        if (nDeck == 1){
            return deckj1;
        }
        else if (nDeck == 2){
            return deckj2;
        }
        return null;
    }
    

}
