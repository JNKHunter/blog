package tech.eats.art.blog.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by John on 11/12/16.
 */
@Configuration
@PropertySource("app.properties")
public class DataConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setConfigLocation(config);
        sessionFactoryBean.setPackagesToScan(env.getProperty("blog.entity.package"));
        sessionFactoryBean.setDataSource(dataSource());
        return sessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();

        // Driver class name
        ds.setDriverClassName(env.getProperty("blog.db.driver"));

        // Set url
        ds.setUrl(env.getProperty("blog.db.url"));

        // Set username & password
        ds.setUsername(env.getProperty("blog.db.username"));
        ds.setPassword(env.getProperty("blog.db.password"));


        return ds;
    }
}
