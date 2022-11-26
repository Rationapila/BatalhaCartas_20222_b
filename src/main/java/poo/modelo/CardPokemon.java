package poo.modelo;

public class CardPokemon extends Card {
    private int hp;
    private Ataque ataque;
    private int custoRecuo;
    private Type tipo;
    private Estagio categoria;
    private Type fraqueza;
    private Type resistencia;

    public CardPokemon(String umId, String umImageId, int val, int umHp, Ataque umAtaque, int umCustoRecuo,
    Type umTipo, Estagio umEstagio, Type umaFraqueza, Type umaResistencia) {
        super(umId, umImageId, val);
        hp = umHp;
        ataque = umAtaque;
        custoRecuo = umCustoRecuo;
        tipo = umTipo;
        categoria = umEstagio;
        fraqueza = umaFraqueza;
        resistencia = umaResistencia;
    }


    public int getHp() {
        return hp;
    }

    public void recebeDano(int n) {
        hp -= n;
    }

    public Type getTipo() {
        return tipo;
    }

    public Type getFraqueza() {
        return fraqueza;
    }

    public Type getResistencia() {
        return tipo;
    }

}