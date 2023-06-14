package cinema.config;

import cinema.model.response.Seat;
import cinema.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@AllArgsConstructor
@Component
public class Initializer implements CommandLineRunner {
    SeatRepository seatRepository;
    CinemaProps props;

    @Override
    public void run(String... args) throws Exception {
        for (int iRow = 1; iRow <= props.totalRows(); iRow++) {
            for (int iCol = 1; iCol <= props.totalColumns(); iCol++) {
                    seatRepository.addSeat(new Seat(iRow, iCol));
            }
        }
    }

}
