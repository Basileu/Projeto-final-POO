/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author kamil
 */
public class Reserva {
    private int reservaID;
    private int numQuarto;
    private String nome;
    private String dataEntrada ;
    private String dataSaida ;
    private String formaPagamento;
    private String numeroCartao;
    private String cvv;
    private boolean statusConfirmacao;

    public Reserva(String nome, int reservaID, int numQuarto, String dataEntrada, String dataSaida, String formaPagamento, String numeroCartao, String cvv) {
        this.nome = nome;
        this.reservaID = reservaID;
        this.numQuarto = numQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.formaPagamento = formaPagamento;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
    }

    public Reserva() {
        
    }

    public boolean isStatusConfirmacao() {
        return statusConfirmacao;
    }

    public void setStatusConfirmacao(boolean statusConfirmacao) {
        this.statusConfirmacao = statusConfirmacao;
    }

    
    public int getReservaID() {
        return reservaID;
    }

    public void setReservaID(int reservaID) {
        this.reservaID = reservaID;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }   

    @Override
    public String toString() {
        return "Reserva{" + "reservaID=" + reservaID + ", nQuarto=" + numQuarto + ", nome=" + nome + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", formaPagamento=" + formaPagamento + ", numeroCartao=" + numeroCartao + ", cvv=" + cvv + ", statusConfirmacao=" + statusConfirmacao + '}';
    }

    
}
