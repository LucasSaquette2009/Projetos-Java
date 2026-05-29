package entities;

public class Product {
    private final int ID;
    private String name;
    private double price;
    private int quantity;

    //Builders
    public Product(int id, String name, double price) {
        this.ID = id;
        this.name = name;
        this.price = price;
    }

    public Product(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    //Getters and Setters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    //Methods
    public void addStock(int addQuantity) {
        quantity += addQuantity;
    }

    public void removeStock(int removeQuantity) {
        quantity -= removeQuantity;
    }

    public void addPrice(double addPrice) {
        price += addPrice;
    }

    public void removePrice(double removePrice) {
        price -= removePrice;
    }

    public double totalValue() {
       return price * quantity;
    }

    public String toString() {
        return String.format("Product data:%n" +
                "ID: %d%n" +
                "Name: %s%n" +
                "Price: $ %.2f%n" +
                "Quantity: %d%n" +
                "Total value: $ %.2f%n", ID, name, price, quantity, totalValue());
    }

}
