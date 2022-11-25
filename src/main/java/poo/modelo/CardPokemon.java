package poo.modelo;

public class CardPokemon extends Card {
    private int hp;
    private int ataque;
    private int custoRecuo;
    private String nome;
    private Tipo tipo;
    private Categoria categoria;
    private Fraqueza fraqueza;
    private Resistencia resistencia;

    private enum Tipo {
        AGUA, FOGO, ELETRICO, PSIQUICO, LUTADOR, SOMBRIO, ACO, FADA, DRAGAO, INCOLOR
    }

    private enum Categoria {
        BASICO, ESTAGIO1, ESTAGIO2, VMAX
    }

    private enum Fraqueza {

    }

    private enum Resistencia {

    }

    public CardPokemon(String anId, String anImageId, String anNome, int val, int anHp, int anAtaque, int anCustoRecuo,
            String anTipo, String anCategoria, String anFraqueza, String anResistencia) {
        super(anId, anImageId, val);
        nome = anNome;
        hp = anHp;
        ataque = anAtaque;
        custoRecuo = anCustoRecuo;
        tipo = Tipo.valueOf(anTipo);
        categoria = Categoria.valueOf(anCategoria);
        fraqueza = Fraqueza.valueOf(anFraqueza);
        resistencia = Resistencia.valueOf(anResistencia);
    }
}