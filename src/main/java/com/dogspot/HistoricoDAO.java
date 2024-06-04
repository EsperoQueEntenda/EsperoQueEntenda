package com.dogspot;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricoDAO {
    public void inserirHistorico(Historico historico) {
        String sql = "INSERT INTO historicos (id_pet) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, historico.getIdHistorico());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                historico.setIdHistorico(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Falha ao obter o ID do histórico.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir histórico", e);
        }
    }

    public void atualizarHistorico(Historico historico) {
        String sql = "UPDATE historicos SET id_pet = ? WHERE id_historico = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, historico.getIdHistorico());
            stmt.setInt(2, historico.getIdHistorico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar histórico", e);
        }
    }

    public Historico buscarHistoricoPorId(int idPet) {
        Historico historico = null;

        String sqlHistorico = "SELECT * FROM historicos WHERE id_pet = ?";
        String sqlDoencas = "SELECT doenca FROM doencas WHERE id_historico = ?";
        String sqlVacinas = "SELECT vacina FROM vacinas WHERE id_historico = ?";
        String sqlPesos = "SELECT peso FROM pesos WHERE id_historico = ?";
        String sqlTratamentos = "SELECT tratamento FROM tratamentos WHERE id_historico = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmtHistorico = conn.prepareStatement(sqlHistorico);
             PreparedStatement stmtDoencas = conn.prepareStatement(sqlDoencas);
             PreparedStatement stmtVacinas = conn.prepareStatement(sqlVacinas);
             PreparedStatement stmtPesos = conn.prepareStatement(sqlPesos);
             PreparedStatement stmtTratamentos = conn.prepareStatement(sqlTratamentos)) {

            // Buscar o histórico básico
            stmtHistorico.setInt(1, idPet);
            ResultSet rsHistorico = stmtHistorico.executeQuery();
            if (rsHistorico.next()) {
                int idHistorico = rsHistorico.getInt("id_historico");
                JOptionPane.showMessageDialog(null, "Histórico encontrado com id: " + idHistorico);
                historico = new Historico(idHistorico);

                // Buscar doenças
                stmtDoencas.setInt(1, idHistorico);
                ResultSet rsDoencas = stmtDoencas.executeQuery();
                boolean hasDoencas = false;
                while (rsDoencas.next()) {
                    String doenca = rsDoencas.getString("doenca");
                    historico.adicionarDoenca(doenca);
                    JOptionPane.showMessageDialog(null, "Doença encontrada: " + doenca);
                    hasDoencas = true;
                }
                if (!hasDoencas) {
                    JOptionPane.showMessageDialog(null, "Nenhuma doença encontrada para id_historico: " + idHistorico);
                }

                // Buscar vacinas
                stmtVacinas.setInt(1, idHistorico);
                ResultSet rsVacinas = stmtVacinas.executeQuery();
                boolean hasVacinas = false;
                while (rsVacinas.next()) {
                    String vacina = rsVacinas.getString("vacina");
                    historico.adicionarVacina(vacina);
                    JOptionPane.showMessageDialog(null, "Vacina encontrada: " + vacina);
                    hasVacinas = true;
                }
                if (!hasVacinas) {
                    JOptionPane.showMessageDialog(null, "Nenhuma vacina encontrada para id_historico: " + idHistorico);
                }

                // Buscar pesos
                stmtPesos.setInt(1, idHistorico);
                ResultSet rsPesos = stmtPesos.executeQuery();
                boolean hasPesos = false;
                while (rsPesos.next()) {
                    double peso = rsPesos.getDouble("peso");
                    historico.adicionarPeso(peso);
                    JOptionPane.showMessageDialog(null, "Peso encontrado: " + peso);
                    hasPesos = true;
                }
                if (!hasPesos) {
                    JOptionPane.showMessageDialog(null, "Nenhum peso encontrado para id_historico: " + idHistorico);
                }

                // Buscar tratamentos
                stmtTratamentos.setInt(1, idHistorico);
                ResultSet rsTratamentos = stmtTratamentos.executeQuery();
                boolean hasTratamentos = false;
                while (rsTratamentos.next()) {
                    String tratamento = rsTratamentos.getString("tratamento");
                    historico.adicionarTratamento(tratamento);
                    JOptionPane.showMessageDialog(null, "Tratamento encontrado: " + tratamento);
                    hasTratamentos = true;
                }
                if (!hasTratamentos) {
                    JOptionPane.showMessageDialog(null, "Nenhum tratamento encontrado para id_historico: " + idHistorico);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum histórico encontrado para o id_pet: " + idPet);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar histórico: " + e.getMessage());
        }

        return historico;
    }
}

