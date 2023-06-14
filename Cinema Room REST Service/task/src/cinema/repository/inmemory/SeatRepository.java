package cinema.repository.inmemory;

import cinema.model.response.Seat;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SeatRepository implements cinema.repository.SeatRepository {
    private Set<Seat> availableSeats = new LinkedHashSet<>();

    public List<Seat> getAllAvailable() {
        return availableSeats.stream().toList();
    }

    public void addSeat(Seat seat) {
        availableSeats.add(seat);
    }

    public boolean exists(Seat seat) {
        return availableSeats.contains(seat);
    }

    public boolean delete(Seat seat) {
        return availableSeats.remove(seat);
    }

    public int count() {
        return availableSeats.size();
    }
}