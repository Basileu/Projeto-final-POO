/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author kamil
 */
public class Quartos {

    private int quartosID;
    private int numQuartos;
    private String descricao;
    private String status;
    private double preco;
    private String data;

    public Quartos(int quartosID, int numQuartos, String descricao, String status, double preco, String data) {
        this.quartosID = quartosID;
        this.numQuartos = numQuartos;
        this.descricao = descricao;
        this.status = status;
        this.preco = preco;
        this.data = data;
    }

    public Quartos() {
    }

    public Quartos(int numero, boolean disponivel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getQuartosID() {
        return quartosID;
    }

    public void setQuartosID(int quartosID) {
        this.quartosID = quartosID;
    }

    public int getNumQuartos() {
        return numQuartos;
    }

    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Quartos{" + "quartosID=" + quartosID + ", numQuartos=" + numQuartos + ", descricao=" + descricao + ", status=" + status + ", preco=" + preco + ", data=" + data + '}';
    }
    
    
}
