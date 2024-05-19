package com.dogspot.dogspot.DTO;

import com.dogspot.dogspot.Entities.Cachorro;

public record CachorroDTO(
        String nome,
        String raca,
        String genero,
        int idade,
        boolean vacinado,
        String origem,
        String historico
) {
    public CachorroDTO(Cachorro cachorro) {
        this(cachorro.getNome(), cachorro.getRaca(), cachorro.getGenero(), cachorro.getIdade(), cachorro.isVacinado(), cachorro.getOrigem(), cachorro.getHistorico());
    }
}
