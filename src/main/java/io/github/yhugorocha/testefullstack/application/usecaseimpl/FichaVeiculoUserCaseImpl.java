package io.github.yhugorocha.testefullstack.application.usecaseimpl;

import io.github.yhugorocha.testefullstack.application.gateway.FichaVeiculoGateway;
import io.github.yhugorocha.testefullstack.core.domain.FichaVeiculo;
import io.github.yhugorocha.testefullstack.usecase.FichaVeiculoUserCase;

import java.util.List;
import java.util.UUID;

public class FichaVeiculoUserCaseImpl implements FichaVeiculoUserCase {

    private FichaVeiculoGateway fichaVeiculoGateway;

    public FichaVeiculoUserCaseImpl(FichaVeiculoGateway fichaVeiculoGateway) {
        this.fichaVeiculoGateway = fichaVeiculoGateway;
    }

    @Override
    public void create(FichaVeiculo fichaVeiculo) {
        FichaVeiculo newFichaVeiculo = fichaVeiculoGateway.create(fichaVeiculo);
    }

    @Override
    public void update(UUID id, FichaVeiculo fichaVeiculo) {
        fichaVeiculoGateway.update(id, fichaVeiculo);
    }

    @Override
    public void delete(UUID id) {
        fichaVeiculoGateway.delete(id);
    }

    @Override
    public FichaVeiculo findById(UUID id) {
        return fichaVeiculoGateway.findById(id);
    }

    @Override
    public List<FichaVeiculo> findAll() {
        return fichaVeiculoGateway.findAll();
    }


}
