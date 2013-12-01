package org.aperator.spontan.controller;

import org.aperator.spontan.model.data.manager.PasswordManager;
import org.aperator.spontan.model.data.manager.impl.DummyPasswordManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 01/12/13
 * Time: 19:14
 */
@Configuration
public class JUnitConfiguration {

    @Bean(name = "passwordManager")
    public PasswordManager passwordManager() {
        return new DummyPasswordManager();
    }
}
