package com.schiphol.alpha.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackageClasses = {PackageMarker.class, com.schiphol.alpha.persistence.PackageMarker.class, com.schiphol.alpha.service.PackageMarker.class,})
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
@EnableJpaRepositories(basePackageClasses = {com.schiphol.alpha.persistence.repository.DriverRespository.class})
@EntityScan(basePackageClasses = {com.schiphol.alpha.persistence.entity.Driver.class, Jsr310JpaConverters.class})
@EnableTransactionManagement(proxyTargetClass = true)
@Slf4j
public class Application {
}