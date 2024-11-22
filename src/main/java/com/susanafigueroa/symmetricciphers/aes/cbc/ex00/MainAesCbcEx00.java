package com.susanafigueroa.symmetricciphers.aes.cbc.ex00;

import java.security.SecureRandom;
import java.util.Arrays;

public class MainAesCbcEx00 {
    public static void main(String[] args) throws Exception {

        // creación objeto SecureRandom para generar valores aleatorios seguros
        SecureRandom sr = new SecureRandom();

        // AES puede tener key de 16bytes, 24bytes o 32bytes
        byte[] key = new byte[32];
        // genero key random de 32bytes
        sr.nextBytes(key);

        // initVector tiene que tener el length igual al bloque de cifrado del algoritmo de cifrado
        // en este caso usaré AES -> siempre tiene bloque de cifrado de 16bytes
        // initVector se combinará con los datos del texto plano del primer bloque, por eso el mismo length
        byte[] initVector = new byte[16];
        // genero initVector random de 16 bytes
        sr.nextBytes(initVector);

        // texto plano a cifrar
        String valueToEncode = "Hola que tal";

        AesCbcEx00 obj = new AesCbcEx00();
        // encripto usando la key random generada, el initVector generado y lo que quiero cifrar
        String encryptedBase64 = obj.encrypt(key, initVector, valueToEncode);

        System.out.println("Texto plano a cifrar: " + valueToEncode);
        System.out.println("Key de 32 bytes generada: " + Arrays.toString(key));
        System.out.println("initVector de 16bytes generado: " + Arrays.toString(initVector));

        System.out.println("Texto plano cifrado: " + encryptedBase64);
    }
}
