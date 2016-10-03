package edu.pwilder.springTest;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import edu.pwilder.springTest.repository.ProductDao;
import edu.pwilder.springTest.repository.ProductDaoImpl;

@SpringBootApplication
public class SpringTestApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringTestApplication.class, args);
        SpringApplication sa = new SpringApplication(SpringTestApplication.class);
        sa.run(args);
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean lsf = new LocalSessionFactoryBean();
        lsf.setDataSource(getDataSource());
        lsf.setMappingResources("Product.hbm.xml");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
        lsf.setHibernateProperties(hibernateProperties);
        return lsf;
    }

    @Bean
    public BasicDataSource getDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        bds.setUrl("jdbc:derby://localhost:1527/MyDbTest;create=true");
        return bds;
    }
}
