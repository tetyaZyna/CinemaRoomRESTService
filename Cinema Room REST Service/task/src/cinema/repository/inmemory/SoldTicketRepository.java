package cinema.repository.inmemory;

import cinema.model.SoldTicket;
import cinema.model.response.Ticket;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class SoldTicketRepository implements cinema.repository.SoldTicketRepository {
    Map<String, Ticket> soldTickets = new HashMap<>();

    public void add(SoldTicket soldTicket) {
        soldTickets.put(
                soldTicket.token(),
                soldTicket.ticket());
    }

    public int totalIncome() {
        return soldTickets.values().stream()
                .mapToInt(Ticket::price)
                .sum();
    }

    public Optional<Ticket> delete(String token) {
        return Optional.ofNullable(soldTickets.remove(token));
    }

    public long count() {
        return soldTickets.size();
    }
}
