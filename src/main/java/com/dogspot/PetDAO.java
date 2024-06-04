package com.dogspot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    public void inserirPet(Pet pet) {
        String sql = "INSERT INTO pets (nome, idade, raca, origem, peso) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pet.getNome());
            stmt.setInt(2, pet.getIdade());
            stmt.setString(3, pet.getRaca());
            stmt.setString(4, pet.getOrigem());
            stmt.setDouble(5, pet.getPeso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pet", e);
        }
    }

    public void atualizarPet(Pet pet) {
        String sql = "UPDATE pets SET nome = ?, idade = ?, raca = ?, origem = ?, peso = ? WHERE id_cachorro = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pet.getNome());
            stmt.setInt(2, pet.getIdade());
            stmt.setString(3, pet.getRaca());
            stmt.setString(4, pet.getOrigem());
            stmt.setDouble(5, pet.getPeso());
            stmt.setInt(6, pet.getIdCachorro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar pet", e);
        }
    }

    public void excluirPet(int idCachorro) {
        String sql = "DELETE FROM pets WHERE id_cachorro = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCachorro);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir pet", e);
        }
    }

    public Pet buscarPetPorId(int idCachorro) {
        String sql = "SELECT * FROM pets WHERE id_cachorro = ?";
        Pet pet = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCachorro);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pet = new Pet(
                        rs.getInt("id_cachorro"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("raca"),
                        rs.getString("origem"),
                        rs.getDouble("peso"),
                        new Historico(rs.getInt("id_cachorro"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pet", e);
        }
        return pet;
    }

    public List<Pet> listarPets() {
        String sql = "SELECT * FROM pets";
        List<Pet> pets = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getInt("id_cachorro"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("raca"),
                        rs.getString("origem"),
                        rs.getDouble("peso"),
                        new Historico(rs.getInt("id_cachorro"))
                );
                pets.add(pet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pets", e);
        }
        return pets;
    }
}

