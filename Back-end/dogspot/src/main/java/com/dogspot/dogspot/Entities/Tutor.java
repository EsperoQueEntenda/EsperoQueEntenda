package com.dogspot.dogspot.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tutor")
public class Tutor {

    @Id
    Integer id;
    String nome;
    String endereco;

    @OneToMany(mappedBy = "tutor")
    List<Cachorro> cachorros = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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


    public void adicionarCachorro(Cachorro cachorro) {
        cachorros.add(cachorro);
        cachorro.setTutor(this);
    }

    public void removerCachorro(Cachorro cachorro) {
        cachorros.remove(cachorro);
        cachorro.setTutor(null);
    }
}
