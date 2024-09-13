/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author 13493382650
 */
public abstract class Cliente {
    
    private int clienteID;
    private String nome;
    private String email;   
    private String telefone;

    public Cliente(int clienteID, String nome, String email, String telefone) {
        this.clienteID = clienteID;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente() {
    }
    
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "telefone=" + telefone + ", clienteID=" + clienteID + ", nome=" + nome + ", email=" + email + '}';
    }
    
    
}
