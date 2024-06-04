package com.dogspot;

public class Ong {
    private int idOng;
    private String nome;
    private int quantidadeFuncionarios;
    private String parcerias;
    private String contato;
    private String endereco;

    public Ong(int idOng, String nome, int quantidadeFuncionarios, String parcerias, String contato, String endereco) {
        this.idOng = idOng;
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.parcerias = parcerias;
        this.contato = contato;
        this.endereco = endereco;
    }

    public int getIdOng() {
        return idOng;
    }

    public void setIdOng(int idOng) {
        this.idOng = idOng;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public String getParcerias() {
        return parcerias;
    }

    public void setParcerias(String parcerias) {
        this.parcerias = parcerias;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

