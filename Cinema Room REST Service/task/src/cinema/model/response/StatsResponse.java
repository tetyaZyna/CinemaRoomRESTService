package cinema.model.response;

import lombok.Builder;

@Builder
public record StatsResponse(
        long currentIncome,
        long numberOfAvailableSeats,
        long numberOfPurchasedTickets
) {}
