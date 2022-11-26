package poo.modelo;

public class CardEnergia extends Card {
    private Type tipo;

    public CardEnergia(String anId, String anImageId, Type umTipo) {
        super(anId, anImageId);
        tipo = umTipo;
    }

    public Type getTipo() {
        return tipo;
    }
}
