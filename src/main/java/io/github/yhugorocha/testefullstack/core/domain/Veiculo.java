package io.github.yhugorocha.testefullstack.core.domain;

import io.github.yhugorocha.testefullstack.core.exception.BusinessException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.UUID;

public class Veiculo {

    private UUID id;
    private String veiculo;
    private String marca;
    private Integer ano;
    private String descricao;
    private Boolean vendido;
    private LocalDateTime created;
    private LocalDateTime update;
    private String chassi;
    private BigDecimal preco;

    public Veiculo(UUID id, String veiculo, String marca, Integer ano, String descricao, Boolean vendido, LocalDateTime created, LocalDateTime update, String chassi, BigDecimal preco) {
        this.id = id;
        this.veiculo = veiculo;
        this.marca = marca;
        this.setAno(ano);
        this.descricao = descricao;
        this.vendido = vendido;
        this.created = created;
        this.update = update;
        this.chassi = chassi;
        this.setPreco(preco);
    }

    public Veiculo(String veiculo, String marca, Integer ano, String descricao, Boolean vendido, String chassi, BigDecimal preco) {
        this.veiculo = veiculo;
        this.marca = marca;
        this.setAno(ano);
        this.descricao = descricao;
        this.vendido = vendido;
        this.created = LocalDateTime.now();
        this.chassi = chassi;
        this.setPreco(preco);
    }

    public Veiculo() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        if(ano > Calendar.getInstance().get(Calendar.YEAR)){
            throw new BusinessException("O Ano do veiculo não pode ser superior ao ano atual!");
        }
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdate() {
        return update;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if(preco.intValue() < 0){
            throw new BusinessException("O Preço do veiculo não pode ser inferior a 0!");
        }
        this.preco = preco;
    }
}
