package entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Account {

    private Integer id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private int age;
    private Double balance;

    private final LocalDate dateNow = LocalDate.now();
    private final DateTimeFormatter fmtBirthDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Account() {
    }

    public Account(Integer id, String name, String email, LocalDate birthDate, Double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.balance = balance;

        this.age = Period.between(birthDate, dateNow).getYears();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("----------------------\n");

        sb.append("Id: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Birth date: ").append(fmtBirthDate.format(birthDate)).append("\n");
        sb.append("Age: ").append(age).append("\n");
        sb.append("Balance: ").append(String.format("%.2f", balance)).append("\n");

        return sb.toString();
    }
}
