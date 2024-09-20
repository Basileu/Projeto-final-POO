/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import DAO.CadastroDAO;
import DAO.CancelarDAO;
import DAO.QuartosDAO;
import DAO.ReservaDAO;
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
//        ReservaDAO reservaDAO = new ReservaDAO();
//        try {
//            // Recuperar todos os quartos do banco
//            ArrayList<Reservas> listaReservas = reservaDAO.lerBanco();
//            
//            // Verificar se a lista não está vazia
//            if (listaReservas.isEmpty()) {
//                System.out.println("Nenhuma reserva encontrada.");
//            } else {
//                // Exibir as informações no console
//                for (Reservas reservas : listaReservas) {
//                    System.out.println("ID: " + reservas.getReservaID());
//                    System.out.println("Nome: " + reservas.getNome()); 
//                    System.out.println("Número do quarto: " + reservas.getNumQuarto());
//                    System.out.println("Forma de pagamento: " + reservas.getFormaPagamento());
//                    System.out.println("Número do cartão: " + reservas.getNumeroCartao());
//                    System.out.println("CVV: " + reservas.getCvv());
//                    System.out.println("--------------");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Erro ao ler reservas: " + e.getMessage());
//        }
//    }

        QuartosDAO quartosDAO = new QuartosDAO();
// Atualização de 5 quartos com novas datas de disponibilidade e outros dados
//        try {
//            // Atualizando o quarto com ID 1
//            Quartos quarto1 = new Quartos(1, 100, "Quarto solteiro", "disponível", 89.99, "13-10-2024 a 16-10-2024");
//            quartosDAO.atualizarQuarto(quarto1);
//
//            // Atualizando o quarto com ID 2
//            Quartos quarto2 = new Quartos(2, 101, "Quarto casal", "disponível", 139.99, "12-10-2024 a 15-10-2024");
//            quartosDAO.atualizarQuarto(quarto2);
//
//            // Atualizando o quarto com ID 3
//            Quartos quarto3 = new Quartos(3, 200, "Quarto vip solteiro", "disponível", 109.99, "11-10-2024 a 14-10-2024");
//            quartosDAO.atualizarQuarto(quarto3);
//
//            // Atualizando o quarto com ID 4
//            Quartos quarto4 = new Quartos(4, 201, "Quarto vip casal", "disponível", 209.99, "10-10-2024 a 13-10-2024");
//            quartosDAO.atualizarQuarto(quarto4);
//
//            // Atualizando o quarto com ID 5
//            Quartos quarto5 = new Quartos(5, 300, "Cobertura vip", "disponível", 900.00, "09-10-2024 a 12-10-2024");
//            quartosDAO.atualizarQuarto(quarto5);
//
//        } catch (SQLException e) {
//            System.out.println("Erro ao atualizar quartos: " + e.getMessage());
//        }
        try {
//             Recuperar todos os quartos do banco
            ArrayList<Quartos> listaQuartos = quartosDAO.lerBanco();

//             Exibir as informações no console
            for (Quartos quarto : listaQuartos) {
                System.out.println("ID: " + quarto.getQuartosID());
                System.out.println("Número do Quarto: " + quarto.getNumQuartos());
                System.out.println("Descrição: " + quarto.getDescricao());
                System.out.println("Status: " + quarto.getStatus());
                System.out.println("Preço: " + quarto.getPreco());
                System.out.println("Data de Disponibilidade: " + quarto.getData());
                System.out.println("--------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler quartos: " + e.getMessage());
        }

           try {
//             Recuperar todos os quartos do banco
            ArrayList<Quartos> listaQuartos = quartosDAO.lerBanco();

//             Exibir as informações no console
            for (Quartos quarto : listaQuartos) {
                System.out.println("ID: " + quarto.getQuartosID());
                System.out.println("Número do Quarto: " + quarto.getNumQuartos());
                System.out.println("Descrição: " + quarto.getDescricao());
                System.out.println("Status: " + quarto.getStatus());
                System.out.println("Preço: " + quarto.getPreco());
                System.out.println("Data de Disponibilidade: " + quarto.getData());
                System.out.println("--------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler quartos: " + e.getMessage());
        }
    }
}


        
//    CadastroDAO cadastroDAO = new CadastroDAO();
       
//        try{
//             //Recuperar todos os quartos do banco
//            ArrayList<Cadastros> listaCadastro = cadastroDAO.lerBanco();
//            
//             //Exibir as informações no console
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
