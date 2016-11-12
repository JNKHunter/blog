package tech.eats.art.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * Created by John on 11/12/16.
 */
@Configuration
public class DataConfig {
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setConfig Location(config);
        return sessionFactoryBean;
    }
}
