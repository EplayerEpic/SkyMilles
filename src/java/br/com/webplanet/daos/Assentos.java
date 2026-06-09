package br.com.webplanet.daos;

public class Assentos {
    private int codAssento;
    private int numBilhete;
    private String dataEmissao;
    private String classe;
    private double valorAss;
    private boolean status;
    private int codDestino;
    private int codLocalPartida;
    private Voo voo;

    public Assentos() {}

    public Assentos(int codAssento, int numBilhete, String dataEmissao, String classe,
            double valorAss, boolean status,
            int codDestino, int codLocalPartida, Voo voo) {
        this.codAssento = codAssento;
        this.numBilhete = numBilhete;
        this.dataEmissao = dataEmissao;
        this.classe = classe;
        this.valorAss = valorAss;
        this.status = status;
        this.codDestino = codDestino;
        this.codLocalPartida = codLocalPartida;
        this.voo = voo;
    }

    public int getCodAssento() { return codAssento; }
    public int getNumBilhete() { return numBilhete; }
    public String getDataEmissao() { return dataEmissao; }
    public String getClasse() { return classe; }
    public double getValorAss() { return valorAss; }
    public boolean isStatus() { return status; }
    public int getCodDestino() { return codDestino; }
    public int getCodLocalPartida() { return codLocalPartida; }
    public Voo getVoo() { return voo; }

    public void setCodAssento(int codAssento) { this.codAssento = codAssento; }
    public void setNumBilhete(int numBilhete) { this.numBilhete = numBilhete; }
    public void setDataEmissao(String dataEmissao) { this.dataEmissao = dataEmissao; }
    public void setClasse(String classe) { this.classe = classe; }
    public void setValorAss(double valorAss) { this.valorAss = valorAss; }
    public void setStatus(boolean status) { this.status = status; }
    public void setCodDestino(int codDestino) { this.codDestino = codDestino; }
    public void setCodLocalPartida(int codLocalPartida) { this.codLocalPartida = codLocalPartida; }
    public void setVoo(Voo voo) { this.voo = voo; }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.codAssento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assentos other = (Assentos) obj;
        return this.codAssento == other.codAssento;
    }

    @Override
    public String toString() {
        return "Assentos{" + "codAssento=" + codAssento + '}';
    }

    
    
}