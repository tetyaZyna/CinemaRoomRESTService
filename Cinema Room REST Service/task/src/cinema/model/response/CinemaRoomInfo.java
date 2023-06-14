package cinema.model.response;

import java.util.List;

public record CinemaRoomInfo (
        int totalRows,
        int totalColumns,
        List<Ticket> availableSeats
) {}