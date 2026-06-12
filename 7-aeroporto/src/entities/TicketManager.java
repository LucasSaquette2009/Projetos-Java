package entities;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {

    private final List<Ticket> list = new ArrayList<>();

    public TicketManager() {
    }

    public void addTicket(Ticket ticket) {
        list.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        list.remove(ticket);
    }

    public void printInfo() {
        for (Ticket t : list) {
            System.out.println(t.ticketInfo());
        }
    }
}
