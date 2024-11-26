package com.susanafigueroa.unidirectional.hashingplain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPlain02 {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String basePath = System.getProperty("user.dir") + File.separator;
        String nameFile = "pom.xml";

        byte[] allData = Files.readAllBytes(Path.of(basePath + nameFile));
        byte[] hashedBytes = md.digest(allData);

        // convierto a hexadecimal el array de bytes que contiene el hash
        StringBuilder hashEx = new StringBuilder();
        for (byte hashed : hashedBytes) {
            hashEx.append(String.format("%02x", hashed));
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<< HASH >>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(hashEx);
    }

}
