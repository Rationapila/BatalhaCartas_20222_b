package poo.modelo;

import org.apache.commons.io.filefilter.TrueFileFilter;

public class CardTreinador extends Card {
    private String efeito;
    
    public CardTreinador(String anId, String anImageId, String umEfeito) {
        super(anId, anImageId);
        efeito = umEfeito;
    }

    public String getEfeito() {
        return efeito;
    }
}
