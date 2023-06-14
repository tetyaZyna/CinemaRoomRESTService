package cinema.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
@Entity
public class SoldTicketEntity {
    @Id
    String token;
    @Column(name = "row_num")
    int row;
    int column;
    int price;
}
