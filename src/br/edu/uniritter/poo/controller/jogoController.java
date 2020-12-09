package br.edu.uniritter.poo.controller;

import br.edu.uniritter.poo.model.*;
import br.edu.uniritter.poo.view.jogadorView;
import br.edu.uniritter.poo.view.jogoView;
import java.util.ArrayList;
import java.util.List;

public class jogoController {
    private static jogoController instancia;
    private jogoView jgv;
    private jogadorView jdv;
    private Baralho bar;
    private Mesa mesa;
    private Pontos pts;
    private List<Jogador> jogadores;
    private int numRodada = 1;
    private int qtdJogadores;
    private int jogadorAtual = 0;
    private boolean finalizado = false;
    private Vitoria vit;
    private Jogador ultimoPontuador;

    public static jogoController getInstance () {
        if (instancia == null) {
            instancia = new jogoController();
        }
        return instancia;
    }
    public void iniciarJogo() {
        this.bar = new Baralho();
        this.mesa = new Mesa();
        this.pts = new Pontos();
        this.jgv = new jogoView();
        this.jdv = new jogadorView();
        this.vit = new Vitoria();
        char regras = jgv.verRegras();
        if (regras == 'S') {
            jgv.mostrarRegras();
        }
        this.qtdJogadores = jgv.quantidadeJogadores(2, 4);
        this.jogadores = new ArrayList<>();
        registrarJogadores();
        bar.embaralhar();
        distribuirJog();
        if (this.numRodada == 1) {
            distribuirMesa();
            if (this.pts.quinzeInicial(this.mesa)) {
                this.jogadores.get(0).addPontos(1);
            }
        }
        while (!this.finalizado) {
            if (this.jogadores.get(this.jogadorAtual).getMao().size() == 0) {
                distribuirJog();
            }
            iniciarRodada();
            jgv.continuar();
            proximoJogador();
            if (!bar.temCarta()) {
                int jogadoresFinalizados = 0;
                for (int x = 0; x < this.jogadores.size(); x++) {
                    if (this.jogadores.get(x).getMao().size() == 0) {
                        jogadoresFinalizados++;
                    }
                }
                if (jogadoresFinalizados == this.jogadores.size()) {
                    this.finalizado = true;
                }
            }
        }
        if (this.mesa.getMesa().size() > 0) {
            this.ultimoPontuador.adicionarAoDeck(this.mesa.getMesa());
            this.ultimoPontuador.addPontos(1);
        }
        for (int t = 0; t < this.jogadores.size(); t++) {
            if (this.pts.maisCartas(this.jogadores.get(t))) {
                this.jogadores.get(t).addPontos(1);
            }
            if (this.pts.maisOuros(this.jogadores.get(t))) {
                if (this.jogadores.get(t).getQtdOuros() == 10) {
                    this.jogadores.get(t).addPontos(8);
                }
                else {
                    this.jogadores.get(t).addPontos(1);
                }
            }
            if (this.pts.maisSetes(this.jogadores.get(t))) {
                if (this.jogadores.get(t).getQtdSetes() == 4) {
                    this.jogadores.get(t).addPontos(7);
                }
                else {
                    this.jogadores.get(t).addPontos(1);
                }
            }
            if (this.pts.todosOsAs(this.jogadores.get(t))) {
                this.jogadores.get(t).addPontos(4);
            }
        }
        jgv.mostrarVencedor(vit.getVencedor(this.jogadores));
        jgv.mostrarPlacarFinal(this.jogadores);
    }
    public void registrarJogadores () {
        for (int i = 1; i <= this.qtdJogadores; i++) {
            String nm = this.jgv.nomeJogador(i);
            this.jogadores.add(new Jogador(nm));
        }
    }
    public void distribuirJog () {
        for (int i = 0; i < this.qtdJogadores; i++) {
            for (int j = 0; j < 3; j++) {
                this.jogadores.get(i).receberCarta(this.bar.comprar());
            }
        }
    }
    public void distribuirMesa () {
        for (int i = 0; i < 4; i++) {
            this.mesa.receberCarta(this.bar.comprar());
        }
    }
    public void iniciarRodada () {
        this.jgv.mostrarRodada(this.numRodada);
        this.jgv.mostrarMesa(mesa);
        this.jgv.mostrarJogadorAtual(this.jogadores.get(this.jogadorAtual));
        this.jdv.mostrarMao(this.jogadores.get(this.jogadorAtual));
        if (this.jogadores.get(this.jogadorAtual).getMao().size() > 0 ) {
            escolherCartas((this.jdv.cartaMao(this.jogadores.get(this.jogadorAtual).getMao().size())-1));
        }
        this.jdv.mostrarDados(this.jogadores.get(this.jogadorAtual));
    }
    public void escolherCartas (int op) {
        List<Carta> cartasRodada;
        cartasRodada = new ArrayList<>();
        Carta cartaMao = this.jogadores.get(this.jogadorAtual).getMao().get(op);
        cartasRodada.add(cartaMao);
        if (this.mesa.getMesa().size() > 0) {
            int qtdCartas = jdv.qtdCartasMesa(this.mesa.getMesa().size());
            if (qtdCartas > 0) {
                for (int i = 1; i <= qtdCartas; i++) {
                    cartasRodada.add(this.mesa.getMesa().get(jdv.cartaMesa(this.mesa.getMesa().size())-1));
                }
            }
        }
        if (this.jogadores.get(this.jogadorAtual).jogar(cartasRodada)) {
            System.out.println("\nA soma deu 15 :D Cartas no deck.");
            this.ultimoPontuador = this.jogadores.get(this.jogadorAtual);
            this.mesa.removerCarta(cartasRodada);
            this.jogadores.get(this.jogadorAtual).adicionarAoDeck(cartasRodada);
            if (this.mesa.getMesa().size() == 0) {
                this.jogadores.get(this.jogadorAtual).addPontos(1);
                System.out.println("Parabéns, você fez uma ESCOVA!!!");
            }
            if  (this.pts.seteBelo(cartasRodada)) {
                this.jogadores.get(this.jogadorAtual).addPontos(1);
                System.out.println("Uhul! Sete belo no deck? Check!");
            }
        }
        else {
            System.out.println("\nVocê não tem jogo :( Carta na mesa.");
            this.mesa.receberCarta(cartasRodada.get(0));
        }
        this.jogadores.get(this.jogadorAtual).largarCarta(cartaMao);
    }
    public void proximoJogador () {
        this.jogadorAtual++;
        if (this.jogadorAtual == this.qtdJogadores) {
            this.jogadorAtual = 0;
            numRodada++;
        }
    }
}