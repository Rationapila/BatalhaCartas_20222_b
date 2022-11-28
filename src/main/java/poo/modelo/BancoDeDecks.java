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
        Estagio.ESTAGIO1, Type.LUTADOR, null, Type.INCOLOR, "1");
        lickilicky.addAtaque(tongueSlap);
        lickilicky.addAtaque(heavyImpact);

        Ataque ram = new Ataque(2, 20, Type.AGUA);
        Ataque waveSplash = new Ataque(3, 40, Type.AGUA);
        CardPokemon dewpider = new CardPokemon("6", "6", 60, 1, Type.AGUA,
        Estagio.BASICO, Type.GRAMA, null, Type.AGUA, null);
        dewpider.addAtaque(waveSplash);
        dewpider.addAtaque(ram);

        Ataque aquaWave = new Ataque(3, 80, Type.AGUA);
        CardPokemon lapras = new CardPokemon("7", "7", 60, 2, Type.AGUA,
        Estagio.BASICO, Type.GRAMA, null, Type.AGUA, null);
        lapras.addAtaque(aquaWave);

        Ataque rollingTackle = new Ataque(3, 80, Type.INCOLOR);
        CardPokemon snorlax = new CardPokemon("8", "8", 150, 4, Type.INCOLOR,
        Estagio.BASICO, Type.LUTADOR, null, Type.INCOLOR, null);
        snorlax.addAtaque(rollingTackle);
        snorlax.addAtaque(heavyImpact);

        //Energias:
        CardEnergia incolor = new CardEnergia("3", "3", Type.INCOLOR);
        CardEnergia agua = new CardEnergia("12", "12", Type.AGUA);


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

        Ataque rollingTackle2 = new Ataque(4, 90, Type.LUTADOR);
        Ataque mudSlap = new Ataque(2, 30, Type.LUTADOR);
        CardPokemon hippopotas = new CardPokemon("9", "9", 100, 4, Type.LUTADOR,
        Estagio.BASICO, Type.GRAMA, null, Type.LUTADOR, null);
        hippopotas.addAtaque(mudSlap);
        hippopotas.addAtaque(rollingTackle2);

        Ataque landCrush = new Ataque(4, 120, Type.LUTADOR);
        CardPokemon onix = new CardPokemon("10", "10", 120, 4, Type.LUTADOR, 
        Estagio.BASICO, Type.GRAMA, null, Type.LUTADOR, null);
        onix.addAtaque(landCrush);

        Ataque lungeOut = new Ataque(2, 30, Type.LUTADOR);
        Ataque seismicToss = new Ataque(3, 110, Type.LUTADOR);
        CardPokemon throh = new CardPokemon("11", "11", 120, 3, Type.LUTADOR, 
        Estagio.BASICO, Type.PSIQUICO, null, Type.LUTADOR, null);
        throh.addAtaque(lungeOut);
        throh.addAtaque(seismicToss);

        //Energias:
        CardEnergia luta = new CardEnergia("13", "13", Type.LUTADOR);

        //Adição de cartas:

        //Deck jogador 1:
        //Pokemons:
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(licktung);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(lickilicky);
        deckj1.addCard(dewpider);
        deckj1.addCard(dewpider);
        deckj1.addCard(dewpider);
        deckj1.addCard(dewpider);
        deckj1.addCard(lapras);
        deckj1.addCard(lapras);
        deckj1.addCard(lapras);
        deckj1.addCard(lapras);
        deckj1.addCard(snorlax);
        deckj1.addCard(snorlax);
        deckj1.addCard(snorlax);
        deckj1.addCard(snorlax);
        


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
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);
        deckj1.addCard(agua);




        //Deck jogador 2:
        //Pokemons:
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pancham);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(pangoro);
        deckj2.addCard(hippopotas);
        deckj2.addCard(hippopotas);
        deckj2.addCard(hippopotas);
        deckj2.addCard(hippopotas);
        deckj2.addCard(onix);
        deckj2.addCard(onix);
        deckj2.addCard(onix);
        deckj2.addCard(onix);
        deckj2.addCard(throh);
        deckj2.addCard(throh);
        deckj2.addCard(throh);
        deckj2.addCard(throh);

        
        //Energias
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        deckj2.addCard(luta);
        
        


        
        if (nDeck == 1){
            return deckj1;
        }
        else if (nDeck == 2){
            return deckj2;
        }
        return null;
    }
    

}
