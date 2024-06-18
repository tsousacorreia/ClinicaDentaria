/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DatabaseConnection_DAO;
import Model.Paciente_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paciente {

    private static final Logger logger = Logger.getLogger(Paciente.class.getName());

    public void adicionarPaciente(Paciente_DAO paciente) {
        String sql = "INSERT INTO pacientes (nome, cpf, data_nascimento, sexo, endereco_rua, endereco_numero, " +
                     "endereco_bairro, endereco_cidade, endereco_estado, contato_email, contato_telefone, " +
                     "contato_celular, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection_DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setDate(3, new java.sql.Date(paciente.getDataNascimento().getTime()));
            stmt.setString(4, paciente.getSexo());
            stmt.setString(5, paciente.getEnderecoRua());
            stmt.setString(6, paciente.getEnderecoNumero());
            stmt.setString(7, paciente.getEnderecoBairro());
            stmt.setString(8, paciente.getEnderecoCidade());
            stmt.setString(9, paciente.getEnderecoEstado());
            stmt.setString(10, paciente.getContatoEmail());
            stmt.setString(11, paciente.getContatoTelefone());
            stmt.setString(12, paciente.getContatoCelular());
            stmt.setString(13, paciente.getObservacoes());

            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar paciente", e);
        }
    }

    public List<Paciente_DAO> listarPacientes() {
        List<Paciente_DAO> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Connection conn = DatabaseConnection_DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paciente_DAO paciente = new Paciente_DAO();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setDataNascimento(rs.getDate("data_nascimento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setEnderecoRua(rs.getString("endereco_rua"));
                paciente.setEnderecoNumero(rs.getString("endereco_numero"));
                paciente.setEnderecoBairro(rs.getString("endereco_bairro"));
                paciente.setEnderecoCidade(rs.getString("endereco_cidade"));
                paciente.setEnderecoEstado(rs.getString("endereco_estado"));
                paciente.setContatoEmail(rs.getString("contato_email"));
                paciente.setContatoTelefone(rs.getString("contato_telefone"));
                paciente.setContatoCelular(rs.getString("contato_celular"));
                paciente.setObservacoes(rs.getString("observacoes"));

                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar pacientes", e);
        }
        return pacientes;
    }

    public Paciente_DAO obterPaciente(int id) {
        String sql = "SELECT * FROM pacientes WHERE id = ?";
        try (Connection conn = DatabaseConnection_DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Paciente_DAO paciente = new Paciente_DAO();
                    paciente.setId(rs.getInt("id"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setDataNascimento(rs.getDate("data_nascimento"));
                    paciente.setSexo(rs.getString("sexo"));
                    paciente.setEnderecoRua(rs.getString("endereco_rua"));
                    paciente.setEnderecoNumero(rs.getString("endereco_numero"));
                    paciente.setEnderecoBairro(rs.getString("endereco_bairro"));
                    paciente.setEnderecoCidade(rs.getString("endereco_cidade"));
                    paciente.setEnderecoEstado(rs.getString("endereco_estado"));
                    paciente.setContatoEmail(rs.getString("contato_email"));
                    paciente.setContatoTelefone(rs.getString("contato_telefone"));
                    paciente.setContatoCelular(rs.getString("contato_celular"));
                    paciente.setObservacoes(rs.getString("observacoes"));

                    return paciente;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao obter paciente", e);
        }
        return null;
    }

    public void atualizarPaciente(Paciente_DAO paciente) {
        String sql = "UPDATE pacientes SET nome = ?, cpf = ?, data_nascimento = ?, sexo = ?, endereco_rua = ?, " +
                     "endereco_numero = ?, endereco_bairro = ?, endereco_cidade = ?, endereco_estado = ?, " +
                     "contato_email = ?, contato_telefone = ?, contato_celular = ?, observacoes = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection_DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setDate(3, new java.sql.Date(paciente.getDataNascimento().getTime()));
            stmt.setString(4, paciente.getSexo());
            stmt.setString(5, paciente.getEnderecoRua());
            stmt.setString(6, paciente.getEnderecoNumero());
            stmt.setString(7, paciente.getEnderecoBairro());
            stmt.setString(8, paciente.getEnderecoCidade());
            stmt.setString(9, paciente.getEnderecoEstado());
            stmt.setString(10, paciente.getContatoEmail());
            stmt.setString(11, paciente.getContatoTelefone());
            stmt.setString(12, paciente.getContatoCelular());
            stmt.setString(13, paciente.getObservacoes());
            stmt.setInt(14, paciente.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar paciente", e);
        }
    }

    public void deletarPaciente(int id) {
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try (Connection conn = DatabaseConnection_DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar paciente", e);
        }
    }
}
