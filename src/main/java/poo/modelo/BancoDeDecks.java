package poo.modelo;

public class BancoDeDecks {
    
    public static CardDeck getDeck(int nDeck){
        CardDeck deckj1 = new CardDeck(0);
        CardDeck deckj2 = new CardDeck(0);

        //Cartas do Jogador 1:

        //Pokemons:
        Ataque drool = new Ataque (2, 30, Type.INCOLOR);
        CardPokemon licktung = new CardPokemon("1", "1", 110, 4, Type.INCOLOR,
        Estagio.BASICO, Type.LUTADOR, null);
        licktung.addAtaque(drool);

        //Energias:
        CardEnergia incolor = new CardEnergia("3", "3", Type.INCOLOR);

        //Cartas do jogador 2:

        //Pokemons:
        Ataque punch = new Ataque(1, 10, Type.INCOLOR);
        CardPokemon pancham = new CardPokemon("2", "2", 70, 2, Type.LUTADOR, 
        Estagio.BASICO, Type.SOMBRIO, null);
        pancham.addAtaque(punch);




        //Adição de cartas:

        //Deck jogador 1:
        //Pokemons:
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        

        //Energias:
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);
        deckj1.addCard(incolor);



        //Deck jogador 2:
        //Pokemons:
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);

        
        //Energias
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);
        deckj2.addCard(incolor);


        
        if (nDeck == 1){
            return deckj1;
        }
        else if (nDeck == 2){
            return deckj2;
        }
        return null;
    }
    

}
