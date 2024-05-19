package com.dogspot.dogspot.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agendamentos")
    private String agendamentos;

    @Column(name = "numero_crmv")
    private String numeroCRMV;

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Cachorro> cachorros = new ArrayList<>();

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(String agendamentos) {
        this.agendamentos = agendamentos;
    }

    public String getNumeroCRMV() {
        return numeroCRMV;
    }

    public void setNumeroCRMV(String numeroCRMV) {
        this.numeroCRMV = numeroCRMV;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cachorro> getCachorros() {
        return cachorros;
    }

    public void setCachorros(List<Cachorro> cachorros) {
        this.cachorros = cachorros;
    }
}
