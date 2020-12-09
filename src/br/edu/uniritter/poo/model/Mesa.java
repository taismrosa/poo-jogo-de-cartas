package br.edu.uniritter.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<Carta> mesa;

    public Mesa () {
        this.mesa = new ArrayList<>();
    }
    public void receberCarta (Carta carta) {
        this.mesa.add(carta);
    }
    public void removerCarta (List<Carta> carta) {
        for (int i = 0; i < carta.size(); i++) {
            if (this.mesa.contains(carta.get(i))) {
                this.mesa.remove(carta.get(i));
            }
        }
    }
    public List<Carta> getMesa () {
        return this.mesa;
    }

    @Override
    public String toString () {
        return "\nNa mesa: "+this.mesa+"\n";
    }
}
