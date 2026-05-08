package util;

import java.util.Scanner;

public class ClientValidation {

    //Methods of client validation
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean isValidSsn(int ssn) {
        return ssn > 0;
    }

    public static String readValidName(Scanner sc) {
        String nameClient = sc.nextLine();
        while(!Validator.isValidName(nameClient)) {
            System.out.println("Invalid name!!");
            System.out.print("Client name: ");
            nameClient = sc.nextLine();
        }
        return nameClient;
    }

    public static int readValidSsn(Scanner sc) {
        int ssn = sc.nextInt();
        while(!isValidSsn(ssn)) {
            System.out.println("Invalid SSN!!");
            System.out.print("Client SSN: ");
            ssn = sc.nextInt();
        }
        return ssn;
    }

    public static String readValidEmail(Scanner sc) {
        String email = sc.nextLine();
        while(!isValidEmail(email)) {
            System.out.println("Invalid email!!");
            System.out.print("Client email: ");
            email = sc.nextLine();
        }
        return email;
    }

}
