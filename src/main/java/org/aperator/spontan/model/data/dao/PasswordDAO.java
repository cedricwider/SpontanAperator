package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.Password;

/**
 * User: cedster
 * Date: 01/12/13
 * Time: 18:22
 */
public interface PasswordDAO {


    public void save(Password password);

    public Password findByUserId(Long userId);

    public void update(Password password);

    public void delete(Password password);
}
