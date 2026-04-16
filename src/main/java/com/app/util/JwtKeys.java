package com.app.util;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtKeys {
    private static final KeyPair KEY_PAIR = generate();
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    private static KeyPair generate() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            return kpg.generateKeyPair();
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate RSA key pair", e);
        }
    }

    public static PrivateKey privateKey() {
    	System.out.println(KEY_PAIR.getPrivate()+"-------");
        return KEY_PAIR.getPrivate();
    }

    public static PublicKey publicKey() {
        return KEY_PAIR.getPublic();
    }
}