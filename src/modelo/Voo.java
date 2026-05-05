/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Voo {
    private int codVoo;  //cod_voo	num_voo	data_hora_chegada	data_hora_partida	aviao	companhia	cod_destino	cod_local_partida	

    private String numVoo ;
    private int codLocalPartida;
    private int codDestino;
    private String dataHoraPartida;
    private String dataHoraChegada;
    private String aviao;
    private String companhia;

    public Voo() {}

    public Voo(int codVoo, String numVoo, int codLocalPartida,int codDestino, String dataHoraPartida, String dataHoraChegada, 
                  String aviao, String companhia) {
        this.codVoo = codVoo;
        this.codLocalPartida = codLocalPartida;
        this.codDestino = codDestino;
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

    public int getCodLocalPartida() {
        return codLocalPartida;
    }

    public void setCodLocalPartida(int codLocalPartida) {
        this.codLocalPartida = codLocalPartida;
    }

    public int getCodDestino() {
        return codDestino;
    }

    public void setCodDestino(int codDestino) {
        this.codDestino = codDestino;
    }

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(String dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public String getDataHoraChegada() {
        return dataHoraChegada;
    }

    public void setDataHoraChegada(String dataHoraChegada) {
        this.dataHoraChegada = dataHoraChegada;
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
        return "Voo{" + "codVoo=" + codVoo + ", numVoo=" + numVoo + ", codLocalPartida=" + codLocalPartida + ", codDestino=" + codDestino + ", dataHoraPartida=" + dataHoraPartida + ", dataHoraChegada=" + dataHoraChegada + ", aviao=" + aviao + ", companhia=" + companhia + '}';
    }
    
}