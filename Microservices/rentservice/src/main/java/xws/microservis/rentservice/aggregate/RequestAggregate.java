package xws.microservis.rentservice.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RequestAggregate {

    @AggregateIdentifier
    private Long requestId;

    public RequestAggregate() {
    }

    /**
     * Metoda za obradu dogadjaja kreiranja Request-a
     * */
    @CommandHandler
    public RequestAggregate(CreateRequestCommand createRequestCommand){
        AggregateLifecycle.apply(new RequestCreatedEvent(createRequestCommand.getId()));

    }

    @EventSourcingHandler
    protected void on(RequestCreatedEvent requestCreatedEvent){
        this.requestId = requestCreatedEvent.getId();
    }


}
