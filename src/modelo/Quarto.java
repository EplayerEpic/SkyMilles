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
    public Pacote getCodPacote() { return pacote; }
    public void setCodPacote(Pacote pacote) { this.pacote = pacote; }
    public Hotel getCodHotel() { return hotel; }
    public void setCodHotel(Hotel hotel) { this.hotel = hotel; }
    
    @Override
    public String toString() {
        return "Quarto{" + "cod_quarto = " + codQuarto + ", valor_reserva = " + valorReserva + 
               ", local_saida = " + localSaida + ", local_chegada = " + localChegada + 
                ", data_inicio = "+dataInicio +", qntd_diarias = "+ qntdDiarias+ ", cod_pacote = "
                +pacote+", cod_hotel = "+hotel+'}';
    }
}