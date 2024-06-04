package com.dogspot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, contato, endereco) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getContato());
            stmt.setString(3, usuario.getEndereco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir usuário", e);
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, contato = ?, endereco = ? WHERE id_tutor = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getContato());
            stmt.setString(3, usuario.getEndereco());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário", e);
        }
    }

    public void excluirUsuario(int idTutor) {
        String sql = "DELETE FROM usuarios WHERE id_tutor = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTutor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário", e);
        }
    }

    public Usuario buscarUsuarioPorId(int idTutor) {
        String sql = "SELECT * FROM usuarios WHERE id_tutor = ?";
        Usuario usuario = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTutor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id_tutor"),
                        rs.getString("nome"),
                        rs.getString("contato"),
                        rs.getString("endereco")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário", e);
        }
        return usuario;
    }
}

