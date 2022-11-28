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

}