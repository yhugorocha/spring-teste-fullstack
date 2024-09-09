package io.github.yhugorocha.testefullstack.infrastructure.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record FichaVeiculoRequestDTO(@NotNull @NotBlank String veiculo, @NotNull @NotBlank String marca, @NotNull @Min(0) Integer ano, @NotNull @NotBlank String descricao, @NotNull Boolean vendido, @NotNull @NotBlank String chassi, @NotNull @Min(0) BigDecimal preco) {
}
