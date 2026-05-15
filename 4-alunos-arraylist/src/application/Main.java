package application;

import entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Student> list = new ArrayList<>();

        int howMany;
        System.out.print("How many students  will be registered? ");
        howMany = sc.nextInt();

        for (int i = 0; i < howMany; i++) {
            System.out.printf("Student #%d:%n", i + 1);
            System.out.print("Id: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Grade: ");
            double grade = sc.nextDouble();

            Student student = new Student(id, name, grade);
            list.add(student);
        }

        System.out.print("Enter the student id to update grade: ");
        int idUpdate = sc.nextInt();
        Integer idPosition = Student.idPosition(list, idUpdate);

        if (idPosition == null) {
            System.out.println("Student not exist!");
        } else {
            System.out.print("Enter the new grade: (0-10): ");
            double newGrade = sc.nextDouble();
            list.get(idPosition).addGrade(newGrade);
        }

        System.out.print("Enter the student id to remove: ");
        idUpdate = sc.nextInt();
        idPosition = Student.idPosition(list, idUpdate);

        if (idPosition == null) {
            System.out.println("Student not exist!");
        } else {
            System.out.printf("%s removed%n", list.get(idPosition).getName());
            list.remove(idPosition.intValue());
        }

        System.out.println("--------------------");

        System.out.println("List of Students:");
        for (Student stu : list) {
            System.out.println(stu);
        }


        sc.close();
    }
}
