package io.github.yhugorocha.testefullstack.application.usecaseimpl;

import io.github.yhugorocha.testefullstack.application.gateway.VeiculoGateway;
import io.github.yhugorocha.testefullstack.core.domain.Veiculo;
import io.github.yhugorocha.testefullstack.usecase.VeiculoUserCase;

import java.util.List;
import java.util.UUID;

public class VeiculoUserCaseImpl implements VeiculoUserCase {

    private VeiculoGateway veiculoGateway;

    public VeiculoUserCaseImpl(VeiculoGateway veiculoGateway) {
        this.veiculoGateway = veiculoGateway;
    }

    @Override
    public void create(Veiculo veiculo) {
        Veiculo newVeiculo = veiculoGateway.create(veiculo);
    }

    @Override
    public void update(UUID id, Veiculo veiculo) {
        veiculoGateway.update(id,veiculo);
    }

    @Override
    public void delete(UUID id) {
        veiculoGateway.delete(id);
    }

    @Override
    public Veiculo findById(UUID id) {
        return veiculoGateway.findById(id);
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoGateway.findAll();
    }


}
