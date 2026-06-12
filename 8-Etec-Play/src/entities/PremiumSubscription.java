package entities;

public class PremiumSubscription extends Subscription {

    private Integer extraScreens;
    private static final Double SCREEN_PRICE = 15.00;

    public PremiumSubscription() {
    }

    public PremiumSubscription(String clientName, String accountCode, Double basePrice, Integer extraScreens) {
        super(clientName, accountCode, basePrice);
        this.extraScreens = extraScreens;
    }

    public Integer getExtraScreens() {
        return extraScreens;
    }

    @Override
    public Double netPrice() {
        return basePrice + (extraScreens * SCREEN_PRICE) + (basePrice * 0.05);
    }

    @Override
    public String subscriptionReport() {
        int totalScreens = extraScreens + 1;

        return String.format("%s (Code: %s) - %d Screens (4K) - Total: $ %.2f"
                , getClientName(), getAccountCode(), totalScreens, netPrice());
    }
}
