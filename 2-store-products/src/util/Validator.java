package util;

public class Validator {

    //Methods validator
    public static boolean isValidName(String name) {
        return name != null && name.trim().length() >=3;
    }

    public static boolean isPositive(double price) {
        return price >= 0;
    }

}
