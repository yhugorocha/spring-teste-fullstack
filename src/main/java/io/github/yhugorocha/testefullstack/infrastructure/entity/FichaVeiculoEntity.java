package io.github.yhugorocha.testefullstack.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ficha_veiculo")
@Entity
public class FichaVeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "veiculo", nullable = false)
    private String veiculo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "vendido", nullable = false)
    private Boolean vendido;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "update", nullable = true)
    private LocalDateTime update;

    @Column(name = "chassi", nullable = false, unique = true)
    private String chassi;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;


    public FichaVeiculoEntity(String veiculo, String marca, Integer ano, String descricao, Boolean vendido, LocalDateTime created, LocalDateTime update, String chassi, BigDecimal preco) {
        this.veiculo = veiculo;
        this.marca = marca;
        this.ano = ano;
        this.descricao = descricao;
        this.vendido = vendido;
        this.created = created;
        this.update = update;
        this.chassi = chassi;
        this.preco = preco;
    }
}
