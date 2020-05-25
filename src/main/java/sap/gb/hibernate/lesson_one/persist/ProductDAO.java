package sap.gb.hibernate.lesson_one.persist;

import sap.gb.hibernate.lesson_one.dto.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAO implements DAO<Product> {
    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public Product findById(long id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().commit();
        return product;
    }

    public List<Product> findAll() {
        entityManager.getTransaction().begin();
        List<Product> products = entityManager
                .createNamedQuery("Product.findAll")
                .getResultList();
        entityManager.getTransaction().commit();
        return products;
    }

    public void delete(long id) {
        Product product = findById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}
