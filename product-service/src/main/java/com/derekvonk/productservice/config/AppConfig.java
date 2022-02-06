package com.derekvonk.productservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.derekvonk.productservice.product")
@EntityScan("com.derekvonk.productservice.product")
public class AppConfig {
}
