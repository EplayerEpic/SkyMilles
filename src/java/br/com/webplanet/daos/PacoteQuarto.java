package br.com.webplanet.daos;

import java.util.Objects;

public class PacoteQuarto {
    private Pacote pacote;
    private Quarto quarto;

    public PacoteQuarto() {}

    public PacoteQuarto(Pacote pacote, Quarto quarto) {
        this.pacote = pacote;
        this.quarto = quarto;
    }

    public Pacote getPacote() { return pacote; }
    public Quarto getQuarto() { return quarto; }

    public void setPacote(Pacote pacote) { this.pacote = pacote; }
    public void setQuarto(Quarto quarto) { this.quarto = quarto; }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.pacote);
        hash = 83 * hash + Objects.hashCode(this.quarto);
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
        final PacoteQuarto other = (PacoteQuarto) obj;
        if (!Objects.equals(this.pacote, other.pacote)) {
            return false;
        }
        return Objects.equals(this.quarto, other.quarto);
    }

    @Override
    public String toString() {
        return "Pacote: " + pacote + ", Quarto:" + quarto;
    }

    


}