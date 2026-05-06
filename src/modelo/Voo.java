/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

public class Voo {

    private int codVoo;  //cod_voo num_voo data_hora_chegada data_hora_partida aviao companhia cod_destino cod_local_partida	

    private String numVoo;
    private Aeroporto AeroPartida;
    private Aeroporto AeroDestino;
    private LocalDateTime dataHoraPartida;
    private LocalDateTime dataHoraChegada;
    private String aviao;
    private String companhia;

    public Voo() {
    }

    public Voo(int codVoo, String numVoo, Aeroporto AeroPartida, Aeroporto AeroDestino, LocalDateTime dataHoraPartida, LocalDateTime dataHoraChegada,
            String aviao, String companhia) {
        this.codVoo = codVoo;
        this.AeroPartida = AeroPartida;
        this.AeroDestino = AeroDestino;
        this.dataHoraPartida = dataHoraPartida;
        this.dataHoraChegada = dataHoraChegada;
        this.aviao = aviao;
        this.companhia = companhia;
    }

    // Getters e Setters
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

    @Override
    public String toString() {
        return "Voo{" + "codVoo=" + codVoo + ", numVoo=" + numVoo + ", AeroPartida=" + AeroPartida + ", AeroDestino=" + AeroDestino + ", dataHoraPartida=" + dataHoraPartida + ", dataHoraChegada=" + dataHoraChegada + ", aviao=" + aviao + ", companhia=" + companhia + '}';
    }

}
