package com.dogspot.dogspot.DTO;

public record ONGDTO(
        Long id,
        String nome,
        int quantidadeFuncionarios,
        String parcerias,
        String contato,
        String registroAdocaoResgate,
        String endereco
) {
    public ONGDTO(com.dogspot.dogspot.Entities.ONG ong) {
        this(ong.getId(), ong.getNome(), ong.getQuantidadeFuncionarios(), ong.getParcerias(), ong.getContato(), ong.getRegistroAdocaoResgate(), ong.getEndereco());
    }
}
