package com.dogspot;

public class Vacina {
    private String nome;
    private String dataAplicacao;

    public Vacina(String nome, String dataAplicacao) {
        this.nome = nome;
        this.dataAplicacao = dataAplicacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}

