package br.edu.uniritter.poo.view;

import br.edu.uniritter.poo.model.Jogador;

import java.util.Scanner;

public class jogadorView {
    Scanner scan = new Scanner(System.in);

    public void mostrarMao (Jogador j) {
        System.out.println(j.getMao());
    }
    public void mostrarDados (Jogador j) {
        System.out.println(j);
    }
    public int cartaMao (int size) {
        int option = 0;
        do {
            System.out.println("\nQual carta você vai utilizar/largar? Informe a posição dela na SUA mão [1/2/3]: ");
            option = scan.nextInt();
        } while (option < 1 || option > size);
        return option;
    }
    public int cartaMesa (int size) {
        int option = 0;
        do {
            System.out.println("Escolha qual carta da MESA você irá pegar e informe a posição [1/2/3/4]: ");
            option = scan.nextInt();
        } while (option > size || option < 0);
        return option;
    }
    public int qtdCartasMesa (int size) {
        int option = 0;
        do {
            System.out.println("Informe QUANTAS cartas da mesa você irá pegar: ");
            option = scan.nextInt();
        } while (option > size || option < 0);
        return option;
    }
}