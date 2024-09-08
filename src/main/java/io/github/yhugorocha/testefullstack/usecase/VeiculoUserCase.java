package io.github.yhugorocha.testefullstack.usecase;

import io.github.yhugorocha.testefullstack.core.domain.Veiculo;

import java.util.List;
import java.util.UUID;

public interface VeiculoUserCase {

    void create(Veiculo veiculo);

    void update(UUID id, Veiculo veiculo);

    void delete(UUID id);

    Veiculo findById(UUID id);

    List<Veiculo> findAll();

}
