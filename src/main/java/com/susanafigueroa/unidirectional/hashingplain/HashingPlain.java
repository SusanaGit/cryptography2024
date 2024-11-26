package com.susanafigueroa.unidirectional.hashingplain;

/*
Calculate the hash of the pom.xml file using the SHA-256 algorithm.
 */

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPlain {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // create a MessageDigest object
        // we use MessageDigest because this class generates crypto hashes
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String baseUrl = System.getProperty("user.dir") + File.separator;

        String nameFile = "pom.xml";

        File file = new File(baseUrl + nameFile);

        if (file.exists()) {
            System.out.println("The file exists.");
        } else {
            System.out.println("The file doesn't exist.");
        }
    }

}
