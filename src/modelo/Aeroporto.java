package modelo;

public class Aeroporto {
    private int codAeroporto;
    private String nomeAero;
    private Cidade cidade;

    public Aeroporto() {}

    public Aeroporto(int codAeroporto, String nomeAero, Cidade cidade) {
        this.codAeroporto = codAeroporto;
        this.nomeAero = nomeAero;
        this.cidade = cidade;
    }

    public int getCodAeroporto() { return codAeroporto; }
    public void setCodAeroporto(int codAeroporto) { this.codAeroporto = codAeroporto; }

    public String getNomeAero() { return nomeAero; }
    public void setNomeAero(String nomeAero) { this.nomeAero = nomeAero; }

    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "cod_aeroporto=" + codAeroporto +
                ", nome_aero=" + nomeAero +
                ", cod_cidade=" + (cidade != null ? cidade.getCodCidade() : null) +
                '}';
    }
}