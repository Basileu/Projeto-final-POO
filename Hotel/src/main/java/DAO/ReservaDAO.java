/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Quartos;
import classes.Reservas;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import tela.Reserva;

/**
 *
 * @author kamil
 */
//CRUD da tabela reserva
public class ReservaDAO {

    public ArrayList<Reservas> lerBanco() throws SQLException {
        System.out.println("teste1");
        Connection con = Conexao.getConnection();
        System.out.println("teste2");
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão.");
            return new ArrayList<>();
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Reservas> reservas = new ArrayList<>();

        try {
            System.out.println("teste3");
            stmt = con.prepareStatement("SELECT * FROM tb_reservas");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Reservas reserva = new Reservas();
                System.out.println("teste5");
                reserva.setReservaID(rs.getInt("reservas_id"));
                reserva.setNome(rs.getString("nome"));
                reserva.setNumQuarto(rs.getString("numero_quartos"));
                reserva.setFormaPagamento(rs.getString("forma_pagamento"));
                reserva.setNumeroCartao(rs.getString("numero_cartao"));
                reserva.setCvv(rs.getString("cvv"));
                System.out.println(reserva.toString());
                reservas.add(reserva);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível ler a tabela Reserva: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return reservas;
    }

//    public static void main(String[] args) throws SQLException{
//            //public Reservas(int reservaID, String numQuarto, String formaPagamento, String numeroCartao, String cvv, int cliente_id) {
//        int reservaID = 3;
//        String nome = "Jailton";
//        String numQuarto = "101";
//        String formaPagamento = "Cartão de Crédito";
//        String numeroCartao = "1234567890123456";
//        String cvv = "123";
//
//
//        // Inicializando o objeto
//        Reservas r = new Reservas(reservaID, nome, numQuarto, formaPagamento, numeroCartao, cvv);
//        System.out.println(r.toString());
//        ReservaDAO reservaDAO = new ReservaDAO();
//        reservaDAO.inserirBanco(r);
//    }

 public void inserirBanco(Reservas r) throws SQLException {
    Connection con = Conexao.getConnection();
    PreparedStatement stmt = null;
    try {
        stmt = con.prepareStatement("INSERT INTO tb_reservas (nome, numero_quartos, forma_pagamento, numero_cartao, cvv) VALUES (?, ?, ?, ?, ?)");
        
        stmt.setString(1, r.getNome());
        stmt.setString(2, r.getNumQuarto());
        stmt.setString(3, r.getFormaPagamento());
        stmt.setString(4, r.getNumeroCartao());
        stmt.setString(5, r.getCvv());
        
        stmt.executeUpdate();
        System.out.println("Reserva inserida com sucesso!");
    } catch (SQLException ex) {
        System.out.println("Erro ao inserir na tabela tb_reservas: " + ex.getMessage()); // Adiciona mais informações sobre o erro
    } finally {
        // Certifique-se de fechar a conexão e o PreparedStatement
        Conexao.closeConnection(con, stmt);
    }
}

    public void atualizarReserva(Reservas r) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tb_reservas SET quarto_id = ?, forma_pagamento = ?, numero_cartao = ?, cvv = ?, status_confirmacao = ? WHERE reservas_id = ?");

            stmt.setString(1, r.getNumQuarto());
            stmt.setString(2, r.getFormaPagamento());
            stmt.setString(3, r.getNumeroCartao());
            stmt.setString(4, r.getCvv());
            stmt.setInt(6, r.getReservaID());

            stmt.executeUpdate();

            System.out.println("Reserva atualizada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar na tabela tb_reservas: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void deletarReserva(Reservas r) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tb_reservas WHERE reservas_id = ?");
            stmt.setInt(1, r.getReservaID());

            stmt.executeUpdate();

            System.out.println("Reserva deletada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar na tabela tb_reservas: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

}
