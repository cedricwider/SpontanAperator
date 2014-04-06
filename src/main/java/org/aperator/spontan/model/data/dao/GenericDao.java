package org.aperator.spontan.model.data.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 13/01/14
 * Time: 21:55
 */
public interface GenericDao<T> {
    T findById(Long id);

    void save(T object);

    void delete(T object);

    List<T> getAll();

    T update(T user);
}
