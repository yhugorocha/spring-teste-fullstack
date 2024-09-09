package io.github.yhugorocha.testefullstack.infrastructure.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record FichaVeiculoResponseDTO(UUID id, String veiculo, String marca, Integer ano, String descricao, Boolean vendido,
                                      LocalDateTime created, LocalDateTime update, String chassi, BigDecimal preco) {
}
