package cinema.repository;

import cinema.model.response.Seat;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface SeatRepository {
    public List<Seat> getAllAvailable();

    public void addSeat(Seat seat);

    public boolean exists(Seat seat);

    public boolean delete(Seat seat);

    public int count();
}
