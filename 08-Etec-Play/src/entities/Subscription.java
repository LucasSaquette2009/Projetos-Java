package entities;

public class Subscription {

    private String clientName;
    private String accountCode;
    protected Double basePrice;

    public Subscription() {
    }

    public Subscription(String clientName, String accountCode, Double basePrice) {
        this.clientName = clientName;
        this.accountCode = accountCode;
        this.basePrice = basePrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public Double netPrice() {
        return basePrice;
    }

    public String subscriptionReport() {
        return String.format("%s (Code: %s) - 1 Screen - Total: $ %.2f", clientName, accountCode, basePrice);
    }
}
