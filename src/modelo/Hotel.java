package modelo;

import java.time.LocalDate;

public class Hotel {

    private int codHotel;
    private String CNPJ;
    private String local;
    private String endereco;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Cidade cidade;

    public Hotel() {
    }

    public Hotel(int codHotel, String CNPJ, String local, String endereco,
                 LocalDate checkIn, LocalDate checkOut, Cidade cidade) {
        this.codHotel = codHotel;
        this.CNPJ = CNPJ;
        this.local = local;
        this.endereco = endereco;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cidade = cidade;
    }

    public int getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(int codHotel) {
        this.codHotel = codHotel;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Cidade getCodCidade() {
        return cidade;
    }

    public void setCodCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Hotel = {" + " cod_hotel=" + codHotel +
                ", CNPJ='" + CNPJ  +
                ", _local='" + local  +
                ", endereco='" + endereco +
                ", check_in=" + checkIn +
                ", check_out=" + checkOut +
                ", cod_cidade=" + cidade + " } ";
    }
}