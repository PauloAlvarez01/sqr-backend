package com.sanatorio.sqrbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // Cuando agreguemos seguridad, acá leeremos el usuario logueado.
        // Por ahora, le decimos que todo lo hace "SISTEMA".
        return () -> Optional.of("SISTEMA");
    }
}
