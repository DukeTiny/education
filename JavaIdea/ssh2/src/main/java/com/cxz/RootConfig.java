package com.cxz;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class RootConfig {

    @Bean
    public DruidDataSource ds(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("wh809919");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sf(){
        LocalSessionFactoryBean lSFB = new LocalSessionFactoryBean();
        lSFB.setDataSource(ds());
        Resource r = new ClassPathResource("com/cxz/domain/Dept.hbm.xml");
        Resource r2 = new ClassPathResource("com/cxz/domain/Emp.hbm.xml");
        lSFB.setMappingLocations(r,r2);
        Properties prop = new Properties();
        prop.put("hibernate.show_sql","true");
        prop.put("hibernate.format_sql","true");
        prop.put("hibernate.hbm2ddl.auto","create");
        lSFB.setHibernateProperties(prop);
        return lSFB;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sf().getObject());
        return htm;
    }
}
