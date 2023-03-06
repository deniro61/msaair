package msaair.domain;

import msaair.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class MileageDecreased extends AbstractEvent {

    private Long customerId;
    private Integer mileage;
}
