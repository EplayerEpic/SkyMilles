package modelo;

public class Quarto {
    private int codQuarto;
    private double valorReserva;
    private String localSaida;
    private String localChegada;
    private String dataInicio;
    private int qntdDiarias;
    private Pacote pacote;
    private Hotel hotel;

    public Quarto() {}

    public Quarto(int codQuarto, double valorReserva, String localSaida, String localChegada, 
                  String dataInicio, int qntdDiarias, Pacote pacote, Hotel hotel) {
        this.codQuarto = codQuarto;
        this.valorReserva = valorReserva;
        this.localSaida = localSaida;
        this.localChegada = localChegada;
        this.dataInicio = dataInicio;
        this.qntdDiarias = qntdDiarias;
        this.pacote = pacote;
        this.hotel = hotel;
    }
    public Quarto(double valorReserva, String localSaida, String localChegada, 
                  String dataInicio, int qntdDiarias, Pacote pacote, Hotel hotel) {
        this.valorReserva = valorReserva;
        this.localSaida = localSaida;
        this.localChegada = localChegada;
        this.dataInicio = dataInicio;
        this.qntdDiarias = qntdDiarias;
        this.pacote = pacote;
        this.hotel = hotel;
    }

    // Getters e Setters
    public int getCodQuarto() { return codQuarto; }
    public void setCodQuarto(int codQuarto) { this.codQuarto = codQuarto; }
    public double getValorReserva() { return valorReserva; }
    public void setValorReserva(double valorReserva) { this.valorReserva = valorReserva; }
    public String getLocalSaida() { return localSaida; }
    public void setLocalSaida(String localSaida) { this.localSaida = localSaida; }
    public String getLocalChegada() { return localChegada; }
    public void setLocalChegada(String localChegada) { this.localChegada = localChegada; }
    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }
    public int getQntdDiarias() { return qntdDiarias; }
    public void setQntdDiarias(int qntdDiarias) { this.qntdDiarias = qntdDiarias; }
    public Pacote getPacote() { return pacote; }
    public void setPacote(Pacote pacote) { this.pacote = pacote; }
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codQuarto;
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
        final Quarto other = (Quarto) obj;
        return this.codQuarto == other.codQuarto;
    }

    @Override
    public String toString() {
        return ""+codQuarto;
    }
    
    
}