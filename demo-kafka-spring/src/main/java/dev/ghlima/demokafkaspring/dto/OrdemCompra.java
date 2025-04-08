package dev.ghlima.demokafkaspring.dto;

public record OrdemCompra(
        Long id,
        String produto,
        Integer quantidade,
        Double preco
) {
}
