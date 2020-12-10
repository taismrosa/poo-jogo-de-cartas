package br.edu.uniritter.poo.model;

public class CartaCopas extends Carta {
    /**
     * Atualiza o valor da carta
     * @param valor
     */
    public CartaCopas (int valor) {
        this.valor = valor;
    }

    @Override
    public String getNaipe () {
        return " de Copas";
    }
}
