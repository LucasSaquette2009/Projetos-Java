package util;

import java.util.Scanner;

public class ProductValidation {

    //Methods of product validation
    public static boolean isValidId(int id) {
        return id > 0;
    }

    public static int readValidId(Scanner sc) {
        int id = sc.nextInt();
        while (!isValidId(id)) {
            System.out.println("Invalid ID!!");
            System.out.print("Product ID: ");
            id = sc.nextInt();
        }
        return id;
    }

    public static String readValidName(Scanner sc) {
        String nameProduct = sc.nextLine();
        while (!Validator.isValidName(nameProduct)) {
            System.out.println("Invalid name!!");
            System.out.print("Product name: ");
            nameProduct = sc.nextLine();
        }
        return nameProduct;
    }

    public static Double readValidPrice(Scanner sc) {
        double price = sc.nextDouble();
        while (!Validator.isPositive(price)) {
            System.out.println("Invalid price!!");
            System.out.print("Product price: ");
            price = sc.nextDouble();
        }
        return price;
    }

    public static int readValidQuantity(Scanner sc) {
        int quantity = sc.nextInt();
        while (!Validator.isPositive(quantity)) {
            System.out.println("Invalid quantity!!");
            System.out.print("Product quantity: ");
            quantity = sc.nextInt();
        }
        return quantity;
    }

}
