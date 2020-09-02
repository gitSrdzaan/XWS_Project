package xws.microservis.rentservice.saga;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import javax.inject.Inject;

@Saga
public class RequestSaga {

    @Inject
    private final CommandHandler commandHandler;

    @StartSaga
    @SagaEventHandler(associationProperty = "requestId")
    public void handle(RequestCreatedEvent requestCreatedEvent){
        System.out.println("Saga envoked");
    }


}
