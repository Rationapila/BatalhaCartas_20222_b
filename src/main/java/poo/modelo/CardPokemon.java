package poo.modelo;

public class CardPokemon extends Card {
    private int hp;
    //private String tipo;
    //private Strign fraqueza;
    public CardPokemon(String anId, String anImageId, int val, int anHp) {
        super(anId, anImageId, val);
        hp = anHp;
    }
}