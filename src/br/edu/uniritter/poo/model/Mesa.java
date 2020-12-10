package br.edu.uniritter.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<Carta> mesa;

    /**
     * Cria uma lista de cartas em "mesa"
     */
    public Mesa () {
        this.mesa = new ArrayList<>();
    }
    /**
     * Adiciona carta à mes
     * @param carta
     */
    public void receberCarta (Carta carta) {
        this.mesa.add(carta);
    }
    /**
     * Remove carta(s) da mesa
     * @param carta
     */
    public void removerCarta (List<Carta> carta) {
        for (int i = 0; i < carta.size(); i++) {
            if (this.mesa.contains(carta.get(i))) {
                this.mesa.remove(carta.get(i));
            }
        }
    }
    /**
     * Retorna a lista de cartas "mesa"
     * @return this.mesa
     */
    public List<Carta> getMesa () {
        return this.mesa;
    }

    @Override
    public String toString () {
        return "\nNa mesa: "+this.mesa+"\n";
    }
}
