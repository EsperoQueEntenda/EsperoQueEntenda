package com.dogspot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeterinarioDAO {
    public void inserirVeterinario(Veterinario veterinario) {
        String sql = "INSERT INTO veterinarios (nome, numero_registro, especialidade) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getNumeroRegistro());
            stmt.setString(3, veterinario.getEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir veterinário", e);
        }
    }

    public void atualizarVeterinario(Veterinario veterinario) {
        String sql = "UPDATE veterinarios SET nome = ?, numero_registro = ?, especialidade = ? WHERE id_veterinaria = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getNumeroRegistro());
            stmt.setString(3, veterinario.getEspecialidade());
            stmt.setInt(4, veterinario.getIdVeterinaria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar veterinário", e);
        }
    }

    public void excluirVeterinario(int idVeterinaria) {
        String sql = "DELETE FROM veterinarios WHERE id_veterinaria = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVeterinaria);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir veterinário", e);
        }
    }

    public Veterinario buscarVeterinarioPorId(int idVeterinaria) {
        String sql = "SELECT * FROM veterinarios WHERE id_veterinaria = ?";
        Veterinario veterinario = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVeterinaria);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                veterinario = new Veterinario(
                        rs.getInt("id_veterinaria"),
                        rs.getString("nome"),
                        rs.getString("numero_registro"),
                        rs.getString("especialidade")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veterinário", e);
        }
        return veterinario;
    }
}

