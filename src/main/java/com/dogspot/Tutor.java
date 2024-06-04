package com.dogspot;

import java.util.ArrayList;

public class Tutor {
    private int idTutor;
    private String nome;
    private String contato;
    private String endereco;
    private ArrayList<Historico> historicoConsultasTratamentos;

    public Tutor(int idTutor, String nome, String contato, String endereco) {
        this.idTutor = idTutor;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
        this.historicoConsultasTratamentos = new ArrayList<>();
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
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
}
