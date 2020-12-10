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

    /**
     * Atualiza o nome do jogador e cria mão e deck para ele
     * @param nome
     */
    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        this.deck = new ArrayList<>();
    }
    /**
     * Adiciona carta à mão do jogador
     * @param carta
     */
    public void receberCarta (Carta carta) {
        this.mao.add(carta);
    }
    /**
     * Verifica se a soma das cartas que o jogador escolheu corresponde ao número 15
     * @param cartas
     * @return jogada
     */
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
    /**
     * Adiciona carta(s) ao deck do jogador
     * @param carta
     */
    public void adicionarAoDeck (List<Carta> carta) {
        for (int i = 0; i < carta.size(); i++) {
            this.deck.add(carta.get(i));
        }
    }
    /**
     * Remove carta da mão do jogador
     * @param carta
     */
    public void largarCarta (Carta carta) {
        this.mao.remove(carta);
    }
    /**
     * Retorna o nome do jogador
     * @return this.nome
     */
    public String getNome () {
        return this.nome;
    }
    /**
     * Retorna a mão do jogador
     * @return this.mao
     */
    public List<Carta> getMao () {
        return this.mao;
    }
    /**
     * Retorna os pontos do jogador
     * @return this.pontos
     */
    public int getPontos () {
        return this.pontos;
    }
    /**
     * Retorna o deck do jogador
     * @return this.deck
     */
    public List<Carta> getDeck () {
        return this.deck;
    }
    /**
     * Retorna a quantidade de Ouros do jogador
     * @return this.qtdOuros
     */
    public int getQtdOuros () {
        return this.qtdOuros;
    }
    /**
     * Atualiza a quantidade de Ouros do jogador
     */
    public void setQtdOuros () {
        this.qtdOuros++;
    }
    /**
     * Retorna a quantidade de Setes do jogador
     * @return this.qtdSetes
     */
    public int getQtdSetes () {
        return this.qtdSetes;
    }
    /**
     * Atualiza a quantidade de Setes do jogador
     */
    public void setQtdSetes () {
        this.qtdSetes++;
    }
    /**
     * Retorna a quantidade de Às do jogador
     * @return this.qtdAs
     */
    public int getQtdAs () {
        return this.qtdAs;
    }
    /**
     * Atualiza a quantidade de Às do jogador
     */
    public void setQtdAs () {
        this.qtdAs++;
    }
    /**
     * Adiciona o valor 1 aos pontos do jogador
     * @param pts
     */
    public void addPontos (int pts) {
        this.pontos += pts;
    }

    @Override
    public String toString () {
        return "Jogador(a): "+this.nome+"\n"+"Pontos: "+this.pontos+"\n"+"Deck: "+this.deck+"\n\n";
    }
}