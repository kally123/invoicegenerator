package com.mc.invoice.config;

import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryConfiguration;
import com.mc.invoice.InvoiceGeneraorApplication;
import io.springlets.data.jpa.repository.support.DetachableJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * = SpringDataJpaDetachableRepositoryConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryConfiguration
@Configuration
@EnableJpaRepositories(repositoryBaseClass = DetachableJpaRepositoryImpl.class, basePackageClasses = InvoiceGeneraorApplication.class)
public class SpringDataJpaDetachableRepositoryConfiguration {
}
