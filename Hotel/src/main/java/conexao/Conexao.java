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

    private static final String DATAPAH = "jdbc:sqlite:hotel.db";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(DATAPAH);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conexao = getConnection();
        if (conexao != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            closeConnection(conexao);
        } else {
            System.out.println("Falha ao estabelecer conexão.");
        }

    }
//
//    public static Connection getConnection() throws SQLException {
//        
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hotel", "root", "@Kamila19");
////            ResultSet quarto = conexao.createStatement().executeQuery("SELECT * FROM tb_quartos");
////            while (quarto.next()) {
////                System.out.println(quarto.getString("numero_quarto"));
////
////            }
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Driver do banco não localizado");
//        } catch (SQLException ex) {
//            System.out.println("Occoreu um erro ao acessar ao banco: " + ex.getMessage());
//        } 
//        
//        return null;
//    }
//
//    public static void closeConnection(Connection con) {
//        try {
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void closeConnection(Connection con, PreparedStatement stmt) {
//        closeConnection(con);
//        try {
//            stmt.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
//        closeConnection(con, stmt);
//        try {
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    
//    public static void main(String[] args) throws SQLException {
//           Conexao conexo = new Conexao();
//           conexo.getConnection();
//    }
}
