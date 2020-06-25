package com.saeid.config;

import com.saeid.model.Person;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.saeid")
public class AppConfig {
    @Bean
    public DataSource mysqlDataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Test");
        dataSource.setUsername("root");
        dataSource.setPassword("saeid");
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean factoryBean(DataSource dataSource){
        LocalSessionFactoryBean  factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setAnnotatedClasses(Person.class);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.current_session_context_class","thread");
        properties.setProperty("hibernate.show_sql","false");
        factoryBean.setHibernateProperties(properties);
        return factoryBean;
    }
    @Bean
    public MappingJackson2HttpMessageConverter converter(){
        return new MappingJackson2HttpMessageConverter();
    }
    @Bean
    public RequestMappingHandlerAdapter adapter(MappingJackson2HttpMessageConverter converter){
        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        handlerAdapter.getMessageConverters().add(converter);
        return handlerAdapter;
    }

}
