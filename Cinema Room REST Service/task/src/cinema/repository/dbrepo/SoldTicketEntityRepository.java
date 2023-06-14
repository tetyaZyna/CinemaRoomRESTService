package cinema.repository.dbrepo;

import cinema.model.SoldTicket;
import cinema.model.entity.SoldTicketEntity;
import cinema.model.response.Ticket;
import cinema.repository.SoldTicketRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SoldTicketEntityRepository extends JpaRepository<SoldTicketEntity, String>,
        SoldTicketRepository
{
    @Transactional
    @Override
    default void add(SoldTicket soldTicket) {
        SoldTicketEntity e = new SoldTicketEntity();
        e.setToken(soldTicket.token());
        e.setRow(soldTicket.ticket().row());
        e.setColumn(soldTicket.ticket().column());
        e.setPrice(soldTicket.ticket().price());
        save(e);
    }

    @Transactional
    @Override
    default int totalIncome() {
        return findAll().stream()
                .mapToInt(SoldTicketEntity::getPrice)
                .sum();
    }

    @Transactional
    @Override
    default Optional<Ticket> delete(String token) {
        if (!existsById(token)) {
            return Optional.empty();
        }
        var soldTicketEntity = findById(token).get();
        this.deleteById(token);
        return Optional.of(Ticket.builder()
                .row(soldTicketEntity.getRow())
                .column(soldTicketEntity.getColumn())
                .price(soldTicketEntity.getPrice())
                .build());
    }

    long countByPriceGreaterThan(int price);
}