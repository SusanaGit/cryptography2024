package com.susanafigueroa.unidirectional.hashingwithsalt;

import com.susanafigueroa.Util;

import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashingSalt01 {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException {

        HashingSalt01 hashingSalt01 = new HashingSalt01();

        String basePath = System.getProperty("user.dir") + File.separator;
        String nameFile = "pom.xml";

        // obtengo la salt random
        byte[] saltBytes = hashingSalt01.generateRandomSalt();

        // calculo el HMAC del file + salt
        // mac genera código de autenticación de mensajes basado en hash
        // quiero usar mac con SHA-256
        Mac mac = Mac.getInstance("HmacSHA256");

        // configuro la keySpec con los parámetros
        SecretKeySpec keySpec = new SecretKeySpec(saltBytes, "HmacSHA256");

        // inicializo la instancia mac con la keySpec que contiene la salt y el algoritmo
        mac.init(keySpec);





    }

    private byte[] generateRandomSalt() {
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }
}
