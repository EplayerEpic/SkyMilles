package modelo;

public class PacoteAssento {
    private int codPacote;
    private int codAssento;

    public PacoteAssento() {}

    public PacoteAssento(int codPacote, int codAssento) {
        this.codPacote = codPacote;
        this.codAssento = codAssento;
    }

    public int getCodPacote() { return codPacote; }
    public int getCodAssento() { return codAssento; }

    public void setCodPacote(int codPacote) { this.codPacote = codPacote; }
    public void setCodAssento(int codAssento) { this.codAssento = codAssento; }

    @Override
    public String toString() {
        return "PacoteAssento{codPacote=" + codPacote + ", codAssento=" + codAssento + '}';
    }
}