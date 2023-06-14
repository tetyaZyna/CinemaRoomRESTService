package cinema.mapper;

import cinema.model.response.Seat;
import cinema.model.response.Ticket;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Seat toSeat(Ticket ticket) {
        return new Seat(ticket.row(), ticket.column());
    }
}
