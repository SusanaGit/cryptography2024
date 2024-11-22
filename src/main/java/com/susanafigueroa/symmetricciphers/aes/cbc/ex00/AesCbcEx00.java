package com.susanafigueroa.symmetricciphers.aes.cbc.ex00;

/*
Algoritmo AES (Advanced Encryption Standard)
Modo CBC (Cipher Block Chaining)

Encripta la frase: "Hola que tal" y desencríptala
 */

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesCbcEx00 {

    private static final String ALGORITHM = "AES";

    // AES -> algoritmo de cifrado
    // CBC -> modo de operación , requiere de IV para hacer el cifrado más seguro
    // PKCS5PADDING -> esquema que agrega relleno si el texto no es múltiplo de 16bytes
    private static final String CIPHER = "AES/CBC/PKCS5PADDING";

    private static final String valueToEncode = "Hola que tal";

    public static String encrypt(byte[] key, byte[] initVector, String valueToEncode) throws Exception {
        String textEncoded = "";

        // objeto IvParameterSpec que encapsula el IV para que pueda usarse en el cifrado
        IvParameterSpec iv = new IvParameterSpec(initVector);

        // encapsulo la key para que el objeto Cipher la pueda usar
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);

        // configuro el objeto Cipher y lo inicializo
        Cipher cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);

        return textEncoded;
    }

}
