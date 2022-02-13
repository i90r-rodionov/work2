package org.homework.igorr.domain.config;

import org.homework.igorr.domain.DomainScanMarker;
import org.homework.igorr.domain.entity.EntityScanMarker;
import org.homework.igorr.domain.repository.RepositoryScanMarker;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses = EntityScanMarker.class)
@ComponentScan(basePackageClasses = DomainScanMarker.class)
@EnableJpaRepositories(basePackageClasses = RepositoryScanMarker.class)
@EnableTransactionManagement
public class DomainConfig {
}
