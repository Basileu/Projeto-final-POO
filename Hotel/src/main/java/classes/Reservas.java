/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author kamil
 */
public class Reservas {
    private int reservaID;
    private String nome;
    private String numQuarto;
    private String formaPagamento;
    private String numeroCartao;
    private String cvv;

    public Reservas(int reservaID, String nome, String numQuarto, String formaPagamento, String numeroCartao, String cvv) {
        this.reservaID = reservaID;
        this.nome = nome;
        this.numQuarto = numQuarto;
        this.formaPagamento = formaPagamento;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
    }

    
    public Reservas() {
        
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

    public String getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(String numQuarto) {
        this.numQuarto = numQuarto;
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
        return "Reservas{" + "reservaID=" + reservaID + ", nome=" + nome + ", numQuarto=" + numQuarto + ", formaPagamento=" + formaPagamento + ", numeroCartao=" + numeroCartao + ", cvv=" + cvv + '}';
    }

 
}