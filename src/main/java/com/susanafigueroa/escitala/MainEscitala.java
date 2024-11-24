package com.susanafigueroa.escitala;

import java.util.Scanner;

public class MainEscitala {

    public static void main(String[] args) {

        MainEscitala main = new MainEscitala();
        main.menu();

    }

    public void menu() {

        Scanner keyboard = new Scanner(System.in);

        Escitala escitala = new Escitala();

        while(true) {
            System.out.println("What do you want to do?");
            System.out.println("x -> encrypt");
            System.out.println("d -> decrypt");
            System.out.println("s -> finish the program");
            String optionSelected = keyboard.nextLine();

            switch(optionSelected) {

                case "x":

                    selectedX(keyboard, escitala);
                    break;

                case "d":
                    selectedD(keyboard, escitala);
                    break;

                case "s":
                    System.out.println("Have a nice day. Byebye.");
                    System.exit(0);

                default:
                    System.out.println("Your selected option isn't a correct option.");
                    System.out.println("Please, choose a valid option.");
            }
        }
    }

    public void selectedX(Scanner keyboard, Escitala escitala){

        int numberRows = enterNumberRows(keyboard);

        System.out.println("Write the message to encrypt: ");
        String messageToEncrypt = keyboard.nextLine();

        escitala.encrypt(numberRows, messageToEncrypt);

    }

    public void selectedD(Scanner keyboard, Escitala escitala) {

        int numberRows = enterNumberRows(keyboard);

        System.out.println("Write the message to decrypt: ");
        String messageToDecrypt = "AACSNIICTCOAINLFLARAAEBS";

        System.out.println("Message decrypted: ");

    }

    public int enterNumberRows(Scanner keyboard) {
        boolean isInteger = false;
        int numberRows = 0;

        while(!isInteger) {
            System.out.println("Enter the number of rows: ");
            String numberRowsInput = keyboard.nextLine();

            try {
                numberRows = Integer.parseInt(numberRowsInput);
                isInteger = true;
            } catch (Exception e) {
                System.out.println("Your number of rows isn't an integer.");
            }
        }

        return numberRows;
    }

}
