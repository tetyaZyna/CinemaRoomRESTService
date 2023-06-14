package cinema.service.impl;


import cinema.config.CinemaProps;
import cinema.exception.AlreadyPurchasedException;
import cinema.exception.SeatOutOfBoundsException;
import cinema.exception.WrongTokenException;
import cinema.mapper.Mapper;
import cinema.model.response.*;
import cinema.model.SoldTicket;
import cinema.repository.SeatRepository;
import cinema.repository.SoldTicketRepository;
import cinema.service.CinemaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Primary
@Slf4j
@AllArgsConstructor
@Service
public class CinemaServiceImpl implements CinemaService {
    CinemaProps cinemaProps;
    SeatRepository seatRepository;
    SoldTicketRepository soldTicketRepository;
    Mapper mapper;

    public CinemaRoomInfo getCinemaRoomInfo() {
        return new CinemaRoomInfo (
                cinemaProps.totalRows(),
                cinemaProps.totalColumns(),
                seatRepository.getAllAvailable().stream()
                        .map(this::addPrice)
                        .toList()
        );
    }

    public SoldTicket purchase(Seat seat) {
        if (!validate(seat)) {
            throw new SeatOutOfBoundsException();
        }
        if (!seatRepository.exists(seat)) {
            throw new AlreadyPurchasedException();
        }
        seatRepository.delete(seat);
        String token = UUID.randomUUID().toString();
        var ticket = addPrice(seat);
        SoldTicket soldTicket = new SoldTicket(
                token, ticket);
        soldTicketRepository.add(soldTicket);
        return soldTicket;
    }

    private boolean validate(Seat seat) {
        return !(seat.row() <= 0 || seat.column() <= 0
                || seat.row() > cinemaProps.totalRows()
                || seat.column() > cinemaProps.totalColumns());
    }

    private Ticket addPrice(Seat seat) {
        return new Ticket(seat.row(), seat.column(), calcPrice(seat));
    }

    private int calcPrice(Seat seat) {
        return seat.row() <= cinemaProps.firstRows()
                ? cinemaProps.price().high()
                : cinemaProps.price().low();
    }

    public ReturnedTicketResponse returnTicket(String token) {
        var ticked = soldTicketRepository.delete(token)
                .orElseThrow(WrongTokenException::new);
        seatRepository.addSeat(mapper.toSeat(ticked));
        return new ReturnedTicketResponse(ticked);
    }

    public StatsResponse calcStats() {
        return StatsResponse.builder()
                .currentIncome(soldTicketRepository.totalIncome())
                .numberOfAvailableSeats(seatRepository.count())
                .numberOfPurchasedTickets(soldTicketRepository.count())
                .build();
    }
}
