package com.susanafigueroa.bidirectional.symmetricciphers.aes.cbc.ex00;

/*
Algoritmo AES (Advanced Encryption Standard)
Modo CBC (Cipher Block Chaining)

Encripta la frase: "Hola que tal" y desencríptala
 */

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AesCbcEx00 {

    private static final String ALGORITHM = "AES";

    // AES -> algoritmo de cifrado simétrico
    // CBC -> modo de operación , requiere vector de inicialización IV para hacer el cifrado más seguro
    // PKCS5PADDING -> esquema que agrega relleno si el texto no es múltiplo de 16bytes
    private static final String CIPHER = "AES/CBC/PKCS5PADDING";

    public String encrypt(byte[] key, byte[] initVector, String planeTextToEncrypt) throws Exception {

        // objeto IvParameterSpec que encapsula el IV requerido por el modo CBC de AES
        IvParameterSpec iv = new IvParameterSpec(initVector);

        // encapsulo la key para que el algoritmo AES pueda usarla
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);

        // configuro el objeto Cipher
        Cipher cipherEncrypt = Cipher.getInstance(CIPHER);

        // lo inicializo en modo de cifrado ENCRYPT_MODE con la key y el IV
        cipherEncrypt.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);

        // convierto el planeTextToEncrypt a array de bytes - el algoritmo solo entiende el valor en bytes
        byte[] plainTextBytes = planeTextToEncrypt.getBytes("UTF-8");

        // cifro los bytes mediante el cipherEncrypt que configuré antes
        // obtengo array de bytes cifrados
        // el IV se combina con el primer bloque del texto plano para producir el primer bloque cifrado
        byte[] encrypted = cipherEncrypt.doFinal(plainTextBytes);

        // convierto el texto cifrado (en formato binario) a representación Base64 para poder leerlo
        // la codificación Base64 facilita el transporte o almacenamiento de los datos cifrados
        String encryptedBase64 = Base64.getEncoder().encodeToString(encrypted);

        return encryptedBase64;
    }

    public String decrypt(byte[] key, byte[] initVector, String encryptedBase64) throws Exception {

        // objeto IvParameterSpec que encapsula el IV requerido por el modo CBC de AES
        IvParameterSpec iv = new IvParameterSpec(initVector);

        // encapsulo la key para que el algoritmo AES pueda usarla
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);

        // configuro el objeto Cipher
        Cipher cipherDecrypt = Cipher.getInstance(CIPHER);

        // lo inicializo con el modo de cifrado DECRYPT_MODE con la key y el iv
        cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

        // convierte el texto en representación Base64 de nuevo a su forma original de array de bytes binarios
        // encryptedBase64 no es texto plano, es representación codificada en Base64 de los datos cifrados
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);

        // descifra los bytes usando el objeto cipherDecrypt configurado anteriormente
        // El primer bloque del texto cifrado se descifra y luego se combina con el mismo IV usado durante el cifrado
        // para recuperar el primer bloque de texto plano
        byte[] decryptedBytes = cipherDecrypt.doFinal(encryptedBytes);

        // convierto el texto descifrado (en formato binario) a texto plano (String)
        String original = new String(decryptedBytes);

        return original;
    }

}
