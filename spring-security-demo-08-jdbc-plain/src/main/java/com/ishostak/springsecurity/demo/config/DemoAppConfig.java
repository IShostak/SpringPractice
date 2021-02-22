package com.ishostak.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ishostak.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    //set up a variable for properties

    @Autowired
    private Environment environment;

    //set up logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //define a bean for ViewResolver

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/webapp/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    //define a bean for security

    @Bean
    public DataSource securityDataSource() {

        ComboPooledDataSource securityDataSource =
                                new ComboPooledDataSource();

        //read props from the file
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException ex) {
            throw new RuntimeException(ex);
        }

        //log connection info

        logger.info("jdbc url" + environment.getProperty("jdbc.url"));
        logger.info("jdbc user" + environment.getProperty("jdbc.user"));

        //set connection props
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        //set connection pool props
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private int getIntProperty(String propName) {
        String prop = environment.getProperty(propName);

        return Integer.parseInt(prop);
    }
}
