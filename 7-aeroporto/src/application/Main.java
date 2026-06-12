package application;

import entities.FirstClassTicket;
import entities.OvernightTicket;
import entities.Ticket;
import entities.TicketManager;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        TicketManager manager = new TicketManager();

        System.out.print("Enter the number of tickets: ");
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            System.out.println();
            System.out.println("Ticket #" + i + " data:");
            System.out.print("Regular, overnight or first class (r/o/f)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Passenger name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Seat number: ");
            String seatNumber = sc.nextLine();
            System.out.print("Base price: ");
            double basePrice = sc.nextDouble();

            if (Character.toLowerCase(ch) == 'r') {
                manager.addTicket(new Ticket(name, seatNumber, basePrice));
            } else if (Character.toLowerCase(ch) == 'o') {
                System.out.printf("Discount: %.2f%n", OvernightTicket.getDiscount());
                manager.addTicket(new OvernightTicket(name, seatNumber, basePrice));
            } else {
                System.out.printf("Premium service fee: %.2f%n", FirstClassTicket.getPremiumServiceFee());
                manager.addTicket(new FirstClassTicket(name, seatNumber, basePrice));
            }
        }

        System.out.println();
        System.out.println("TICKET INFOS:");
        manager.printInfo();

        sc.close();
    }
}
