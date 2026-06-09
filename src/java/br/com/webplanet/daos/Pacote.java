/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.webplanet.daos;

/**
 *
 * @author aluno
 */
public class Pacote {
    private int codPacote;
    private double valorPacote;
    private Quarto quarto;
    private Assentos assento;

    public Pacote() {
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Assentos getAssento() {
        return assento;
    }

    public void setAssento(Assentos assento) {
        this.assento = assento;
    }
    

    public Pacote(int codPacote, double valorPacote,Quarto quarto, Assentos assento) {
        this.codPacote = codPacote;
        this.valorPacote = valorPacote;
        this.quarto = quarto;
        this.assento = assento;
    }

    public int getCodPacote() {
        return codPacote;
    }

    public void setCodPacote(int codPacote) {
        this.codPacote = codPacote;
    }

    public double getValorPacote() {
        return valorPacote;
    }

    public void setValorPacote(double valorPacote) {
        this.valorPacote = valorPacote;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codPacote;
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
        final Pacote other = (Pacote) obj;
        return this.codPacote == other.codPacote;
    }

    @Override
    public String toString() {
        return "codPacote:" + codPacote;
    }

    
    
}
