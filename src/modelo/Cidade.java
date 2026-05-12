package modelo;

import java.util.Objects;

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
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.nomeCidade);
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
        final Cidade other = (Cidade) obj;
        return Objects.equals(this.nomeCidade, other.nomeCidade);
    }

    @Override
    public String toString() {
        return nomeCidade;
    }

    
    
}