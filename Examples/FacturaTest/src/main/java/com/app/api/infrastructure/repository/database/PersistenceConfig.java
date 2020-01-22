package com.app.api.infrastructure.repository.database;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({ "com.example.demo.repository", "com.example.demo.infraestructura.repository.database" })
public class PersistenceConfig {

}
