package org.langclub.startup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */


@Configuration
@ComponentScan(basePackages = {"org.langclub"})
@EnableWebMvc
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "org.langclub.service.**.dao", entityManagerFactoryRef = "relationEntityManagerFactory", transactionManagerRef = "relationalTransactionalManager")
@EnableTransactionManagement
public class SpringApplicationConfiguration extends WebSecurityConfigurerAdapter {

    /* JPA */
    @Bean
    public DataSource relationalDataSource() {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        return dsLookup.getDataSource("datasource/testH2Db"); //TODO: properties
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean relationalEntityManagerFactoryBean() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("relationalDataUnit");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(relationalDataSource());
        factory.setPackagesToScan("org.langclub.api");
        return factory;
    }

    @Bean
    public EntityManagerFactory relationEntityManagerFactory(LocalContainerEntityManagerFactoryBean emfBean) {
        return emfBean.getObject();
    }

    @Bean
    public PlatformTransactionManager relationalTransactionalManager(LocalContainerEntityManagerFactoryBean emfBean) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(relationEntityManagerFactory(emfBean));
        return txManager;
    }

    /* web */
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /* spring security */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**").httpBasic();
    }
}
