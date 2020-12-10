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
     * @return vencedor
     */
    public Jogador getVencedor (List<Jogador> jgs) {
        Jogador vencedor = null;
        int maisPontos = 0;
        for (int i = 0; i < jgs.size(); i++) {
            if (jgs.get(i).getPontos() > maisPontos) {
                maisPontos = jgs.get(i).getPontos();
                vencedor = jgs.get(i);
            }
        }
        return vencedor;
    }
}
