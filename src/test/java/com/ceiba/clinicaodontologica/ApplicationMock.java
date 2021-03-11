package com.ceiba.clinicaodontologica;

import java.io.IOException;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@ComponentScan(basePackages = "com.ceiba.clinicaodontologica")
public class ApplicationMock {

    @Bean
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean(initMethod = "migrate")
    Flyway flyway(DataSource dataSource) throws IOException {

        return Flyway.configure().locations("filesystem:../src/main/resources","filesystem:src/test/resources").baselineOnMigrate(true)
                .dataSource(dataSource).load();

    }
	
}
