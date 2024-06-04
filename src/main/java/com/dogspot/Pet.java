package com.dogspot;

import java.util.ArrayList;

public class Pet {
    private int idCachorro;
    private String nome;
    private int idade;
    private String raca;
    private String origem;
    private double peso;
    private Historico historico;
    private ArrayList<Vacina> vacinas;

    public Pet(int idCachorro, String nome, int idade, String raca, String origem, double peso, Historico historico) {
        this.idCachorro = idCachorro;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.origem = origem;
        this.peso = peso;
        this.historico = historico;
        this.vacinas = new ArrayList<>();
    }

    public int getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(int idCachorro) {
        this.idCachorro = idCachorro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public ArrayList<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(ArrayList<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "idCachorro=" + idCachorro +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", raca='" + raca + '\'' +
                ", origem='" + origem + '\'' +
                ", peso=" + peso +
                ", historico=" + historico +
                '}';
    }
}

