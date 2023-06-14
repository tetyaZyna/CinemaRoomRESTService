package cinema.controller;

import cinema.config.CinemaProps;
import cinema.exception.WrongPasswordException;
import cinema.model.request.ReturnTicketRequest;
import cinema.model.response.ReturnedTicketResponse;
import cinema.model.SoldTicket;
import cinema.model.response.CinemaRoomInfo;
import cinema.model.response.Seat;
import cinema.model.response.StatsResponse;
import cinema.service.CinemaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class CinemaController {
    CinemaService cinemaService;
    CinemaProps props;

    @GetMapping("/seats")
    CinemaRoomInfo availableSeats() {
        return cinemaService.getCinemaRoomInfo();
    }

    @PostMapping("/purchase")
    SoldTicket purchase(@RequestBody Seat seat) {
        log.info("seat = {}", seat);
        return cinemaService.purchase(seat);
    }

    @PostMapping("/return")
    ReturnedTicketResponse returnTicket(@RequestBody ReturnTicketRequest req) {
        log.info("token = {}", req.token());
        return cinemaService.returnTicket(req.token());
    }

    @PostMapping("/stats")
    StatsResponse stats(@RequestParam(value = "password", required = false) String password) {
        if (!props.password().equals(password)) {
            throw new WrongPasswordException();
        }
        return cinemaService.calcStats();
    }
}
