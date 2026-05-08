package entities;

public class Client {
    private final int SSN;
    private String name;
    private String email;

    //Builder
    public Client(int ssn, String name, String email) {
        this.SSN = ssn;
        this.name = name;
        this.email = email;
    }

    //Getter and setters

    public int getSSN() {
        return SSN;
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

    public String toString() {
        return String.format("Client: %s%n" +
                "SSN: %d%n" +
                "Email: %s", name, SSN, email);
    }
}
