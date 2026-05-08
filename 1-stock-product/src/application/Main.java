package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Product product;

        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product ID: ");
        int codeProduct = sc.nextInt();
        System.out.print("Want to enter the price?(y/n): ");
        char optionPrice = sc.next().charAt(0);

        if (optionPrice == 'y') {
            System.out.print("Enter product price: ");
            double priceProduct = sc.nextDouble();
            product = new Product(name, codeProduct, priceProduct);
        } else {
            product = new Product(name, codeProduct);
        }

        System.out.println();
        System.out.println("Product data:");
        System.out.println(product);

        System.out.print("Enter the quantity to add in stock: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);
        System.out.println("Updated product: " + product);

        System.out.print("Enter the quantity to remove: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);
        System.out.println("Updated product: " + product);

        System.out.print("Enter the percentage for add in price: ");
        double percentage = sc.nextDouble();
        product.priceAdd(percentage);
        System.out.println("Updated product: " + product);
        System.out.printf("Total price: $ %.2f", product.totalPriceQuantity());
        sc.close();
    }
}
