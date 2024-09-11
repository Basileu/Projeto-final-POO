/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Reserva;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import classes.Quartos;

/**
 *
 * @author kamila
 */
public class QuartosDAO {

    public ArrayList<Quartos> lerBanco() throws SQLException {

        
        Connection con = Conexao.getConnection();
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão.");
            return new ArrayList<>();
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Quartos> quartos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_quartos");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Quartos quarto = new Quartos();
                quarto.setQuartosID(rs.getInt("quartos_id"));
                quarto.setNumQuartos(rs.getInt("numero_quarto"));
                quarto.setDescricao(rs.getString("descricao"));
                quarto.setStatus(rs.getString("status"));
                quarto.setPreco(rs.getDouble("valor_por_dia"));
                quarto.setData(rs.getString("data_disponibilidade"));
                
                quartos.add(quarto);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível ler a tabela tb_quartos: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return quartos;
    }

    public void inserirBanco(Quartos q) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tb_quartos (numero_quarto, descricao, status, valor_por_dia, data_disponibilidade, cliente_id) VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, q.getNumQuartos());
            stmt.setString(2, q.getDescricao());
            stmt.setString(3, q.getStatus());
            stmt.setDouble(4, q.getPreco());
            stmt.setString(5, q.getData());
            stmt.setInt(6, q.getQuartosID());

            stmt.executeUpdate();

            System.out.println("Quarto inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir na tabela tb_quartos: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void atualizarQuarto(Quartos q) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tb_quartos SET numero_quarto = ?, descricao = ?, status = ?, valor_por_dia = ?, data_disponibilidade = ? WHERE quartos_id = ?");

            stmt.setInt(1, q.getNumQuartos());
            stmt.setString(2, q.getDescricao());
            stmt.setString(3, q.getStatus());
            stmt.setDouble(4, q.getPreco());
            stmt.setString(5, q.getData());
            stmt.setInt(6, q.getQuartosID());

            stmt.executeUpdate();

            System.out.println("Quarto atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar na tabela tb_quartos: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
        public void deletarQuarto(Quartos q) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tb_quartos WHERE quartos_id = ?");
            stmt.setInt(1, q.getQuartosID());

            stmt.executeUpdate();

            System.out.println("Quarto deletado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar na tabela tb_quartos: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
//    public static void main(String[] args) throws SQLException {
//        ReservaDAO reservaDAO = new ReservaDAO();
//        reservaDAO.lerBanco();
//    }

    
}
