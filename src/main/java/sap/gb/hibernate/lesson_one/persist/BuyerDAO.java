package sap.gb.hibernate.lesson_one.persist;

import sap.gb.hibernate.lesson_one.dto.Buyer;

import javax.persistence.EntityManager;
import java.util.List;

public class BuyerDAO implements DAO<Buyer>{
    private EntityManager entityManager;

    public BuyerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Buyer buyer) {
        entityManager.getTransaction().begin();
        entityManager.persist(buyer);
        entityManager.getTransaction().commit();
    }

    public Buyer findById(long id) {
        entityManager.getTransaction().begin();
        Buyer buyer = entityManager.find(Buyer.class, id);
        entityManager.getTransaction().commit();
        return buyer;
    }

    public List<Buyer> findAll() {
        entityManager.getTransaction().begin();
        List<Buyer> buyers = entityManager
                .createNamedQuery("Buyer.findAllId")
                .getResultList();
        entityManager.getTransaction().commit();
        return buyers;
    }

    public void delete(long id) {
        Buyer buyer = findById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(buyer);
        entityManager.getTransaction().commit();
    }
}
