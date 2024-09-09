package io.github.yhugorocha.testefullstack.usecase;

import io.github.yhugorocha.testefullstack.core.domain.FichaVeiculo;

import java.util.List;
import java.util.UUID;

public interface FichaVeiculoUserCase {

    void create(FichaVeiculo fichaVeiculo);

    void update(UUID id, FichaVeiculo fichaVeiculo);

    void delete(UUID id);

    FichaVeiculo findById(UUID id);

    List<FichaVeiculo> findAll();

}
