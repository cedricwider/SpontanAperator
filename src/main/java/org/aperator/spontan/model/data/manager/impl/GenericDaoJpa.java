package org.aperator.spontan.model.data.manager.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 13/01/14
 * Time: 21:47
 */
@Transactional(propagation= Propagation.REQUIRED)
public class GenericDaoJpa<T> implements GenericDao<T> {

    private final Class<T> type;

    protected EntityManager entityManager;

    public GenericDaoJpa(Class<T> type) {
        super();
        this.type = type;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        return id == null ? null : this.entityManager.find(type, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        String query = "select o from " + type.getName() + "o";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public T update(T object) {
        return entityManager.merge(object);
    }

    @Override
    public void save(T object) {
        entityManager.persist(object);
    }

    @Override
    public void delete(T object) {
        object = entityManager.merge(object);
        entityManager.remove(object);
    }

}
