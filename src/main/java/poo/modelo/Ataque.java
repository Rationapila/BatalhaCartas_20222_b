package poo.modelo;

public class Ataque {
    private int custo;
    private Type tipo;
    private int dano;

    public Ataque(int umCusto, int umDano, Type umTipo) {
        custo = umCusto;
        dano = umDano;
        tipo = umTipo;
    }
}
