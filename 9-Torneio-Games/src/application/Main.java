package application;

import entities.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Tournament tournament;

        System.out.println("--- TOURNAMENT REGISTRATION ---");
        System.out.print("Enter tournament name: ");
        String tournamentName = sc.nextLine();
        System.out.print("Enter registration fee per team: ");
        double registrationFee = sc.nextDouble();
        System.out.print("Is the tournament Local (1) or Major (2)? ");
        char ch = sc.next().charAt(0);

        if (ch == '1') {
            tournament = new LocalTournament(tournamentName, registrationFee);
        } else {
            tournament = new MajorTournament(tournamentName, registrationFee);
        }

        System.out.print("\nHow many teams do you want to register? ");
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            System.out.println("\n--- TEAM " + i + " REGISTRATION ---");
            System.out.print("Team name: ");
            sc.nextLine();
            String teamName = sc.nextLine();
            System.out.print("Team tag: ");
            String teamTag = sc.nextLine();
            Team team = new Team(teamName, teamTag);

            System.out.print("How many players does this team have? ");
            int p = sc.nextInt();

            for (int o = 1; o <= p; o++) {
                System.out.println("\nPlayer " + o + " Data:");
                System.out.print("Nickname: ");
                sc.nextLine();
                String nickName = sc.nextLine();
                System.out.print("Role: ");
                String role = sc.nextLine();
                System.out.print("Skill level: ");
                int level = sc.nextInt();
                Player player = new Player(nickName, role, level);
                team.addPlayer(player);
            }
            tournament.addTeam(team);
        }

        System.out.println(tournament.reportTournament());


        sc.close();
    }
}
