package br.edu.uniritter.poo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao;
    private List<Carta> deck;
    private int pontos = 0;
    private int qtdOuros = 0;
    private int qtdSetes = 0;
    private int qtdAs = 0;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        this.deck = new ArrayList<>();
    }
    public void receberCarta (Carta carta) {
        this.mao.add(carta);
    }
    public boolean jogar (List<Carta> cartas) {
        boolean jogada = false;
        int soma = 0;
        for (int i = 0; i < cartas.size(); i++) {
            soma+=cartas.get(i).getValor();
        }
        if (soma == 15) {
            jogada = true;

        }
        return jogada;
    }
    public void adicionarAoDeck (List<Carta> carta) {
        for (int i = 0; i < carta.size(); i++) {
            this.deck.add(carta.get(i));
        }
    }
    public void largarCarta (Carta carta) {
        this.mao.remove(carta);
    }
    public String getNome () {
        return this.nome;
    }
    public List<Carta> getMao () {
        return this.mao;
    }
    public int getPontos () {
        return this.pontos;
    }
    public List<Carta> getDeck () {
        return this.deck;
    }
    public int getQtdOuros () {
        return this.qtdOuros;
    }
    public void setQtdOuros () {
        this.qtdOuros++;
    }
    public int getQtdSetes () {
        return this.qtdSetes;
    }
    public void setQtdSetes () {
        this.qtdSetes++;
    }
    public int getQtdAs () {
        return this.qtdAs;
    }
    public void setQtdAs () {
        this.qtdAs++;
    }
    public void addPontos (int pts) {
        this.pontos += pts;
    }

    @Override
    public String toString () {
        return "Jogador(a): "+this.nome+"\n"+"Pontos: "+this.pontos+"\n"+"Deck: "+this.deck+"\n\n";
    }
}