package io.github.yhugorocha.testefullstack.infrastructure.mapper;

import io.github.yhugorocha.testefullstack.core.domain.FichaVeiculo;
import io.github.yhugorocha.testefullstack.infrastructure.dto.FichaVeiculoRequestDTO;
import io.github.yhugorocha.testefullstack.infrastructure.dto.FichaVeiculoResponseDTO;
import io.github.yhugorocha.testefullstack.infrastructure.entity.FichaVeiculoEntity;

public class FichaVeiculoMapper {

    public FichaVeiculo toVeiculo(FichaVeiculoRequestDTO requestDTO){
        return new FichaVeiculo(requestDTO.veiculo(), requestDTO.marca(), requestDTO.ano(), requestDTO.descricao(),
                requestDTO.vendido(), requestDTO.chassi(), requestDTO.preco());
    }

    public FichaVeiculo toVeiculo(FichaVeiculoEntity fichaVeiculoEntity){
        return new FichaVeiculo(fichaVeiculoEntity.getId(), fichaVeiculoEntity.getVeiculo(), fichaVeiculoEntity.getMarca(), fichaVeiculoEntity.getAno(),
                fichaVeiculoEntity.getDescricao(), fichaVeiculoEntity.getVendido(), fichaVeiculoEntity.getCreated(), fichaVeiculoEntity.getUpdate(),
                fichaVeiculoEntity.getChassi(), fichaVeiculoEntity.getPreco());
    }

    public FichaVeiculoEntity toVeiculoEntity(FichaVeiculo fichaVeiculo){
        return new FichaVeiculoEntity(fichaVeiculo.getVeiculo(), fichaVeiculo.getMarca(), fichaVeiculo.getAno(), fichaVeiculo.getDescricao(), fichaVeiculo.getVendido(),
                fichaVeiculo.getCreated(), fichaVeiculo.getUpdate(), fichaVeiculo.getChassi(), fichaVeiculo.getPreco());
    }

    public FichaVeiculoResponseDTO toVeiculoResponse(FichaVeiculo fichaVeiculo){
        return new FichaVeiculoResponseDTO(fichaVeiculo.getId(), fichaVeiculo.getVeiculo(), fichaVeiculo.getMarca(), fichaVeiculo.getAno(),
                fichaVeiculo.getDescricao(), fichaVeiculo.getVendido(), fichaVeiculo.getCreated(), fichaVeiculo.getUpdate(), fichaVeiculo.getChassi(), fichaVeiculo.getPreco());
    }
}
