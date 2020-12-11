package br.edu.uniritter.poo.controller;

import br.edu.uniritter.poo.model.*;
import br.edu.uniritter.poo.view.JogadorView;
import br.edu.uniritter.poo.view.JogoView;
import java.util.ArrayList;
import java.util.List;

public class JogoController {
    private static JogoController instancia;
    private JogoView jgv;
    private JogadorView jdv;
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

    /**
     * Cria apenas uma instância de JogoController
     * @return instancia
     */
    public static JogoController getInstance () {
        if (instancia == null) {
            instancia = new JogoController();
        }
        return instancia;
    }
    /**
     * Prepara os objetos necessários para o jogo
     */
    public void preJogo () {
        this.bar = new Baralho();
        this.mesa = new Mesa();
        this.pts = new Pontos();
        this.jgv = new JogoView();
        this.jdv = new JogadorView();
        this.vit = new Vitoria();
        verRegras();
        this.qtdJogadores = this.jgv.quantidadeJogadores(2, 4);
        this.jogadores = new ArrayList<>();
        registrarJogadores();
        this.bar.embaralhar();
        distribuirJog();
        distribuirMesa();
        iniciarJogo();
    }
    /**
     * Garante que, enquanto houver cartas no baralho e na mão dos jogadores, o jogo continua
     */
    public void iniciarJogo() {
        verificarPrimeiraMesa();
        while (!this.finalizado) {
            if (this.jogadores.get(this.jogadorAtual).getMao().size() == 0) {
                distribuirJog();
            }
            iniciarRodada();
            jgv.continuar();
            proximoJogador();
            if (!this.bar.temCarta()) {
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
        encerrarJogo();
    }
    /**
     * Verifica se o jogador quer ler as regras
     */
    public void verRegras () {
        char regras = this.jgv.verRegras();
        if (regras == 'S') {
            this.jgv.mostrarRegras();
        }
    }
    /**
     * Adiciona os dados registrados para a lista de jogadores
     */
    public void registrarJogadores () {
        for (int i = 1; i <= this.qtdJogadores; i++) {
            String nm = this.jgv.nomeJogador(i);
            this.jogadores.add(new Jogador(nm));
        }
    }
    /**
     * Distribui 3 cartas para cada jogador
     */
    public void distribuirJog () {
        for (int i = 0; i < this.qtdJogadores; i++) {
            for (int j = 0; j < 3; j++) {
                this.jogadores.get(i).receberCarta(this.bar.comprar());
            }
        }
    }
    /**
     * Distribui 4 cartas na mesa
     */
    public void distribuirMesa () {
        for (int i = 0; i < 4; i++) {
            this.mesa.receberCarta(this.bar.comprar());
        }
    }
    /**
     * Adiciona 1 ponto ao carteador caso ele tenha atendido ao critério de "quinzeInicial()"
     */
    public void verificarPrimeiraMesa () {
        if (this.pts.quinzeInicial(this.mesa)) {
            this.jogadores.get((this.jogadores.size())-1).addPontos(1);
        }
    }
    /**
     * A cada rodada, espera as ações e atualiza os dados de cada jogador
     */
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
    /**
     * Gerencia as mudanças de estado de jogador e mesa (adicionar ou largar cartas)
     * @param op
     */
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
            jgv.jogadaValida();
            this.ultimoPontuador = this.jogadores.get(this.jogadorAtual);
            this.mesa.removerCarta(cartasRodada);
            this.jogadores.get(this.jogadorAtual).adicionarAoDeck(cartasRodada);
            if (this.mesa.getMesa().size() == 0) {
                this.jogadores.get(this.jogadorAtual).addPontos(1);
                jgv.jogadaComEscova();
            }
            if  (this.pts.seteBelo(cartasRodada)) {
                this.jogadores.get(this.jogadorAtual).addPontos(1);
                jgv.jogadaComSeteBelo();
            }
        }
        else {
            jgv.jogadaInvalida();
            this.mesa.receberCarta(cartasRodada.get(0));
        }
        this.jogadores.get(this.jogadorAtual).largarCarta(cartaMao);
    }
    /**
     * Atualiza o próximo jogador, caso esteja no último, inicia nova rodada
     */
    public void proximoJogador () {
        this.jogadorAtual++;
        if (this.jogadorAtual == this.qtdJogadores) {
            this.jogadorAtual = 0;
            numRodada++;
        }
    }
    /**
     * Faz a contagem de pontos finais e retorna o vencedor do jogo
     */
    public void encerrarJogo () {
        if (this.mesa.getMesa().size() > 0) {
            this.ultimoPontuador.adicionarAoDeck(this.mesa.getMesa());
            this.ultimoPontuador.addPontos(1);
        }
        if (this.pts.maisCartas(this.jogadores) != -1) {
            this.jogadores.get(this.pts.maisCartas(this.jogadores)).addPontos(1);
        }
        if (this.pts.maisOuros(this.jogadores) != -1) {
            if (this.jogadores.get(pts.maisOuros(this.jogadores)).getQtdOuros() == 10) {
                this.jogadores.get(pts.maisOuros(this.jogadores)).addPontos(8);
            }
            else {
                this.jogadores.get(pts.maisOuros(this.jogadores)).addPontos(1);
            }
        }
        if (this.pts.maisSetes(this.jogadores) != -1) {
            if (this.jogadores.get(this.pts.maisSetes(this.jogadores)).getQtdSetes() == 4) {
                this.jogadores.get(this.pts.maisSetes(this.jogadores)).addPontos(7);
            }
            else {
                this.jogadores.get(this.pts.maisSetes(this.jogadores)).addPontos(1);
            }
        }
        if (this.pts.todosOsAs(this.jogadores) != -1) {
            this.jogadores.get(this.pts.todosOsAs(this.jogadores)).addPontos(4);
        }
        if (vit.getVencedor(this.jogadores) > -1) {
            jgv.mostrarVencedor(this.jogadores.get(vit.getVencedor(this.jogadores)));
        }
        else {
            jgv.mostrarEmpate();
        }
        verPlacar();
    }
    /**
     * Verifica se o jogador quer ver o placar final
     */
    public void verPlacar () {
        char placar = jgv.verPlacarFinal();
        if (placar == 'S') {
            jgv.mostrarPlacarFinal(this.jogadores);
        }
    }
}