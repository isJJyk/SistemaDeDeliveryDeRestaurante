package Sistema.entities.contas;

import java.util.Arrays;

public class Cardapio {
    private String[] opcoes = {"porcao de camarao", "lasanha", "almondega"};

    public String[] getOpcoes() {
        return this.opcoes;
    }


    public String toString() {
        return "Pratos: " + Arrays.toString(getOpcoes());
    }
}
