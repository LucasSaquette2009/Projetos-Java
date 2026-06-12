package entities;

public class Ticket {

    private String passengerName;
    private String seatNumber;
    protected Double basePrice;

    public Ticket() {
    }

    public Ticket(String passengerName, String seatNumber, Double basePrice) {
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.basePrice = basePrice;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public String ticketInfo() {
        return String.format("%s (Seat %s) - $ %.2f", passengerName, seatNumber, basePrice);
    }
}
