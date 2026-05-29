package application;

import entities.Account;
import entities.Bank;
import entitiesEnums.BankStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();
        bank.setStatus(BankStatus.NULL);

        DateTimeFormatter ftmBirthDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int option;
        int id;
        int position;

        do {
            System.out.println("""
                    -----------------------
                    BANK MENU (ADM ACESS!!)
                    
                    [1] - Register user
                    [2] - Remove user
                    [3] - Rename user
                    [4] - Add balance for user
                    [5] - Remove balance of user
                    [6] - Transferring money
                    [7] - Show users
                    [0] - Exit
                    """);
            System.out.print("Select an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    bank.setStatus(BankStatus.CREATE);
                    System.out.println("-----------------------");
                    System.out.println("REGISTER USER:");
                    System.out.print("ID: ");
                    id = sc.nextInt();

                    if (bank.idExist(id)) {
                        System.out.println("User already register!");
                    } else {
                        System.out.print("Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Birth date (DD/MM/YYYY): ");
                        LocalDate birthDate = LocalDate.parse(sc.next(), ftmBirthDate);
                        System.out.print("Balance: ");
                        double balance = sc.nextDouble();
                        System.out.println("User registered, thanks!!");

                        Account account = new Account(id, name, email, birthDate, balance);
                        bank.addAccount(account);
                    }
                    break;

                case 2:
                    if (bank.isEmpty()) {
                        System.out.println("No accounts registered");
                    } else {
                        bank.setStatus(BankStatus.REMOVING);
                        System.out.println("-----------------------");
                        System.out.println("REMOVE USER:");
                        System.out.print("Id of user: ");
                        id = sc.nextInt();

                        if (bank.removeAccount(id)) {
                            System.out.println("Account removed, thanks!!");
                        } else {
                            System.out.println("Account not found");
                        }
                    }

                    break;

                case 3:
                    if (bank.isEmpty()) {
                        System.out.println("No accounts registered");
                    } else {
                        bank.setStatus(BankStatus.RENAME);
                        System.out.println("-----------------------");
                        System.out.println("RENAME USER:");
                        System.out.print("Id of user: ");
                        id = sc.nextInt();

                        if (bank.idExist(id)) {
                            position = bank.positionId(id);
                            System.out.println("Current name: " + bank.getAccountList().get(position).getName());
                            System.out.print("New name: ");
                            sc.nextLine();
                            String newName = sc.nextLine();
                            bank.renameAccount(id, newName);
                            System.out.println("Rename succeeded, thanks!!");
                        } else {
                            System.out.println("User not found!");
                        }
                    }
                    break;

                case 4:
                    if (bank.isEmpty()) {
                        System.out.println("No accounts registered");
                    } else {
                        bank.setStatus(BankStatus.ADD_MONEY);
                        System.out.println("-----------------------");
                        System.out.println("ADD BALANCE FOR USER:");
                        System.out.print("Id of user: ");
                        id = sc.nextInt();

                        if (bank.idExist(id)) {
                            position = bank.positionId(id);
                            System.out.printf("Current balance: %.2f%n", bank.getAccountList().get(position).getBalance());
                            System.out.print("Balance of add: ");
                            double balance = sc.nextDouble();
                            bank.addBalance(id, balance);
                            System.out.println("Balance add, thanks!!");
                        } else {
                            System.out.println("Account not found!");
                        }
                    }
                    break;

                case 5:
                    if (bank.isEmpty()) {
                        System.out.println("No accounts registered");
                    } else {
                        bank.setStatus(BankStatus.REMOVE_MONEY);
                        System.out.println("-----------------------");
                        System.out.println("REMOVE BALANCE OF USER:");
                        System.out.print("Id of user: ");
                        id = sc.nextInt();

                        if (bank.idExist(id)) {
                            position = bank.positionId(id);
                            System.out.printf("Current balance: %.2f%n", bank.getAccountList().get(position).getBalance());
                            System.out.print("Balance of remove: ");
                            double balance = sc.nextDouble();

                            if (bank.removeBalance(id, balance)) {
                                System.out.println("Balance removed, thanks!!");
                            } else {
                                System.out.println("Lower balance!");
                            }
                        } else {
                            System.out.println("Account not found!");
                        }
                    }
                    break;
                case 6:
                    if (bank.getAccountList().size() >= 2) {
                        bank.setStatus(BankStatus.TRANSFER);
                        System.out.println("-----------------------");
                        System.out.println("TRANSFER BALANCE BETWEEN USERS:");
                        System.out.print("Id of what will be transferred: ");
                        id = sc.nextInt();
                        System.out.print("ID of what you will receive: ");
                        int idReceive = sc.nextInt();

                        if (bank.idExist(id) && bank.idExist(idReceive) && id != idReceive) {
                            position = bank.positionId(id);
                            System.out.printf("Balance of Id #%d: %.2f%n", id, bank.getAccountList().get(position).getBalance());
                            position = bank.positionId(idReceive);
                            System.out.printf("Balance of Id #%d: %.2f%n", idReceive, bank.getAccountList().get(position).getBalance());
                            System.out.print("Balance for transfer: ");
                            double balance = sc.nextDouble();

                            if (bank.transferBalance(id, idReceive, balance)) {
                                System.out.println("Transfer succeeded, thanks!!");
                            } else {
                                System.out.println("Lower balance!");
                            }
                        } else {
                            System.out.println("Account not found");
                        }
                    } else {
                        System.out.println("No accounts registered");
                    }
                    break;

                case 7:
                    if (bank.isEmpty()) {
                        System.out.println("No accounts registered");
                    } else {
                        System.out.println(bank);
                    }
                    break;
            }
        } while (option != 0);

        sc.close();
    }
}
