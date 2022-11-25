package poo.modelo;

public class CardPokemon extends Card {
    private int hp;
    private int ataque;
    private int custoRecuo;
    private String nome;
    private String fraqueza;

    private enum tipo {
        AGUA, FOGO, ELETRICO, PSIQUICO, LUTADOR, SOMBRIO, ACO, FADA, DRAGAO, INCOLOR
    }

    private enum categoria {
        BASICO, ESTAGIO1, ESTAGIO2, VMAX
    }

    private enum fraqueza {

    }

    private enum resistencia {

    }

    public CardPokemon(String anId, String anImageId, int val, int anHp) {
        super(anId, anImageId, val);
        hp = anHp;
    }
}