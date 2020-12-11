package br.edu.uniritter.poo.model;

import java.util.List;

public class Vitoria {

    /**
     * Cria constructor em branco
     */
    public Vitoria () {

    }
    /**
     * Retorna qual jogador tem a maior quantidade de pontos
     * @param jgs
     * @return index
     */
    public int getVencedor (List<Jogador> jgs) {
        int maisPontos = 0, index = 0;
        for (int i = 0; i < jgs.size(); i++) {
            if (jgs.get(i).getPontos() > maisPontos) {
                maisPontos = jgs.get(i).getPontos();
                index = i;
            }
            else if (jgs.get(i).getPontos() == maisPontos) {
                index = -1;
            }
        }
        return index;
    }
}
