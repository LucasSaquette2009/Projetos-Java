package entities;

public class Product {
    private String nameProduct;
    private final int codeProduct;
    private double priceProduct;
    private int quantityProduct;

    //Builders
    public Product(String nameProduct, int codeProduct, double priceProduct) {
        this.nameProduct = nameProduct;
        this.codeProduct = codeProduct;
        this.priceProduct = priceProduct;
    }

    public Product(String nameProduct, int codeProduct) {
        this.nameProduct = nameProduct;
        this.codeProduct = codeProduct;
    }

    //Getters and setters
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    //Methods
    public void addProducts(int quantity) {
        this.quantityProduct += quantity;
    }

    public void removeProducts(int quantity) {
        this.quantityProduct -= quantity;
    }

    public void priceAdd(double percentage) {
        this.priceProduct += (this.priceProduct * (percentage / 100));
    }

    public double totalPriceQuantity() {
        return priceProduct * quantityProduct;
    }

    //toString
    public String toString() {
        return String.format("%s, Code %d, Price: $ %.2f, Quantity: %d units%n",
                nameProduct, codeProduct, priceProduct, quantityProduct);
    }
}
