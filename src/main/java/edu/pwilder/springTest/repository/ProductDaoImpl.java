package edu.pwilder.springTest.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pwilder.springTest.model.Product;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    public ProductDaoImpl() {
        super();
    }

    @Override
    public Product getProductById(int id) {
        return (Product) this.sessionFactory.getObject().getCurrentSession()
                .createQuery("from Product product where id=:id").setParameter("id", id).uniqueResult();
    }

    @Override
    public void upsertProduct(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.saveOrUpdate(product);

    }

    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}