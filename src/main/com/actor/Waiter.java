package com.actor;    /***
 com.actor.Waiter.java is source for the the waiter actor in the Fortune Cookie application.
 ***/

import akka.actor.UntypedActor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Waiter extends UntypedActor {
    public static enum Message {ASK_FOR_COOKIE;}

    private List<String> fortune_cookies = Arrays.asList(
            "Your monkey face will earn you many peanuts.",
            "You will discover fountain of youth in middle of quick sand pit.",
            "You will be safe. Your enemies will all die laughing.",
            "The wisdom of our ancient sages will blow past your head like a gentle breeze.",
            "Your only friend will soon betray you. This betrayal will bring a new friend.",
            "You will be shunned by everyone for fearing to read your fortune cookie.");

    @Override
    public void onReceive(Object message) {
        if (message == Message.ASK_FOR_COOKIE) {
            // Reply only to a message we recognize.
            Date date = new Date();
            Random generator = new Random(date.getTime());
            int index = generator.nextInt(fortune_cookies.size());
            // Reply to sender with message and self address.
            getSender().tell("\n" + fortune_cookies.get(index) + "\n", getSelf());
        } else {
            // We will publish messages not recognized to the EventStream.
            unhandled(message);
        }
    }
}//end class com.actor.Waiter


