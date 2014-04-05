package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.manager.impl.GenericDaoJpa;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 03/04/14
 * Time: 23:29
 */
@Repository("PasswordDAO")
public class PasswordDAOJpaImpl extends GenericDaoJpa<Password> implements PasswordDAO {

    public PasswordDAOJpaImpl() {
        super(Password.class);
    }

    @Override
    public Password findByUserId(Long userId) {
        return null;
    }
}