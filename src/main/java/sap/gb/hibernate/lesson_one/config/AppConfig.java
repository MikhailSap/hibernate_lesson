package sap.gb.hibernate.lesson_one.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sap.gb.hibernate.lesson_one.persist.BuyerDAO;
import sap.gb.hibernate.lesson_one.persist.ProductDAO;
import sap.gb.hibernate.lesson_one.service.ServiceImpl;

import javax.persistence.EntityManager;

@Configuration
public class AppConfig {

    @Bean
    public ServiceImpl service(BuyerDAO buyerDAO, ProductDAO productDAO) {
        return new ServiceImpl(buyerDAO, productDAO);
    }

    @Bean
    public BuyerDAO buyerDAO(EntityManager entityManager) {
        return new BuyerDAO(entityManager);
    }

    @Bean
    public ProductDAO productDAO(EntityManager entityManager) {
        return new ProductDAO(entityManager);
    }


    @Bean
    public EntityManager entityManager() {
        return new org.hibernate
                .cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .createEntityManager();
    }
}
