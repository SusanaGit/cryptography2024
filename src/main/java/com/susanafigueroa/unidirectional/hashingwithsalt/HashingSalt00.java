package com.susanafigueroa.unidirectional.hashingwithsalt;

/*
Generate a hash derived from the text "Hello, how are you? :)" using a secure process (PBKDF2) and a salt
(su@susanafigueroa.com) combined with the SHA-256 hash algorithm.
 */

import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;

public class HashingSalt00 {

    public static void main(String[] args) {

        final String textToHash = "Hello, how are you? :)";
        final String salt = "su@susanafigueroa.com";

        // configuro la keySpec
        // convierte el texto a hashear a array char
        // obtiene los bytes del salt
        // cuantas veces se aplicará la función hash internamente -> la iteración con PBKDF2 no solo consiste
        // en hacer el hash del hash, PBKDF2 añade la variable del resultado anterior y de lo que quieres hashear inicialmente
        // para obtener el nuevo hash, sino sería más sencillo de descifrar
        // lenght de la key PBEKeySpec SHA-256 -> normalmente una de estas 128 / 256 / 512
        PBEKeySpec keySpec = new PBEKeySpec(textToHash.toCharArray(), salt.getBytes(), 32, 512);



    }

}
