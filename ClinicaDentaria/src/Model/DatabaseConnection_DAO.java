/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tsous
 */
public class DatabaseConnection_DAO {
    private static final String URL = "jdbc:mysql://localhost/clinica";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    static {
        carregaDriver();
    }

    public static void carregaDriver(){
       try { // Conectando o driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver carregado com sucesso!");
       } catch (Exception ex) { // Erro driver não encontrado
            System.out.println("Driver não pode ser carregado!");
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }    
}
