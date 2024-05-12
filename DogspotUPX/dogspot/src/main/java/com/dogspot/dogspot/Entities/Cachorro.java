package com.dogspot.dogspot.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "cachorro")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Cachorro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "raca")
    private String raca;

    @Column(name = "genero")
    private String genero;

    @Column(name = "idade")
    private int idade;

    @Column(name = "vacinado")
    private boolean vacinado;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
}
