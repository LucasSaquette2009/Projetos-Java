package application;

import entities.Product;
import service.ProductService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many products do you want to register? ");
        int howMany = sc.nextInt();

        Product[] vect = new Product[howMany];

        for (int i = 0; i < howMany; i++) {
            sc.nextLine();
            System.out.printf("Product data #%d:%n", i+1);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.println("===================");

            vect[i] = new Product(name, price);
        }

        System.out.println("\nList of products:");
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] != null) {
                System.out.println(vect[i]);
            }
        }

        System.out.println("===================");
        System.out.printf("\nAverage price: $ %.2f%n", ProductService.averagePrice(vect));
        System.out.printf("Expensive Product: %s", ProductService.expensiveProduct(vect));

        sc.close();
    }
}
