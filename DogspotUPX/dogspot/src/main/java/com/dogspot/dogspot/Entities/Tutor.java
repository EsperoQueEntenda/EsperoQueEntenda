package com.dogspot.dogspot.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tutor")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "tutor")
    private List<Cachorro> cachorros = new ArrayList<>();
    public void adicionarCachorro(Cachorro cachorro) {
        cachorros.add(cachorro);
        cachorro.setTutor(this);
    }

    public void removerCachorro(Cachorro cachorro) {
        cachorros.remove(cachorro);
        cachorro.setTutor(null);
    }
}
