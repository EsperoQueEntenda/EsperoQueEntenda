package com.dogspot;

import java.util.ArrayList;

import java.util.List;

public class Historico {
    private int idHistorico;
    private List<String> doencas;
    private List<String> vacinas;
    private List<Double> pesos;
    private List<String> tratamentos;

    public Historico(int idHistorico) {
        this.idHistorico = idHistorico;
        this.doencas = new ArrayList<>();
        this.vacinas = new ArrayList<>();
        this.pesos = new ArrayList<>();
        this.tratamentos = new ArrayList<>();
    }

    public void adicionarDoenca(String doenca) {
        doencas.add(doenca);
    }

    public void adicionarVacina(String vacina) {
        vacinas.add(vacina);
    }

    public void adicionarPeso(double peso) {
        pesos.add(peso);
    }

    public void adicionarTratamento(String tratamento) {
        tratamentos.add(tratamento);
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public List<String> getDoencas() {
        return doencas;
    }

    public void setDoencas(List<String> doencas) {
        this.doencas = doencas;
    }

    public List<String> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<String> vacinas) {
        this.vacinas = vacinas;
    }

    public List<Double> getPesos() {
        return pesos;
    }

    public void setPesos(List<Double> pesos) {
        this.pesos = pesos;
    }

    public List<String> getTratamentos() {
        return tratamentos;
    }

    public void setTratamentos(List<String> tratamentos) {
        this.tratamentos = tratamentos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico Médico:\n");

        if (!doencas.isEmpty()) {
            sb.append("Doenças:\n");
            for (String doenca : doencas) {
                sb.append("- ").append(doenca).append("\n");
            }
        }

        if (!vacinas.isEmpty()) {
            sb.append("Vacinas:\n");
            for (String vacina : vacinas) {
                sb.append("- ").append(vacina).append("\n");
            }
        }

        if (!pesos.isEmpty()) {
            sb.append("Pesos:\n");
            for (double peso : pesos) {
                sb.append("- ").append(peso).append(" kg\n");
            }
        }

        if (!tratamentos.isEmpty()) {
            sb.append("Tratamentos:\n");
            for (String tratamento : tratamentos) {
                sb.append("- ").append(tratamento).append("\n");
            }
        }

        return sb.toString();
    }
}
