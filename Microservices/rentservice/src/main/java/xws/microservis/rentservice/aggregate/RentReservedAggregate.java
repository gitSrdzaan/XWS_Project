package xws.microservis.rentservice.aggregate;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RentReservedAggregate {

    @AggregateIdentifier
    private Long requestId;

    public RentReservedAggregate() {
    }


}
