package sap.gb.hibernate.lesson_one.persist;

import java.util.List;

public interface DAO<T> {

    void save(T t);

    T findById(long id);

    List<T> findAll();

}
