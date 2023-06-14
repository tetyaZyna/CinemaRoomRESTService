package cinema.model;

import cinema.model.response.Ticket;

public record SoldTicket(
        String token,
        Ticket ticket
) {
}
