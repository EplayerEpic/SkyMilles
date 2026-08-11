package br.com.webplanet.daos;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class Voo {

    private int codVoo;
    private String numVoo;
    private Aeroporto AeroPartida;
    private Aeroporto AeroDestino;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataHoraPartida;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataHoraChegada;

    private String aviao;
    private String companhia;
    private int status;

    public Voo() {
    }

    public Voo(int codVoo, String numVoo, Aeroporto AeroPartida, Aeroporto AeroDestino,
            LocalDateTime dataHoraPartida, LocalDateTime dataHoraChegada,
            String aviao, String companhia) {
        this.codVoo = codVoo;
        this.AeroPartida = AeroPartida;
        this.AeroDestino = AeroDestino;
        this.dataHoraPartida = dataHoraPartida;
        this.dataHoraChegada = dataHoraChegada;
        this.aviao = aviao;
        this.companhia = companhia;
    }

    public int getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(int codVoo) {
        this.codVoo = codVoo;
    }

    public String getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(String numVoo) {
        this.numVoo = numVoo;
    }

    public Aeroporto getAeroPartida() {
        return AeroPartida;
    }

    public void setAeroPartida(Aeroporto AeroPartida) {
        this.AeroPartida = AeroPartida;
    }

    public Aeroporto getAeroDestino() {
        return AeroDestino;
    }

    public void setAeroDestino(Aeroporto AeroDestino) {
        this.AeroDestino = AeroDestino;
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(LocalDateTime dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public LocalDateTime getDataHoraChegada() {
        return dataHoraChegada;
    }

    public void setDataHoraChegada(LocalDateTime data) {
        this.dataHoraChegada = data;
    }

    public String getAviao() {
        return aviao;
    }

    public void setAviao(String aviao) {
        this.aviao = aviao;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Voo{" + "codVoo=" + codVoo + ", numVoo=" + numVoo
                + ", AeroPartida=" + AeroPartida + ", AeroDestino=" + AeroDestino
                + ", dataHoraPartida=" + dataHoraPartida
                + ", dataHoraChegada=" + dataHoraChegada
                + ", aviao=" + aviao + ", companhia=" + companhia + '}';
    }
}