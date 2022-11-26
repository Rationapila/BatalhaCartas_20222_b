package poo.modelo;

public class CardEnergia extends Card {
    private Type tipo;

    public CardEnergia(String anId, String anImageId, int val, Type umTipo) {
        super(anId, anImageId, val);
        tipo = umTipo;
    }

    public Type getTipo() {
        return tipo;
    }
}
