package entities;

public class FirstClassTicket extends Ticket {

    private static final Double premiumServiceFee = 150.00;

    public FirstClassTicket() {
    }

    public FirstClassTicket(String passengerName, String seatNumber, Double basePrice) {
        super(passengerName, seatNumber, basePrice);
    }

    public static Double getPremiumServiceFee() {
        return premiumServiceFee;
    }

    @Override
    public String ticketInfo() {
        double finalPrice = basePrice + premiumServiceFee + (basePrice * 0.10);

        return String.format("%s (First Class) (Seat %s) - $ %.2f", getPassengerName(), getSeatNumber(), finalPrice);
    }
}
