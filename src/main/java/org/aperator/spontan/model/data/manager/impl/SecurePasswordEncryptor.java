package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.manager.PasswordEncryptor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 12/12/13
 * Time: 22:11
 */
public class SecurePasswordEncryptor implements PasswordEncryptor {

    private String encryptionAlgorithm;

    @Override
    public String encrypt(String password) {
        try {
            return new String(MessageDigest.getInstance(encryptionAlgorithm).digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("EncryptionAlgorithm " + encryptionAlgorithm + " does not exist");
        }
    }

    public void setEncryptionAlgorithm(String encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }
}
