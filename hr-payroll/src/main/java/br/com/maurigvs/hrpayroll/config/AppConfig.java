package br.com.maurigvs.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /* Registra uma instancia unica (Singleton) que fica disponível
    para injeção em outros componentes */
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
