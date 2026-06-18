package application;

import entities.CorporateSubscription;
import entities.PremiumSubscription;
import entities.Subscription;
import entities.SubscriptionManager;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SubscriptionManager manager = new SubscriptionManager();

        System.out.print("Enter the number of subscriptions: ");
        int s = sc.nextInt();

        for (int i = 1; i <= s; i++) {
            System.out.println();
            System.out.println("Subscription #" + i + " data:");
            System.out.print("Standard, Premium or Corporate (s/p/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Client name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Account code: ");
            String code = sc.nextLine();
            System.out.print("Base price: ");
            double price = sc.nextDouble();

            if (Character.toLowerCase(ch) == 's') {
                manager.addSubscription(new Subscription(name, code, price));
            } else if (Character.toLowerCase(ch) == 'p') {
                System.out.print("Number of extra screens: ");
                int extraScreens = sc.nextInt();

                manager.addSubscription(new PremiumSubscription(name, code, price, extraScreens));
            } else {
                System.out.print("Number of employees: ");
                int employees = sc.nextInt();

                manager.addSubscription(new CorporateSubscription(name, code, price, employees));
            }
        }

        System.out.println("\nSUBSCRIPTION REPORTS:");
        manager.printReports();
        System.out.printf("\nTOTAL REVENUE OF PLATFORM: %.2f", manager.totalRevenue());

        sc.close();
    }
}
