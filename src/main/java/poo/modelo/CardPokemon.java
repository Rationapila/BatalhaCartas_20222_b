package poo.modelo;

import java.util.ArrayList;

public class CardPokemon extends Card {
    private int hp;
    private ArrayList<Ataque> ataques;
    private int custoRecuo;
    private Type tipo;
    private Estagio categoria;
    private Type fraqueza;
    private Type resistencia;

    public CardPokemon(String umId, String umImageId, int umHp, int umCustoRecuo,
    Type umTipo, Estagio umEstagio, Type umaFraqueza, Type umaResistencia) {
        super(umId, umImageId);
        hp = umHp;
        ataques = new ArrayList<>();
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

    public void addAtaque(Ataque e) {
        ataques.add(e);
    }

    public Ataque getAtaque(int i) {
        return ataques.get(i);
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

    public int getCustoRecuo() {
        return custoRecuo;
    }

}