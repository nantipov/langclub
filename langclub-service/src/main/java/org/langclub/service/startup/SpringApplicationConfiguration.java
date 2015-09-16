package org.langclub.service.startup;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.net.UnknownHostException;

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
@ComponentScan(basePackages = {"org.langclub.service"})
@EnableWebMvc
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "org.langclub.service.dao", entityManagerFactoryRef = "relationEntityManagerFactory", transactionManagerRef = "relationalTransactionalManager")
@EnableMongoRepositories(basePackages = "org.langclub.service.dao")
@EnableTransactionManagement
public class SpringApplicationConfiguration extends WebSecurityConfigurerAdapter {

    /* JPA */
    @Bean
    public DataSource relationalDataSource() {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        return dsLookup.getDataSource("datasource/testH2Db"); //TODO: properties
    }

    @Bean
    public EntityManagerFactory relationEntityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("relationalDataUnit");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(relationalDataSource());
        factory.setPackagesToScan("org.langclub.api");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager relationalTransactionalManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(relationEntityManagerFactory());
        return txManager;
    }

    /* mongo */
    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(new MongoClient("host", 27017), "dbname");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
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
