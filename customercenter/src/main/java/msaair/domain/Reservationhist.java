package msaair.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="Reservationhist_table")
@Data
public class Reservationhist {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long reservationId;
        private Long customerId;
        private Integer mileage;
        private String reservationStatus;


}
