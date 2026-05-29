package service;

import entities.Product;

public class ProductService {

    //Methods
    public static double averagePrice(Product[] vect) {
        double sum = 0;
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] != null) {
                sum += vect[i].getPrice();
            }
        }
        return sum / vect.length;
    }

    public static String expensiveProduct(Product[] vect) {
        double maxPrice = -1.0;
        String expensiveName = "";

        for (int i = 0; i < vect.length; i++) {
            if (vect[i] != null) {
                if (vect[i].getPrice() > maxPrice) {
                    maxPrice = vect[i].getPrice();
                    expensiveName = vect[i].getName();
                }
            }
        }
        return expensiveName;
    }
}
