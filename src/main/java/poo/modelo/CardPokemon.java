package poo.modelo;

import java.util.ArrayList;

public class CardPokemon extends Card {
    private int hp;
    private ArrayList<Ataque> ataques;
    private int custoRecuo;
    private Type tipo;
    private Type tipoAtaque;
    private Estagio categoria;
    private Type fraqueza;
    private Type resistencia;
    private int contadorEnergia = 0;

    public CardPokemon(String umId, String umImageId, int umHp, int umCustoRecuo,
    Type umTipo, Estagio umEstagio, Type umaFraqueza, Type umaResistencia, Type tipoAtaque) {
        super(umId, umImageId);
        hp = umHp;
        ataques = new ArrayList<Ataque>();
        custoRecuo = umCustoRecuo;
        tipo = umTipo;
        categoria = umEstagio;
        fraqueza = umaFraqueza;
        resistencia = umaResistencia;
    }

    public CardPokemon (String umId, String umImageId){
        //Construtor apenas para comparações.
        super(umId, umImageId);
    }

    public void addEnergia(Type tipoEnergia){
        if (tipoEnergia == tipoAtaque)
        contadorEnergia++;
    }
    
    public int getHp() {
        return hp;
    }

    /**
     * @param int valor a ser adicionado ou removido do hp do pokemon
     * valores positivos para causar dano e negativos para cura
     */
    public void setHp(int n) {
        hp += (n);
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

    public void recebeDano(int dano){
        hp -= dano;
    }

    public Type getFraqueza() {
        return fraqueza;
    }

    public Type getResistencia() {
        return resistencia;
    }

    public int getCustoRecuo() {
        return custoRecuo;
    }

    public Estagio getCategoria() {
        return categoria;
    }

}