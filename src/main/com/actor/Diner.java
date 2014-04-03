package com.actor;    /***
 com.actor.Diner.java is source for the diner actor in the Fortune Cookie application; a simple exercise
 designed to show basic child creation, messaging, and termination.
 ***/

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Diner extends UntypedActor {
    private final ActorRef waiter;

    public Diner() {
        // Create the waiter actor, a child actor of the parent diner actor.
        waiter = getContext().actorOf(Props.create(Waiter.class), "waiter");
    }

    @Override
    public void preStart() {
        // Ask the waiter for a fortune cookie.
        waiter.tell(Waiter.Message.ASK_FOR_COOKIE, getSelf());
    }

    // This is where we listen for messages.
    @Override
    public void onReceive(Object message) {
        // Reveal the fortune.
        System.out.println(message.toString());

        // Stop the application by stopping the parent actor. This wiil cause child actor to stop.
        getContext().stop(getSelf());
    }
}//end class com.actor.Diner
  


