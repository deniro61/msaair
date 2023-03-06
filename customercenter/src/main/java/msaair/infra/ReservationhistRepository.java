package msaair.infra;

import msaair.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="reservationhists", path="reservationhists")
public interface ReservationhistRepository extends PagingAndSortingRepository<Reservationhist, Long> {

    

    
}
