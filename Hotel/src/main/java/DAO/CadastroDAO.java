/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Cadastros;
import classes.Cadastros;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author kamil
 */
public class CadastroDAO {

public ArrayList<Cadastros> lerBanco() throws SQLException {
        Connection con = Conexao.getConnection();
        if (con == null) {
            System.out.println("Falha ao estabelecer conexão.");
            return new ArrayList<>();
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cadastros> cadastroList = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_cadastro");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cadastros cadastro = new Cadastros();
                cadastro.setClienteID(rs.getInt("cliente_id"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setEmail(rs.getString("email"));
                cadastro.setSenha(rs.getString("senha"));
                cadastro.setTelefone(rs.getString("telefone"));

                cadastroList.add(cadastro);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível ler a tabela tb_cadastro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return cadastroList;
    }
    
    public void inserirBanco(Cadastros c) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tb_cadastro (nome, email, senha, telefone) VALUES (?, ?, ?, ?)");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getTelefone());

            stmt.executeUpdate();

            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir na tabela tb_cadastro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
     public void atualizarCadastro(Cadastros c) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tb_cadastro SET nome = ?, email = ?, senha = ?, telefone = ? WHERE cliente_id = ?");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getTelefone());
            stmt.setInt(5, c.getClienteID());

            stmt.executeUpdate();

            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar na tabela tb_cadastro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
     public void deletarCadastro(Cadastros c) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tb_cadastro WHERE cliente_id = ?");
            stmt.setInt(1, c.getClienteID());

            stmt.executeUpdate();

            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar na tabela tb_cadastro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

}
