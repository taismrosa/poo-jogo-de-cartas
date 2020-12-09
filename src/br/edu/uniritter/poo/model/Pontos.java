package br.edu.uniritter.poo.model;

import java.util.List;
import static java.lang.Integer.parseInt;

public class Pontos {
    private int maiorQtdCartas = 0;
    private int maiorQtdOuros = 0;
    private int maiorQtdSetes = 0;

    public Pontos () {

    }
    public boolean quinzeInicial (Mesa cartasMesa) {
        boolean ret = false;
        int soma = 0;
        for (int i = 0; i < cartasMesa.getMesa().size(); i++) {
            soma += cartasMesa.getMesa().get(i).getValor();
        }
        if (soma <= 15) {
            System.out.println("\nA soma das cartas foi menor ou igual a 15. Parabéns, você ganhou um ponto!");
            ret = true;
        }
        return ret;
    }
    public boolean seteBelo (List<Carta> cartas) {
        boolean ret = false;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).toString().contains("7 de Ouro")) {
                ret = true;
            }
        }
        return ret;
    }
    public boolean maisCartas (Jogador jg) {
        boolean vencedor = false;
        if (jg.getDeck().size() > this.maiorQtdCartas) {
            this.maiorQtdCartas = jg.getDeck().size();
            vencedor = true;
        }
        return vencedor;
    }
    public boolean maisOuros (Jogador jg) {
        boolean vencedor = false;
        for (int i = 0; i < jg.getDeck().size(); i++) {
            if (jg.getDeck().get(i).getNaipe() == " de Ouro") {
                jg.setQtdOuros();
            }
        }
        if (jg.getQtdOuros() > this.maiorQtdOuros) {
            this.maiorQtdOuros = jg.getQtdOuros();
            vencedor = true;
        }
        return vencedor;
    }
    public boolean maisSetes (Jogador jg) {
        boolean vencedor = false;
        for (int i = 0; i < jg.getDeck().size(); i++) {
            if (jg.getDeck().get(i).getValor() == 7) {
                jg.setQtdSetes();
            }
        }
        if (jg.getQtdSetes() > this.maiorQtdSetes) {
            this.maiorQtdSetes = jg.getQtdSetes();
            vencedor = true;
        }
        return vencedor;
    }
    public boolean todosOsAs (Jogador jg) {
        boolean vencedor = false;
        for (int i = 0; i < jg.getDeck().size(); i++) {
            if (jg.getDeck().get(i).getValor() == 1) {
                jg.setQtdAs();
            }
        }
        if (jg.getQtdAs() == 4) {
            vencedor = true;
        }
        return vencedor;
    }
}