package br.com.webplanet.daos;

import java.util.Objects;

public class Aeroporto {
    private int codAeroporto;
    private String nomeAero;
    private Cidade cidade;
    private int status;

    public Aeroporto() {}

    public Aeroporto(int codAeroporto, String nomeAero, Cidade cidade, int status) {
        this.codAeroporto = codAeroporto;
        this.nomeAero = nomeAero;
        this.cidade = cidade;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCodAeroporto() { return codAeroporto; }
    public void setCodAeroporto(int codAeroporto) { this.codAeroporto = codAeroporto; }

    public String getNomeAero() { return nomeAero; }
    public void setNomeAero(String nomeAero) { this.nomeAero = nomeAero; }

    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.nomeAero);
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
        final Aeroporto other = (Aeroporto) obj;
        return Objects.equals(this.nomeAero, other.nomeAero);
    }

    @Override
    public String toString() {
        return "Aeroporto{" + "nomeAero=" + nomeAero + '}';
    }

}