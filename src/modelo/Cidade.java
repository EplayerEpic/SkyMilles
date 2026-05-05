package modelo;

public class Cidade {
    private int codCidade;
    private String ddd;
    private String estado;
    private String nomeCidade;

    public Cidade() {}

    public Cidade(int codCidade, String ddd, String estado, String nomeCidade) {
        this.codCidade = codCidade;
        this.ddd = ddd;
        this.estado = estado;
        this.nomeCidade = nomeCidade;
    }

    // Getters e Setters
    public int getCodCidade() { return codCidade; }
    public void setCodCidade(int codCidade) { this.codCidade = codCidade; }

    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getNomeCidade() { return nomeCidade; }
    public void setNomeCidade(String nomeCidade) { this.nomeCidade = nomeCidade; }

    @Override
    public String toString() {
        return "Cidade{" + "cod_cidade=" + codCidade + ", ddd=" + ddd + 
               ", estado=" + estado + ", nome_cidade=" + nomeCidade + '}';
    }
}