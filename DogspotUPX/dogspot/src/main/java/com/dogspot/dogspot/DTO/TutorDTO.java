package com.dogspot.dogspot.DTO;

import com.dogspot.dogspot.Entities.Tutor;

public record TutorDTO(

        Long id,
        String nome,
        String endereco,
        String contato,
        String animalAssociado,
        String nomeDoPet
) {
    public TutorDTO(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEndereco(), tutor.getContato(), tutor.getAnimalAssociado(), tutor.getNomeDoPet());
    }

}
