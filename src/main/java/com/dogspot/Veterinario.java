package com.dogspot;

public class Veterinario {
    private int idVeterinaria;
    private String nome;
    private String numeroRegistro;
    private String especialidade;

    public Veterinario(int idVeterinaria, String nome, String numeroRegistro, String especialidade) {
        this.idVeterinaria = idVeterinaria;
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
        this.especialidade = especialidade;
    }

    public int getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(int idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}

