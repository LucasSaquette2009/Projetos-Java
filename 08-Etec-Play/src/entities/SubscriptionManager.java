package entities;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionManager {


    private final List<Subscription> subscriptions = new ArrayList<>();

    public SubscriptionManager() {
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
    }

    public void printReports() {
        for (Subscription s : subscriptions) {
            System.out.println(s.subscriptionReport());
        }
    }

    public Double totalRevenue() {
        double sum = 0.0;

        for (Subscription s : subscriptions) {
            sum += s.netPrice();
        }
        return sum;
    }
}
