package br.edu.uniritter.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    /**
     * Adiciona 10 cartas de cada naipe ao baralho
     */
    public Baralho () {
        this.cartas = new ArrayList<>();
        for (int v = 1; v <= 10; v++) {
            this.cartas.add(new CartaOuro(v));
            this.cartas.add(new CartaCopas(v));
            this.cartas.add(new CartaEspadas(v));
            this.cartas.add(new CartaPaus(v));
        }
    }
    /**
     * Modifica a ordem das cartas do baralho de forma aleatória
     */
    public void embaralhar () {
        Collections.shuffle(this.cartas);
    }
    /**
     * Remove primeira a carta do baralho
     * @return ret
     */
    public Carta comprar () {
        Carta ret = null;
        if (temCarta()) {
            ret = this.cartas.remove(0);
        }
        return ret;
    }
    /**
     * Verifica se o baralho está vazio
     * @return true or false
     */
    public boolean temCarta () {
        return this.cartas.size() != 0;
    }
}
