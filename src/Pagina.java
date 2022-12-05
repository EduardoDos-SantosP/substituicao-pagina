package src;

public class Pagina {
    private int numero;
    private int instrucao;
    private int dado;
    private int r;
    private int m;
    private int tempoR;

    public Pagina(int numero) {
        instrucao = (this.numero = numero) + 1;
        dado = Util.random(50) + 1;
        tempoR = r = m = 0;
    }

    public void clock() {
        if (r == 1 && ++tempoR >= 50) tempoR = r = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(int instrucao) {
        this.instrucao = instrucao;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return numero == ((Pagina) o).numero;
    }

    @Override
    public String toString() {
        return "src.Pagina{" +
                "numero=" + numero +
                ", dado=" + dado +
                ", r=" + r +
                ", m=" + m +
                '}';
    }
}
