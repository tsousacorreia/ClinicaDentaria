/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tsous
 */
public class TesteConexao_DAO {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection_DAO.getConnection();
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}
