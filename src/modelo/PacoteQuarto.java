package modelo;

public class PacoteQuarto {
    private int codPacote;
    private int codQuarto;

    public PacoteQuarto() {}

    public PacoteQuarto(int codPacote, int codQuarto) {
        this.codPacote = codPacote;
        this.codQuarto = codQuarto;
    }

    public int getCodPacote() { return codPacote; }
    public int getCodQuarto() { return codQuarto; }

    public void setCodPacote(int codPacote) { this.codPacote = codPacote; }
    public void setCodQuarto(int codQuarto) { this.codQuarto = codQuarto; }

    @Override
    public String toString() {
        return "PacoteQuarto{codPacote=" + codPacote + ", codQuarto=" + codQuarto + '}';
    }
}