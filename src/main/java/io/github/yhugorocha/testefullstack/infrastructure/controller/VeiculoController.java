package io.github.yhugorocha.testefullstack.infrastructure.controller;

import io.github.yhugorocha.testefullstack.application.gateway.FichaVeiculoGateway;
import io.github.yhugorocha.testefullstack.core.domain.FichaVeiculo;
import io.github.yhugorocha.testefullstack.infrastructure.util.PageUtil;
import io.github.yhugorocha.testefullstack.infrastructure.dto.FichaVeiculoRequestDTO;
import io.github.yhugorocha.testefullstack.infrastructure.dto.FichaVeiculoResponseDTO;
import io.github.yhugorocha.testefullstack.infrastructure.mapper.FichaVeiculoMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("veiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VeiculoController {

    private FichaVeiculoGateway fichaVeiculoGateway;
    private FichaVeiculoMapper fichaVeiculoMapper;
    private PageUtil pageUtil;

    public VeiculoController(FichaVeiculoGateway fichaVeiculoGateway, FichaVeiculoMapper fichaVeiculoMapper, PageUtil pageUtil) {
        this.fichaVeiculoGateway = fichaVeiculoGateway;
        this.fichaVeiculoMapper = fichaVeiculoMapper;
        this.pageUtil = pageUtil;
    }

    @PostMapping()
    public ResponseEntity salvarVeiculo(@Valid @RequestBody FichaVeiculoRequestDTO requestDTO){
        FichaVeiculo fichaVeiculo = fichaVeiculoMapper.toVeiculo(requestDTO);
        fichaVeiculoGateway.create(fichaVeiculo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarVeiculo(@PathVariable UUID id,@Valid @RequestBody FichaVeiculoRequestDTO requestDTO){
        FichaVeiculo fichaVeiculo = fichaVeiculoMapper.toVeiculo(requestDTO);
        fichaVeiculoGateway.update(id, fichaVeiculo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarVeiculo(@PathVariable UUID id){
        fichaVeiculoGateway.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<?>> buscarTodosVeiculos(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size){
        Page<?> resultado = pageUtil.adicionaPaginacao(fichaVeiculoGateway.findAll().stream().map(fichaVeiculoMapper::toVeiculoResponse).toList(), page, size);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaVeiculoResponseDTO> buscarVeiculo(@PathVariable UUID id){
        return ResponseEntity.ok(fichaVeiculoMapper.toVeiculoResponse(fichaVeiculoGateway.findById(id)));
    }

    @GetMapping("/filtro")
    public ResponseEntity<Page<?>> buscarVeiculoFiltroDinamico(@RequestParam(value = "veiculo", required = false) String veiculo,
         @RequestParam(value = "marca", required = false) String marca, @RequestParam(value = "ano", required = false) Integer ano,
         @RequestParam(value = "descricao", required = false) String descricao,@RequestParam(value = "vendido", required = false) Boolean vendido,
         @RequestParam(value = "chassi", required = false) String chassi,@RequestParam(value = "preco", required = false)BigDecimal preco){

        Page<?> resultado = pageUtil.adicionaPaginacao(
                fichaVeiculoGateway.findAll(veiculo, marca, ano, descricao, vendido, chassi, preco).stream().map(fichaVeiculoMapper::toVeiculoResponse).toList(), 0, 10);

        return ResponseEntity.ok(resultado);
    }

}
