package io.github.yhugorocha.testefullstack.application.gateway;

import io.github.yhugorocha.testefullstack.core.domain.Veiculo;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface VeiculoGateway {

    Veiculo create(Veiculo veiculo);
    void update(UUID id, Veiculo veiculo);
    void delete(UUID id);
    Veiculo findById(UUID id);
    List<Veiculo> findAll();
    List<Veiculo> findAll(String veiculo, String marca, Integer ano, String descricao, Boolean vendido, String chassi, BigDecimal preco);
}
