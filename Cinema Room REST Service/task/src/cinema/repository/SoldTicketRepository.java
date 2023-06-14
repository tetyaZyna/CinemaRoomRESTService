package cinema.repository;

import cinema.model.SoldTicket;
import cinema.model.response.Ticket;
import org.springframework.stereotype.Repository;

import java.util.*;

public interface SoldTicketRepository {
    public void add(SoldTicket soldTicket);

    public int totalIncome();

    public Optional<Ticket> delete(String token);

    public long count();
}
