/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author aluno
 */
public class Compra {
	
    private int codCompra;
    private String formaPagamento;
    private double valor;
    private String dataCompra;
    private Clientes cliente;
    private Pacote pacote;

    public Compra() {
    }

    public Compra(int codCompra, String formaPagamento, double valor, String dataCompra, Clientes cliente, Pacote pacote) {
        this.codCompra = codCompra;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.pacote = pacote;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Clientes getCodCliente() {
        return cliente;
    }

    public void setCodCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Pacote getCodPacote() {
        return pacote;
    }

    public void setCodPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    @Override
    public String toString() {
        return "Compra{" + "codCompra=" + codCompra + ", formaPagamento=" + formaPagamento + ", valor=" + valor + ", dataCompra=" + dataCompra + ", codCliente=" + cliente + ", codPacote=" + pacote + '}';
    }

}
