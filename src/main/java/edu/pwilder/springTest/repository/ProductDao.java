package edu.pwilder.springTest.repository;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import edu.pwilder.springTest.model.Product;

public interface ProductDao {

    Product getProductById(int id);

    void upsertProduct(Product product);

    void setSessionFactory(LocalSessionFactoryBean sf);
}
