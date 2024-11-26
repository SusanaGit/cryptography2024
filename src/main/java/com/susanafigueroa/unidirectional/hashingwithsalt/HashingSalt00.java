package com.susanafigueroa.unidirectional.hashingwithsalt;

/*
Generate a hash derived from the text "Hello, how are you? :)" using a secure process (PBKDF2) and a salt
(su@susanafigueroa.com) combined with the SHA-256 hash algorithm.
 */

import com.susanafigueroa.Util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class HashingSalt00 {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        final String textToHash = "Hello, how are you? :)";

        // se combina con el texto a cifrar para hacerlo único
        final String salt = "su@susanafigueroa.com";

        // configuro la keySpec -> esta especificación encapsula todos los parámetros necesarios para derivar la key
        // la keySpec solo actúa como contenedor de parámetros
        // param -> convierte el texto a hashear a array char
        // param -> obtiene los bytes del salt
        // param -> cuantas veces se aplicará la función hash internamente -> la iteración con PBKDF2 no solo consiste
        // en hacer el hash del hash, PBKDF2 añade la variable del resultado anterior y de lo que quieres hashear inicialmente
        // para obtener el nuevo hash, sino sería más sencillo de descifrar
        // param -> lenght de la key PBEKeySpec SHA-256 -> normalmente una de estas 128 / 256 / 512
        PBEKeySpec keySpec = new PBEKeySpec(textToHash.toCharArray(), salt.getBytes(), 32, 512);

        // obtengo instancia SecretKeyFactory para poder generar la clave cripto
        // convierte textos planos simples en keys seguras, que pueden ser procesadas por algoritmos (en este caso
        // por el PBKDF2WithHmacSHA256)
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        // obtengo el hash del textToHash unido a salt
        byte[] hash = skf.generateSecret(keySpec).getEncoded();

        System.out.println("hash of the textToHash with salt: " + Util.bytesToHex(hash));

    }

}
