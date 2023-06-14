package cinema.service.mocks;

import cinema.model.SoldTicket;
import cinema.model.response.CinemaRoomInfo;
import cinema.model.response.ReturnedTicketResponse;
import cinema.model.response.Seat;
import cinema.model.response.StatsResponse;
import cinema.service.CinemaService;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceMock implements CinemaService {
    @Override
    public CinemaRoomInfo getCinemaRoomInfo() {
        return null;
    }

    @Override
    public SoldTicket purchase(Seat seat) {
        return null;
    }

    @Override
    public ReturnedTicketResponse returnTicket(String token) {
        return null;
    }

    @Override
    public StatsResponse calcStats() {
        return null;
    }
}
