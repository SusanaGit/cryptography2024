package com.susanafigueroa.bidirectional.symmetricciphers.escitala;

public class Escitala {

    public String encrypt(int numberRows, String messageToEncrypt) {

        int numberCols = (int) Math.ceil((double)messageToEncrypt.length() / numberRows);

        String[][] matrix = new String[numberRows][numberCols];

        int indexLetter = 0;

        for(int numberRow = 0; numberRow < numberRows; numberRow++) {
            for(int numberCol = 0; numberCol < numberCols; numberCol++) {
                if(indexLetter < messageToEncrypt.length()) {
                    matrix[numberRow][numberCol] = String.valueOf(messageToEncrypt.charAt(indexLetter++));
                } else {
                    matrix[numberRow][numberCol] = " ";
                }
            }
        }

        System.out.println("Before encryption: ");
        for(int numberRow = 0; numberRow < numberRows; numberRow++) {
            for(int numberCol = 0; numberCol < numberCols; numberCol++) {
                System.out.print(matrix[numberRow][numberCol]);
            }
            System.out.println();
        }

        StringBuilder messageEncrypted = new StringBuilder();

        for(int numberCol = 0; numberCol < numberCols; numberCol++) {
            for(int numberRow = 0; numberRow < numberRows; numberRow++) {
                messageEncrypted.append(matrix[numberRow][numberCol]);
            }
        }

        System.out.println("Encrypted message: " + messageEncrypted);

        return messageEncrypted.toString();
    }

    public String decrypt(int numberRows, String messageToDecrypt) {

        int numberCols = (int) Math.ceil((double)messageToDecrypt.length() / numberRows);

        String[][] matrix = new String[numberRows][numberCols];

        int indexLetter = 0;

        for(int numberCol = 0; numberCol < numberCols; numberCol++) {
            for(int numberRow = 0; numberRow < numberRows; numberRow++) {
                if(indexLetter < messageToDecrypt.length()) {
                    matrix[numberRow][numberCol] = String.valueOf(messageToDecrypt.charAt(indexLetter++));
                } else {
                    matrix[numberRow][numberCol] = " ";
                }
            }
        }

        System.out.println("Before decryption: ");
        for(int numberRow = 0; numberRow < numberRows; numberRow++) {
            for(int numberCol = 0; numberCol < numberCols; numberCol++) {
                System.out.print(matrix[numberRow][numberCol]);
            }
            System.out.println();
        }

        StringBuilder messageDecrypted = new StringBuilder();

        for(int numberRow = 0; numberRow < numberRows; numberRow++) {
            for(int numberCol = 0; numberCol < numberCols; numberCol++) {
                messageDecrypted.append(matrix[numberRow][numberCol]);
            }
        }

        System.out.println("Decrypted message: " + messageDecrypted);

        return messageDecrypted.toString();
    }

}
