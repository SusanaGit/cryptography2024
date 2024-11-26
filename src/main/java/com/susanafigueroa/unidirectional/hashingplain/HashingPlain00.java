package com.susanafigueroa.unidirectional.hashingplain;

/*
Calculate the hash of the pom.xml file using the SHA-256 algorithm.
 */

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPlain00 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // create a MessageDigest object
        // we use MessageDigest because this class generates crypto hashes
        // procesará los fragmentos de datos (en forma de bytes) que le proporcione
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // path del archivo que del que quiero obtener el hash
        String basePath = System.getProperty("user.dir") + File.separator;
        String nameFile = "pom.xml";
        File file = new File(basePath + nameFile);

        if (file.exists()) {
            System.out.println("The file exists.");

            // abro el archivo como un InputStream
            InputStream in = new FileInputStream(file);

            // área temporal de almacenamiento de hasta 1024bytes
            // usando un buffer puedo trabajar con bloques de datos en vez de procesar el archivo completo
            final byte[] buffer = new byte[1024];

            // bytesRead -> bytes leídos del archivo, si es + significa que ha rellenado el buffer y por tanto hay datos del archivo para leer
            // bytesRead -> si es -1 indica que ya no hay datos del archivo para leer
            // .read(buffer) -> intenta llenar el buffer con los datos del archivo, pero solo hasta 1024bytes del archivo
            // las llamadas sucesivas a .read van devolviendo 1024 sucesivamente hasta que ya no quedan más datos del archivo para leer, y devuelve -1
            int bytesRead = 0;
            // hago llamadas sucesivas a read
            // en cada iteración read llena el buffer con datos del archivo en bytes
            while ((bytesRead = in.read(buffer)) != -1) {
                // quiero que md procese los datos del buffer en cada iteración y se vaya actualizando
                md.update(buffer, 0, bytesRead);
            }

            // obtengo el hash en byte[]
            final byte[] hashedBytes = md.digest();

            // convierto a hexadecimal el array de bytes que contiene el hash
            StringBuilder hashEx = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                System.out.println("byte: " + hashedByte);
                int hashedInt = hashedByte & 0xFF;
                String hashedString = Integer.toHexString(hashedInt);
                System.out.println("hex: " + hashedString);
                hashEx.append(hashedString);
            }

            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<< HASH >>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(hashEx);

        } else {
            System.out.println("The file doesn't exist.");
        }
    }
}
