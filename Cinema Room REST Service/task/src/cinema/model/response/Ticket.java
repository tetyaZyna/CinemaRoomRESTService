package cinema.model.response;

import lombok.Builder;

@Builder
public record Ticket (
        int row,
        int column,
        int price
){
    public Ticket(Seat seat, int price) {
        this(seat.row(), seat.column(), price);
    }
}
