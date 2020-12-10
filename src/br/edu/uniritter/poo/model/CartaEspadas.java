package br.edu.uniritter.poo.model;

public class CartaEspadas extends Carta {
    /**
     * Atualiza o valor da carta
     * @param valor
     */
    public CartaEspadas (int valor) {
        this.valor = valor;
    }

    @Override
    public String getNaipe () {
        return " de Espadas";
    }
}