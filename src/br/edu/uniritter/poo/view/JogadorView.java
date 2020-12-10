package br.edu.uniritter.poo.view;

import br.edu.uniritter.poo.model.Jogador;

import java.util.Scanner;

public class JogadorView {
    Scanner scan = new Scanner(System.in);

    /**
     * Imprime a mão do jogador
     * @param j
     */
    public void mostrarMao (Jogador j) {
        System.out.println(j.getMao());
    }
    /**
     * Imprime os dados do jogador
     * @param j
     */
    public void mostrarDados (Jogador j) {
        System.out.println(j);
    }
    /**
     * Retorna a opção inserida pelo usuário correspondente à posição de uma carta na mão do jogador
     * @param size
     * @return option
     */
    public int cartaMao (int size) {
        int option = 0;
        do {
            System.out.println("\nQual carta você vai utilizar/largar? Informe a posição dela na SUA mão [1/2/3]: ");
            option = scan.nextInt();
        } while (option < 1 || option > size);
        return option;
    }
    /**
     * Retorna a opção inserida pelo usuário correspondente à posição de uma carta na mesa
     * @param size
     * @return option
     */
    public int cartaMesa (int size) {
        int option = 0;
        do {
            System.out.println("Escolha qual carta da MESA você irá pegar e informe a posição [1/2/3/4]: ");
            option = scan.nextInt();
        } while (option > size || option < 0);
        return option;
    }
    /**
     * Retorna a quantidade de cartas que o usuário informou que irá utilizar
     * @param size
     * @return option
     */
    public int qtdCartasMesa (int size) {
        int option = 0;
        do {
            System.out.println("Informe QUANTAS cartas da mesa você irá pegar: ");
            option = scan.nextInt();
        } while (option > size || option < 0);
        return option;
    }
}