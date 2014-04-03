package com.adaptable.riskmanagement;

import akka.actor.UntypedActor;

public class AggregatorActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("Aggregator received : "+message.toString());
        getSender().tell("data", getSelf());
    }
}
