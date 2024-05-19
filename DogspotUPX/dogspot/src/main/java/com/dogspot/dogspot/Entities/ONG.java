package com.dogspot.dogspot.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ong")
public class ONG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade_funcionarios")
    private int quantidadeFuncionarios;

    @Column(name = "parcerias")
    private String parcerias;

    @Column(name = "contato")
    private String contato;

    @Column(name = "registro_adocao_resgate")
    private String registroAdocaoResgate;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL)
    private List<Cachorro> cachorros = new ArrayList<>();

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRegistroAdocaoResgate() {
        return registroAdocaoResgate;
    }

    public void setRegistroAdocaoResgate(String registroAdocaoResgate) {
        this.registroAdocaoResgate = registroAdocaoResgate;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Cachorro> getCachorros() {
        return cachorros;
    }

    public void setCachorros(List<Cachorro> cachorros) {
        this.cachorros = cachorros;
    }
}
