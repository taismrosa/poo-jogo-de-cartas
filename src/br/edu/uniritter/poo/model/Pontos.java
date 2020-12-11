package br.edu.uniritter.poo.model;

import java.util.List;
import static java.lang.Integer.parseInt;

public class Pontos {

    /**
     * Cria um constructor em branco
     */
    public Pontos () {

    }
    /**
     * Verifica se a soma das cartas é igual ou menor a quinze
     * @param cartasMesa
     * @return ret
     */
    public boolean quinzeInicial (Mesa cartasMesa) {
        boolean ret = false;
        int soma = 0;
        for (int i = 0; i < cartasMesa.getMesa().size(); i++) {
            soma += cartasMesa.getMesa().get(i).getValor();
        }
        if (soma <= 15) {
            System.out.println("\n\nA soma das cartas foi menor ou igual a 15. O carteador ganhou 1 ponto!");
            ret = true;
        }
        return ret;
    }
    /**
     * Verifica se uma das cartas é 7 de Ouro
     * @param cartas
     * @return ret
     */
    public boolean seteBelo (List<Carta> cartas) {
        boolean ret = false;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).toString().contains("7 de Ouro")) {
                ret = true;
            }
        }
        return ret;
    }
    /**
     * Retorna o jogador que tem o maior número de cartas no deck
     * @param jgs
     * @return index
     */
    public int maisCartas (List<Jogador> jgs) {
        int maiorQtd = 0, index = -1;
        for (int i = 0; i < jgs.size(); i++) {
            if (jgs.get(i).getDeck().size() > maiorQtd) {
                maiorQtd = jgs.get(i).getDeck().size();
                index = i;
            }
            else if (jgs.get(i).getDeck().size() == maiorQtd) {
                index = -1;
            }
        }
        return index;
    }
    /**
     * Retorna o jogador que tem o maior número de cartas do naipe Ouro no deck
     * @param jgs
     * @return index
     */
    public int maisOuros (List<Jogador> jgs) {
        int maiorQtd = 0, index = -1;
        for (int i = 0; i < jgs.size(); i++) {
            for (int j = 0; j < jgs.get(i).getDeck().size(); j++) {
                if (jgs.get(i).getDeck().get(j).getNaipe() == " de Ouro") {
                    jgs.get(i).setQtdOuros();
                }
            }
            if (jgs.get(i).getQtdOuros() > maiorQtd) {
                maiorQtd = jgs.get(i).getQtdOuros();
                index = i;
            }
            else if (jgs.get(i).getQtdOuros() == maiorQtd) {
                index = -1;
            }
        }
        return index;
    }
    /**
     * Retorna o jogador que tem o maior número de cartas de valor 7
     * @param jgs
     * @return index
     */
    public int maisSetes (List<Jogador> jgs) {
        int maiorQtd = 0, index = 0;
        for (int i = 0; i < jgs.size(); i++) {
            for (int j = 0; j < jgs.get(i).getDeck().size(); j++) {
                if (jgs.get(i).getDeck().get(j).getValor() == 7) {
                    jgs.get(i).setQtdSetes();
                }
            }
            if (jgs.get(i).getQtdSetes() > maiorQtd) {
                maiorQtd = jgs.get(i).getQtdSetes();
                index = i;
            }
            else if (jgs.get(i).getQtdSetes() == maiorQtd) {
                index = -1;
            }
        }
        return index;
    }
    /**
     * Verifica se o jogador tem quatro cartas de valor Às no deck
     * @param jgs
     * @return index
     */
    public int todosOsAs (List<Jogador> jgs) {
        int index = -1;
        for (int i = 0; i < jgs.size(); i++) {
            for (int j = 0; j < jgs.get(i).getDeck().size(); j++) {
                if (jgs.get(i).getDeck().get(j).getValor() == 1) {
                    jgs.get(i).setQtdAs();
                }
            }
            if (jgs.get(i).getQtdAs() == 4) {
                index = i;
            }
        }
        return index;
    }
}