package entities;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private double grade;

    //Builders
    public Student() {
    }

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    //Methods
    public void addGrade(double newGrade) {
        grade = newGrade;
    }

    public static Integer idPosition(List<Student> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

    public String toString() {
        return String.format("ID: %d | Name: %s | Grade: %.2f", id, name, grade);
    }
}
