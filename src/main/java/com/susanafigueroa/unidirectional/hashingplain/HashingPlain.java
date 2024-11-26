package com.susanafigueroa.unidirectional.hashingplain;

/*
Calculate the hash of the pom.xml file using the SHA-256 algorithm.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPlain {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // create a MessageDigest object
        // we use MessageDigest because this class generates crypto hashes
        MessageDigest md = MessageDigest.getInstance("SHA-256");


    }

}
