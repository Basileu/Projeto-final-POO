/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Cancelar;
import classes.cancelamento;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author kamil
 */
public class CancelarDAO implements cancelamento{

   @Override
    public void cancelarReserva(Cancelar cancelar) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tb_reservas WHERE numero_quartos = ? AND nome = ?");
            stmt.setString(1, cancelar.getNumQuarto());
            stmt.setString(2, cancelar.getNome());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reserva cancelada com sucesso!");
            } else {
                System.out.println("Nenhuma reserva encontrada com os dados fornecidos.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cancelar reserva: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

}
    


