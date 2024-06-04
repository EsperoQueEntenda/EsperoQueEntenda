package com.dogspot;

import java.util.ArrayList;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String contato;
    private String endereco;
    private ArrayList<Historico> historicoConsultasTratamentos;

    public Usuario(int idUsuario, String nome, String contato, String endereco) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
        this.historicoConsultasTratamentos = new ArrayList<>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public ArrayList<Historico> getHistoricoConsultasTratamentos() {
        return historicoConsultasTratamentos;
    }

    public void setHistoricoConsultasTratamentos(ArrayList<Historico> historicoConsultasTratamentos) {
        this.historicoConsultasTratamentos = historicoConsultasTratamentos;
    }

    // Método para adicionar um histórico
    public void adicionarHistorico(Historico historico) {
        this.historicoConsultasTratamentos.add(historico);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", endereco='" + endereco + '\'' +
                ", historicoConsultasTratamentos=" + historicoConsultasTratamentos +
                '}';
    }
}
