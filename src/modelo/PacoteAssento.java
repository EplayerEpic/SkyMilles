package modelo;

import java.util.Objects;

public class PacoteAssento {
    private Pacote pacote;
    private Assentos assento;

    public PacoteAssento() {}

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public Assentos getAssento() {
        return assento;
    }

    public void setAssento(Assentos assento) {
        this.assento = assento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.pacote);
        hash = 71 * hash + Objects.hashCode(this.assento);
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
        final PacoteAssento other = (PacoteAssento) obj;
        if (!Objects.equals(this.pacote, other.pacote)) {
            return false;
        }
        return Objects.equals(this.assento, other.assento);
    }

    @Override
    public String toString() {
        return "PacoteAssento{" + "pacote=" + pacote + ", assento=" + assento + '}';
    }

    

    
}