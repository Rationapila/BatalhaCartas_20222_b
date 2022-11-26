package poo.modelo;

public class BancoDeDecks {
    
    public static CardDeck getDeck(int nDeck){
        CardDeck deckj1 = new CardDeck(0);
        CardDeck deckj2 = new CardDeck(0);

        //Cartas do Jogador 1:
        Ataque ataqueLicktung = new Ataque (2, 30, Type.NORMAL);
        CardPokemon Licktung = new CardPokemon("1", "1", 0, 110, ataqueLicktung, 4, Type.NORMAL,
        Estagio.BASICO, Type.LUTADOR, null);



        deckj1.addCard(Licktung);
        if (nDeck == 1){
            return deckj1;
        }
        else if (nDeck == 2){
            return deckj2;
        }
        return null;
    }
    

}
