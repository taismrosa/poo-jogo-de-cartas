package br.edu.uniritter.poo.model;

public abstract class Carta {
    protected int valor;

    /**
     * Retorna o valor da carta
     * @return this.valor
     */
    public int getValor () {
        return this.valor;
    }
    /**
     * Retorna uma String informando o valor e naipe da carta
     * @return
     */
    public String getDescricao () {
        return getNomeValor()+getNaipe();
    }
    /**
     * Caso o valor da carta corresponda a uma figura, o número é substituído pelo nome dela
     * @return ret
     */
    public String getNomeValor () {
        String ret = "";
        if (this.valor >= 2 || this.valor <= 7) {
            ret = this.valor+"";
        }
        else {
            switch (this.valor) {
                case 1:
                    ret = "Ás";
                    break;
                case 8:
                    ret = "Valete";
                    break;
                case 9:
                    ret = "Cavaleiro";
                    break;
                case 10:
                    ret = "Rei";
                    break;
            }
        }
        return ret;
    }
    /**
     * Retorna o naipe da carta
     * @return String
     */
    public abstract String getNaipe();

    @Override
    public String toString () {
        return getDescricao();
    }
}