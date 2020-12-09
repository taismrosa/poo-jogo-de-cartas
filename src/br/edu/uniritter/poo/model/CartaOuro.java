package br.edu.uniritter.poo.model;

public class CartaOuro extends Carta {
    public CartaOuro (int valor) {
        this.valor = valor;
    }

    @Override
    public String getNaipe () {
        return " de Ouro";
    }
}
