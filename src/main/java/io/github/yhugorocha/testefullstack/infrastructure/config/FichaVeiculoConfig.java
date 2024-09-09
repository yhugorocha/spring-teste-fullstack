package io.github.yhugorocha.testefullstack.infrastructure.config;

import io.github.yhugorocha.testefullstack.infrastructure.Util.PageUtil;
import io.github.yhugorocha.testefullstack.infrastructure.mapper.FichaVeiculoMapper;
import io.github.yhugorocha.testefullstack.infrastructure.repository.FichaVeiculoRepository;
import io.github.yhugorocha.testefullstack.infrastructure.service.FichaVeiculoGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FichaVeiculoConfig {

    @Bean
    FichaVeiculoGatewayImpl veiculoGateway(FichaVeiculoRepository fichaVeiculoRepository, FichaVeiculoMapper fichaVeiculoMapper){
        return new FichaVeiculoGatewayImpl(fichaVeiculoRepository, fichaVeiculoMapper);
    }

    @Bean
    FichaVeiculoMapper veiculoMapper(){
        return new FichaVeiculoMapper();
    }

    @Bean
    PageUtil pageUtil(){
        return new PageUtil();
    }

}

