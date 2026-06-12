package entities;

public class CorporateSubscription extends Subscription {

    private Integer employeeCount;
    private static final Double MIN_PRICE = 50.00;

    public CorporateSubscription() {
    }

    public CorporateSubscription(String clientName, String accountCode, Double basePrice, Integer employeeCount) {
        super(clientName, accountCode, basePrice);
        this.employeeCount = employeeCount;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public Double netPrice() {
        double finalPrice = basePrice - (employeeCount * 5);
        return Math.max(MIN_PRICE, finalPrice);
    }

    @Override
    public String subscriptionReport() {
        return String.format("%s (Code: %s) - Corporate (%d Employees) - Total: $ %.2f",
                getClientName(), getAccountCode(), employeeCount, netPrice());
    }
}
