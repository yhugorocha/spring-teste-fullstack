package io.github.yhugorocha.testefullstack.infrastructure.service;

import io.github.yhugorocha.testefullstack.application.gateway.FichaVeiculoGateway;
import io.github.yhugorocha.testefullstack.core.domain.FichaVeiculo;
import io.github.yhugorocha.testefullstack.core.exception.BusinessException;
import io.github.yhugorocha.testefullstack.core.exception.NotFoundException;
import io.github.yhugorocha.testefullstack.infrastructure.entity.FichaVeiculoEntity;
import io.github.yhugorocha.testefullstack.infrastructure.mapper.FichaVeiculoMapper;
import io.github.yhugorocha.testefullstack.infrastructure.repository.FichaVeiculoRepository;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FichaVeiculoGatewayImpl implements FichaVeiculoGateway {

    private FichaVeiculoRepository fichaVeiculoRepository;
    private FichaVeiculoMapper fichaVeiculoMapper;

    public FichaVeiculoGatewayImpl(FichaVeiculoRepository fichaVeiculoRepository, FichaVeiculoMapper fichaVeiculoMapper) {
        this.fichaVeiculoRepository = fichaVeiculoRepository;
        this.fichaVeiculoMapper = fichaVeiculoMapper;
    }

    @Override
    public FichaVeiculo create(FichaVeiculo fichaVeiculo) {

        if(fichaVeiculoRepository.findByChassi(fichaVeiculo.getChassi()).isPresent()){
            throw new BusinessException("Chassi já se encontra cadastrado!");
        }

        FichaVeiculoEntity veiculoSalvo = fichaVeiculoRepository.save(fichaVeiculoMapper.toVeiculoEntity(fichaVeiculo));
        return fichaVeiculoMapper.toVeiculo(veiculoSalvo);
    }

    @Override
    public void update(UUID id, FichaVeiculo fichaVeiculo) {

        FichaVeiculoEntity fichaVeiculoEntity = fichaVeiculoRepository.findById(id).orElseThrow(() -> new NotFoundException("Veiculo não encontrado!"));
        Optional<FichaVeiculoEntity> veiculoChassi = fichaVeiculoRepository.findByChassi(fichaVeiculo.getChassi());

        if(veiculoChassi.isPresent() && !fichaVeiculoEntity.equals(veiculoChassi.get())){
            throw new BusinessException("Chassi já se encontra cadastrado!");
        }

        fichaVeiculoEntity.setVeiculo(fichaVeiculo.getVeiculo());
        fichaVeiculoEntity.setMarca(fichaVeiculo.getMarca());
        fichaVeiculoEntity.setAno(fichaVeiculo.getAno());
        fichaVeiculoEntity.setDescricao(fichaVeiculo.getDescricao());
        fichaVeiculoEntity.setVendido(fichaVeiculo.getVendido());
        fichaVeiculoEntity.setUpdate(LocalDateTime.now());
        fichaVeiculoEntity.setChassi(fichaVeiculo.getChassi());
        fichaVeiculoEntity.setPreco(fichaVeiculo.getPreco());

        fichaVeiculoRepository.save(fichaVeiculoEntity);

    }

    @Override
    public void delete(UUID id) {
        fichaVeiculoRepository.findById(id).ifPresentOrElse(fichaVeiculoRepository::delete, () -> new NotFoundException("Veiculo não encontrado!"));
    }

    @Override
    public FichaVeiculo findById(UUID id) {
        return fichaVeiculoRepository.findById(id).map(fichaVeiculoMapper::toVeiculo).orElseThrow(() -> new NotFoundException("Veiculo não encontrado!"));
    }

    @Override
    public List<FichaVeiculo> findAll() {
        return fichaVeiculoRepository.findAll().stream().map(fichaVeiculoMapper::toVeiculo).toList();
    }

    @Override
    public List<FichaVeiculo> findAll(String veiculo, String marca, Integer ano, String descricao, Boolean vendido, String chassi, BigDecimal preco) {
        FichaVeiculoEntity entity = new FichaVeiculoEntity();
        entity.setVeiculo(veiculo);
        entity.setMarca(marca);
        entity.setAno(ano);
        entity.setDescricao(descricao);
        entity.setVendido(vendido);
        entity.setChassi(chassi);
        entity.setPreco(preco);

        Example<FichaVeiculoEntity> example = Example.of(entity);
        return fichaVeiculoRepository.findAll(example).stream().map(fichaVeiculoMapper::toVeiculo).toList();
    }


}
