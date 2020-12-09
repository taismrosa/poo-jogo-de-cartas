package br.edu.uniritter.poo.model;

public class CartaPaus extends Carta {
    public CartaPaus (int valor) {
        this.valor = valor;
    }

    @Override
    public String getNaipe () {
        return " de Paus";
    }
}