package application;

import entities.Client;
import entities.Product;
import util.ClientValidation;
import util.ProductValidation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Client client = null;
        Product product = null;

        //variables
        int menuOption;

        do {
            System.out.print("""
                    ========================
                        Store Menu
                    Choice one option:
                    [1] - Client registration
                    [2] - Product registration
                    [3] - Product change
                    [4] - List Client
                    [5] - List Product
                    [0] - Finish
                    """);
            System.out.print("Choice: ");
            menuOption = sc.nextInt();

            switch (menuOption) {
                case 1: //Client
                    sc.nextLine();
                    System.out.println("========================");
                    System.out.print("Client name: ");
                    String nameClient = ClientValidation.readValidName(sc);

                    System.out.print("Client SSN: ");
                    int ssn = ClientValidation.readValidSsn(sc);

                    sc.nextLine();
                    System.out.print("Client email: ");
                    String email = ClientValidation.readValidEmail(sc);

                    System.out.println("Registered client!");
                    client = new Client(ssn, nameClient, email);
                    break;

                case 2: //Product
                    System.out.println("========================");
                    System.out.print("Product ID: ");
                    int id = ProductValidation.readValidId(sc);

                    sc.nextLine();
                    System.out.print("Product name: ");
                    String nameProduct = ProductValidation.readValidName(sc);

                    System.out.print("Want enter price?(y/n): ");
                    char optionPrice = sc.next().charAt(0);

                    if (Character.toLowerCase(optionPrice) == 'y') {
                        System.out.print("Enter price: ");
                        double price = ProductValidation.readValidPrice(sc);
                        product = new Product(id, nameProduct, price);
                    } else {
                        product = new Product(id, nameProduct);
                    }
                    System.out.println("Registered Product!!");
                    break;

                case 3: //Product change
                    if (product == null) {
                        System.out.println("Error, No product registered!");
                    } else {
                        System.out.println("========================");
                        System.out.println(product);

                        System.out.print("Enter value to add stock: ");
                        int addQuantity = ProductValidation.readValidQuantity(sc);
                        product.addStock(addQuantity);
                        System.out.println(product);

                        System.out.print("Enter value to remove stock: ");
                        int removeQuantity = ProductValidation.readValidQuantity(sc);
                        product.removeStock(removeQuantity);
                        System.out.println(product);

                        System.out.print("Enter price to add in product: ");
                        double addPrice = ProductValidation.readValidPrice(sc);
                        product.addPrice(addPrice);
                        System.out.println(product);

                        System.out.print("Enter price to remove in product: ");
                        double removePrice = ProductValidation.readValidPrice(sc);
                        product.removePrice(removePrice);
                        System.out.println("========================");
                        System.out.println("Changed product!");
                        System.out.println(product);
                        System.out.print("Click enter to go the menu: ");
                        sc.nextLine();sc.nextLine();
                    }
                    break;

                case 4: //List client
                    if (client == null) {
                        System.out.println("Error, No client registered!");
                    } else {
                        System.out.println("========================");
                        System.out.println(client);
                        System.out.print("Click enter to go the menu: ");
                        sc.nextLine();
                        sc.nextLine();
                    }
                    break;

                case 5: //List product
                    if (product == null) {
                        System.out.println("Error, no product registered!");
                    } else {
                        System.out.println("========================");
                        System.out.println(product);
                        System.out.print("Click enter to go menu: ");
                        sc.nextLine();
                        sc.nextLine();
                    }
                    break;

                case 0: //Closing
                    System.out.println("Closing..");
                    break;

                default:
                    break;
            }
        } while (menuOption != 0);

        sc.close();
    }
}
