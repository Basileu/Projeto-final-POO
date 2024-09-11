/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Quartos;
import classes.Reserva;
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

/**
 *
 * @author kamil
 */
//CRUD da tabela reserva
public class ReservaDAO {

    public ArrayList<Reserva> lerBanco() throws SQLException {
        System.out.println("teste1");
        Connection con = Conexao.getConnection();
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão.");
            return new ArrayList<>();
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_reservas");
            rs = stmt.executeQuery();
            System.out.println("teste2");
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setReservaID(rs.getInt("reservas_id"));
                reserva.setNumQuarto(rs.getInt("quarto_id"));
                reserva.setDataEntrada(rs.getString("data_entrada"));
                reserva.setDataSaida(rs.getString("data_saida"));
                reserva.setFormaPagamento(rs.getString("forma_pagamento"));
                reserva.setNumeroCartao(rs.getString("numero_cartao"));
                reserva.setCvv(rs.getString("cvv"));
                reserva.setStatusConfirmacao(rs.getBoolean("status_confirmacao"));
                reservas.add(reserva);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível ler a tabela Reserva: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return reservas;
    }

//    public static void main(String[] args) throws SQLException {
//        ReservaDAO reservaDAO = new ReservaDAO();
//        reservaDAO.lerBanco();
//    }
    public void inserirBanco(Reserva r) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tb_reservas (quarto_id, data_entrada, data_saida, forma_pagamento, numero_cartao, cvv, status_confirmacao, cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, r.getNumQuarto());
            stmt.setString(2, r.getDataEntrada());
            stmt.setString(3, r.getDataSaida());
            stmt.setString(4, r.getFormaPagamento());
            stmt.setString(5, r.getNumeroCartao());
            stmt.setString(5, r.getCvv());
            stmt.setBoolean(7, r.isStatusConfirmacao());
            stmt.setInt(8, r.getReservaID());
            stmt.executeUpdate();

            System.out.println("Reserva inserida com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir na tabela tb_reservas");
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void atualizarReserva(Reserva r) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tb_reservas SET quarto_id = ?, data_entrada = ?, data_saida = ?, forma_pagamento = ?, numero_cartao = ?, cvv = ?, status_confirmacao = ? WHERE reservas_id = ?");

            stmt.setInt(1, r.getNumQuarto());
            stmt.setString(2, r.getDataEntrada());
            stmt.setString(3, r.getDataSaida());
            stmt.setString(4, r.getFormaPagamento());
            stmt.setString(5, r.getNumeroCartao());
            stmt.setString(6, r.getCvv());
            stmt.setBoolean(7, r.isStatusConfirmacao());
            stmt.setInt(8, r.getReservaID());

            stmt.executeUpdate();

            System.out.println("Reserva atualizada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar na tabela tb_reservas: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void deletarReserva(Reserva r) throws SQLException {
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
