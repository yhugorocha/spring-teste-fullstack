package io.github.yhugorocha.testefullstack.application.gateway;

import io.github.yhugorocha.testefullstack.core.domain.FichaVeiculo;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface FichaVeiculoGateway {

    FichaVeiculo create(FichaVeiculo fichaVeiculo);
    void update(UUID id, FichaVeiculo fichaVeiculo);
    void delete(UUID id);
    FichaVeiculo findById(UUID id);
    List<FichaVeiculo> findAll();
    List<FichaVeiculo> findAll(String veiculo, String marca, Integer ano, String descricao, Boolean vendido, String chassi, BigDecimal preco);
}
