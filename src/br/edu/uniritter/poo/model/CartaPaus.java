package br.edu.uniritter.poo.model;

public class CartaPaus extends Carta {
    /**
     * Atualiza o valor da carta
     * @param valor
     */
    public CartaPaus (int valor) {
        this.valor = valor;
    }

    @Override
    public String getNaipe () {
        return " de Paus";
    }
}