package poo.modelo;

import org.apache.commons.io.filefilter.TrueFileFilter;

public class CardTreinador extends Card {
    
    public CardTreinador(String anId, String anImageId) {
        super(anId, anImageId);
    }

    public static void Hop(){
        if (Game.getInstance().getVez() == 1){
            Game.getInstance().drawCardP1();
            Game.getInstance().drawCardP1();
            Game.getInstance().drawCardP1();
        }
        if (Game.getInstance().getVez() == 2){
            Game.getInstance().drawCardP2();
            Game.getInstance().drawCardP2();
            Game.getInstance().drawCardP2();
        }
    }

    public static void HyperPotion(){
        if (Game.getInstance().getVez() == 1){
            if (Game.getInstance().getPokemonZ1().getCountEnergia() >= 2){
                CardPokemon c = Game.getInstance().getPokemonZ1();
                Game.getInstance().curaP1(120);
            }
        }
        if (Game.getInstance().getVez() == 2){
            if (Game.getInstance().getPokemonZ2().getCountEnergia() >= 2){
                CardPokemon c = Game.getInstance().getPokemonZ2();
                Game.getInstance().curaP2(120);
            }
        }
        Game.getInstance().notificar();
    }

    public static void Potion(){
        if (Game.getInstance().getVez() == 1){
                Game.getInstance().curaP1(30);
        }
        if (Game.getInstance().getVez() == 2){
            Game.getInstance().curaP2(30);
    }
        Game.getInstance().notificar();
    }

    public static void ProfessorResearch(){
        if (Game.getInstance().getVez() == 1){
            Game.getInstance().professorResearchEfeito(1);
        }
        if (Game.getInstance().getVez() == 2){
            Game.getInstance().professorResearchEfeito(2);
        }
        Game.getInstance().notificar();
    }

    public static void TeamYellTowel(){
            Game.getInstance().curaP1(50);
            Game.getInstance().curaP2(50);
    }
}