package poo.modelo;

public class BancoDeDecks {
    
    public static CardDeck getDeck(int nDeck){
        CardDeck deckj1 = new CardDeck(0);
        CardDeck deckj2 = new CardDeck(0);

        //Cartas do Jogador 1:

        //Pokemons:
        Ataque drool = new Ataque (2, 30, Type.INCOLOR);
        CardPokemon licktung = new CardPokemon("1", "1", 110, 4, Type.INCOLOR,
        Estagio.BASICO, Type.LUTADOR, null, Type.INCOLOR, null);
        licktung.addAtaque(drool);

        Ataque tongueSlap = new Ataque (2, 50, Type.INCOLOR);
        Ataque heavyImpact = new Ataque (4, 130, Type.INCOLOR);
        CardPokemon lickilicky = new CardPokemon("5", "5", 140, 4, Type.INCOLOR,
        Estagio.BASICO, Type.LUTADOR, null, Type.INCOLOR, "1");
        lickilicky.addAtaque(tongueSlap);
        lickilicky.addAtaque(heavyImpact);

        //Energias:
        CardEnergia incolor = new CardEnergia("3", "3", Type.INCOLOR);

        //Cartas do jogador 2:

        //Pokemons:

        Ataque punch = new Ataque(1, 10, Type.INCOLOR);
        CardPokemon pancham = new CardPokemon("2", "2", 70, 2, Type.LUTADOR, 
        Estagio.BASICO, Type.SOMBRIO, null, Type.INCOLOR, null);
        pancham.addAtaque(punch);

        Ataque socoDeLuz = new Ataque(1, 40, Type.INCOLOR);
        Ataque socoMagnum = new Ataque(3, 90, Type.INCOLOR);
        CardPokemon pangoro = new CardPokemon("4", "4", 130, 2, Type.LUTADOR, Estagio.ESTAGIO1, Type.SOMBRIO, null, 
        Type.INCOLOR, "2");
        pangoro.addAtaque(socoDeLuz);
        pangoro.addAtaque(socoMagnum);




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
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);


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
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);

        
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
