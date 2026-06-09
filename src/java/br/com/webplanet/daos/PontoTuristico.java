package br.com.webplanet.daos;

public class PontoTuristico {
    private int codPonto;
    private String descricao;
    private String endereco;
    private Cidade cidade;

    public PontoTuristico() {}

    public PontoTuristico(int codPonto, String descricao, String endereco, Cidade cidade) {
        this.codPonto = codPonto;
        this.descricao = descricao;
        this.endereco = endereco;
        this.cidade = cidade;
    }
    public PontoTuristico(String descricao, String endereco, Cidade cidade) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    // Getters e Setters
    public int getCodPonto() { return codPonto; }
    public void setCodPonto(int codPonto) { this.codPonto = codPonto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.codPonto;
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
        final PontoTuristico other = (PontoTuristico) obj;
        return this.codPonto == other.codPonto;
    }

    @Override
    public String toString() {
        return "PontoTuristico{" + "codPonto=" + codPonto + ", descricao=" + descricao + ", endereco=" + endereco + ", cidade=" + cidade + '}';
    }

}