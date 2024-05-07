package com.dogspot.dogspot.DTO;

import com.dogspot.dogspot.Entities.Tutor;

public record TutorDTO(

       Long id,
       String nome,
       String endereco
) {
    public TutorDTO(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEndereco());
    }

}
