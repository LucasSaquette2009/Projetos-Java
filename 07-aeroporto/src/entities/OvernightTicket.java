package entities;

public class OvernightTicket extends Ticket {

    private static final Double discount = 40.00;

    public OvernightTicket() {
    }

    public OvernightTicket(String passengerName, String seatNumber, Double basePrice) {
        super(passengerName, seatNumber, basePrice);
    }

    public static Double getDiscount() {
        return discount;
    }

    @Override
    public String ticketInfo() {
        double finalPrice = basePrice - discount;

        return String.format("%s (Overnight) (Seat %s) - $ %.2f", getPassengerName(), getSeatNumber(), finalPrice);
    }
}
