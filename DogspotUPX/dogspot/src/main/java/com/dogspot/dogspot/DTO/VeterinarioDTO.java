package com.dogspot.dogspot.DTO;

import com.dogspot.dogspot.Entities.Veterinario;
public record VeterinarioDTO(
        String agendamentos,
        String numeroCRMV,
        String especialidade,
        String nome
) {
    public VeterinarioDTO(com.dogspot.dogspot.Entities.Veterinario veterinario) {
        this(veterinario.getAgendamentos(), veterinario.getNumeroCRMV(), veterinario.getEspecialidade(), veterinario.getNome());
    }
}
