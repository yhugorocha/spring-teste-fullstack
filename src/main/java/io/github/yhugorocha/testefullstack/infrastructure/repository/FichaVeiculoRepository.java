package io.github.yhugorocha.testefullstack.infrastructure.repository;

import io.github.yhugorocha.testefullstack.infrastructure.entity.FichaVeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FichaVeiculoRepository extends JpaRepository<FichaVeiculoEntity, UUID> {

    Optional<FichaVeiculoEntity> findByChassi(String chassi);
}
