package br.edu.uniritter.poo.model;

public abstract class Carta {
    protected int valor;

    public int getValor () {
        return this.valor;
    }
    public String getDescricao () {
        return getNomeValor()+getNaipe();
    }
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
    public abstract String getNaipe();

    @Override
    public String toString () {
        return getDescricao();
    }
}