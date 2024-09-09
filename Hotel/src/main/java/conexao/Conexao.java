/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kamil
 */
public class Conexao {

    private static final String URL = "jdbc:sqlite:hotel.db";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//  codigo para verificar se esta conectando com o banco 
public static void main(String[] args) {
       Connection conn = null;
       try {
           // URL de conexão para o banco de dados SQLite
           String url = "jdbc:sqlite:hotel.db";
           // Cria a conexão com o banco de dados
           conn = DriverManager.getConnection(url);
           System.out.println("Conexão com SQLite estabelecida.");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }
    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
