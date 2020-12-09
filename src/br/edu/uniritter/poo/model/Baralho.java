package br.edu.uniritter.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho () {
        this.cartas = new ArrayList<>();
        for (int v = 1; v <= 10; v++) {
            this.cartas.add(new CartaOuro(v));
            this.cartas.add(new CartaCopas(v));
            this.cartas.add(new CartaEspadas(v));
            this.cartas.add(new CartaPaus(v));
        }
    }
    public void embaralhar () {
        Collections.shuffle(this.cartas);
    }
    public Carta comprar () {
        Carta ret = null;
        if (temCarta()) {
            ret = this.cartas.remove(0);
        }
        return ret;
    }
    public boolean temCarta () {
        return this.cartas.size() != 0;
    }
}
