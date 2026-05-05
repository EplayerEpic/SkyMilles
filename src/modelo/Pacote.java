/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author aluno
 */
public class Pacote {
    private int codPacote;
    private double valorPacote;

    public Pacote() {
    }

    public Pacote(int codPacote, double valorPacote) {
        this.codPacote = codPacote;
        this.valorPacote = valorPacote;
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
    public String toString() {
        return "Pacote{" + "codPacote=" + codPacote + ", valorPacote=" + valorPacote + '}';
    }
    
}
