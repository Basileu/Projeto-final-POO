/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import DAO.CadastroDAO;
import DAO.CancelarDAO;
import DAO.QuartosDAO;
import classes.Cadastros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kamil
 */
public class Principal {
    
    public static void main(String[] args) {
        
    }
}
//        
        
        
//    CadastroDAO cadastroDAO = new CadastroDAO();
//       
//        try{
//             Recuperar todos os quartos do banco
//            ArrayList<Cadastros> listaCadastro = cadastroDAO.lerBanco();
//            
//             Exibir as informações no console
//            for (Cadastros cadastro : listaCadastro) {
//                System.out.println("ID do Cliente: " + cadastro.getClienteID());
//                System.out.println("Nome: " + cadastro.getNome());
//                System.out.println("Email: " + cadastro.getEmail());
//                System.out.println("Senha: " + cadastro.getSenha());
//                System.out.println("Telefone: " + cadastro.getTelefone());
//                System.out.println("--------------");
//                
//            }
//        } catch (SQLException ex) {
//            System.out.println("Erro ao ler cadastro: " + ex.getMessage());
//        }
//    }
//} 


//    public static void main(String[] args) {
//        QuartosDAO quartosDAO = new QuartosDAO();
//
//        try {
//             Recuperar todos os quartos do banco
//            ArrayList<Quartos> listaQuartos = quartosDAO.lerBanco();
//
//             Exibir as informações no console
//            for (Quartos quarto : listaQuartos) {
//                System.out.println("ID: " + quarto.getQuartosID());
//                System.out.println("Número do Quarto: " + quarto.getNumQuartos());
//                System.out.println("Descrição: " + quarto.getDescricao());
//                System.out.println("Status: " + quarto.getStatus());
//                System.out.println("Preço: " + quarto.getPreco());
//                System.out.println("Data de Disponibilidade: " + quarto.getData());
//                System.out.println("--------------");
//            }
//        } catch (SQLException e) {
//            System.out.println("Erro ao ler quartos: " + e.getMessage());
//        }
//    }
//}
