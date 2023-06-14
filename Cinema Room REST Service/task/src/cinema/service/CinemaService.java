package cinema.service;


import cinema.model.SoldTicket;
import cinema.model.response.CinemaRoomInfo;
import cinema.model.response.ReturnedTicketResponse;
import cinema.model.response.Seat;
import cinema.model.response.StatsResponse;

public interface CinemaService {
    public CinemaRoomInfo getCinemaRoomInfo();
    public SoldTicket purchase(Seat seat);
    public ReturnedTicketResponse returnTicket(String token);
    public StatsResponse calcStats();
}
