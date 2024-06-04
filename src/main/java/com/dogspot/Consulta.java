package com.dogspot;

public class Consulta {
    private String dataConsulta;
    private String descricao;
    private Veterinario veterinario;

    public Consulta(String dataConsulta, String descricao, Veterinario veterinario) {
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
        this.veterinario = veterinario;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}

