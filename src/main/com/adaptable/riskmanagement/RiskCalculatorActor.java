package com.adaptable.riskmanagement;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class RiskCalculatorActor extends UntypedActor {
    private final ActorRef aggregator;

    public RiskCalculatorActor() {
        aggregator = getContext().actorOf(Props.create(AggregatorActor.class), "aggregator");
    }

    @Override
    public void preStart() {
        aggregator.tell("aggregate", getSelf());
    }
    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("Received from aggregator : "+ message);

        getContext().stop(getSelf());
    }
}
