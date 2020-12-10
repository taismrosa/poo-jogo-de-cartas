package br.edu.uniritter.poo.view;

import br.edu.uniritter.poo.model.Jogador;
import br.edu.uniritter.poo.model.Mesa;
import java.util.List;
import java.util.Scanner;

public class JogoView {
    Scanner scanner = new Scanner(System.in);

    /**
     * Retorna se o usuário quer ver as regras ou não
     * @return resp
     */
    public char verRegras () {
        char resp;
        do {
            System.out.println("Antes de iniciar a partida, deseja ver as regras? [S/N]");
            resp = scanner.next().charAt(0);
        } while (resp != 'S' && resp != 'N');
        return resp;
    }
    /**
     * Imprime as regras do jogo
     */
    public void mostrarRegras () {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("                                          REGRAS - ESCOVA                                          ");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(" 1. Podem ter entre 2 e 4 jogadores;    ");
        System.out.println(" 2. São 52 cartas no total, porém, as cartas 8, 9 e 10 são retiradas e substituídas,");
        System.out.println(" respectivamente, pelas cartas Valete, Cavaleiro e Rei;");
        System.out.println(" 3. Sendo assim, consideramos 40 cartas com 4 naipes (Ouro, Copas, Espadas e Paus);");
        System.out.println(" 4. No início do jogo, os jogadores são registrados e a ordem definida será refletida");
        System.out.println(" na partida. Ou seja, o primeiro cadastrado é o primeiro a jogar e o último será o carteador;");
        System.out.println(" 5. A cada rodada, o carteador deve distribuir 3 cartas para cada jogador e, somente na primeira");
        System.out.println(" rodada, deverão ser postas 4 cartas na mesa para o início do jogo");
        System.out.println(" 6. A partida é encerrada quando todas as cartas do baralho acabarem.");
        System.out.println(" 7. O fluxo do jogo é, a cada rodada, o jogador escolher uma de suas cartas na mão e somar");
        System.out.println(" o valor 15 junto às cartas da mesa. Por exemplo: tenho a carta 7 e há uma carta 8 na mesa,");
        System.out.println(" o total desses valores é 15, isto é, uma jogada válida. Quando isso ocorre, o jogador pega");
        System.out.println(" todas as cartas que compõe o 15 somado e adiciona em um deck individual.");
        System.out.println(" 8. Se a jogada utilizar todas as cartas da mesa, ou seja, mesa vazia, uma das cartas no deck");
        System.out.println(" fica virada para cima e isso é considerado uma escova, gerando 1 ponto no final do jogo.");
        System.out.println(" 9. A partida é encerrada quando todas as cartas do baralho geral (manuseado pelo carteador)");
        System.out.println(" acabarem.");
        System.out.println(" 10. O vencedor é aquele que atingir mais pontos");
        System.out.println(" 11. Se, na primeira rodada, ao distribuir as cartas na mesa, o valor ser igual ou menor que 15,");
        System.out.println(" o carteador é beneficiado com 1 ponto.");
        System.out.println(" 12. Se, ao final do jogo, sobrar carta(s) na mesa, estas são adicionas no deck do último jogador");
        System.out.println(" que pontuou.");
        System.out.println(" 13. Tabela de pontos: ");
        System.out.println("     15 inicial (somente carteador): 1 ponto");
        System.out.println("     Último de mesa: 1 ponto");
        System.out.println("     Cada escova: 1 ponto");
        System.out.println("     Sete Belo (7 de Ouro): 1 ponto");
        System.out.println("     Maior número de cartas: 1 ponto");
        System.out.println("     Maior número de Ouros: 1 ponto");
        System.out.println("     Maior número de Setes: 1 ponto");
        System.out.println("     Todos os Às: 4 pontos");
        System.out.println("     Todos os Ouros: 8 pontos");
        System.out.println("     Todos os Setes: 7 pontos\n\n");
    }
    /**
     * Retorna a quantidade de jogadores que serão registrados
     * @param min
     * @param max
     * @return qtd
     */
    public int quantidadeJogadores (int min, int max) {
        int qtd;
        System.out.println("Número de jogadores (2 a 4): ");
        do {
            qtd = scanner.nextInt();
        } while (qtd < min || qtd > max);
        return qtd;
    }
    /**
     * Retorna o nome inserido pelo usuário
     * @param num
     * @return nome
     */
    public String nomeJogador (int num) {
        System.out.println("Informe o nome do jogador "+(num)+": ");
        String nome = scanner.next();
        return nome;
    }
    /**
     * Imprime o número da rodada
     * @param num
     */
    public void mostrarRodada (int num) {
        System.out.println("\n@@@@@@@@@@@@@@@@");
        System.out.println("     RODADA "+num);
        System.out.println("@@@@@@@@@@@@@@@@");
    }
    /**
     * Imprime a mesa
     * @param mesa
     */
    public void mostrarMesa (Mesa mesa) {
        System.out.println(mesa);
    }
    /**
     * Imprime o nome do jogador que deve jogar
     * @param j
     */
    public void mostrarJogadorAtual (Jogador j) {
        System.out.println("Agora é a vez de "+j.getNome());
    }
    /**
     * Imprime que a jogada foi válida
     */
    public void jogadaValida () {
        System.out.println("\nBOA! A soma deu 15 :D Cartas no deck.");
    }
    /**
     * Imprime que a jogada foi inválida
     */
    public void jogadaInvalida () {
        System.out.println("\nVocê não tem jogo :( Carta na mesa.");
    }
    /**
     * Imprime que foi realizada uma escova
     */
    public void jogadaComEscova () {
        System.out.println("Parabéns, você fez uma ESCOVA!!!");
    }
    /**
     * Imprime que a carta 7 de Ouro estava incluída na jogada
     */
    public void jogadaComSeteBelo () {
        System.out.println("Uhul! Sete belo no deck? Check!");
    }
    /**
     * Informa que, para continuar o jogo, o usuário deve teclar ENTER
     */
    public static void continuar () {
        Scanner scanEnter = new Scanner(System.in);
        System.out.println("Tecle ENTER para prosseguir");
        String pressKey = scanEnter.nextLine();
    }
    /**
     * Imprime o jogador vencedor
     * @param vencedor
     */
    public void mostrarVencedor (Jogador vencedor) {
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
        System.out.println("                       O VENCEDOR É...                       ");
        System.out.println("                       "+vencedor+"                          ");
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
    }
    /**
     * Retorna se o usuário quer ver as regras ou não
     * @return resp
     */
    public char verPlacarFinal () {
        char resp;
        do {
            System.out.println("Quer ver o placar final? [S/N]");
            resp = scanner.next().charAt(0);
        } while (resp != 'S' && resp != 'N');
        return resp;
    }
    /**
     * Imprime a pontuação de todos os jogadores
     * @param jogadores
     */
    public void mostrarPlacarFinal (List<Jogador> jogadores) {
        System.out.println(" PLACAR FINAL ");
        System.out.println(jogadores);
    }
}