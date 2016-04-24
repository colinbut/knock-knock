/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.knockknock.multithreaded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Exchanger;

/**
 * Knock Knock joke
 *
 * @author colin
 */
public class KnockKnock {

    private static final Logger LOG = LoggerFactory.getLogger(KnockKnock.class);

    private static final String PUNSTER_NAME = "Joe";
    private static final String JOKE_RECIPIENT = "Alice";

    /**
     * Starts the joke around
     */
    public static void startJoke() {

        LOG.info("Starting Knock Knock Joke");

        final Exchanger<String> exchanger = new Exchanger<>();

        Punster punster = new Punster(PUNSTER_NAME, exchanger);
        LOG.debug("Created Punster: {}", punster);

        Recipient recipient = new Recipient(JOKE_RECIPIENT, exchanger);
        LOG.debug("Created recipient: {}", recipient);

        LOG.debug("Starting the conversation between the Punster and the Recipient");
        new Thread(punster).start();
        new Thread(recipient).start();
    }

    /**
     * Returns a string that says '[Person name] says: '
     *
     * @param name the name of the Person
     * @return a {@link String} that says '[Person name] says: '
     */
    public static String displayWhoSaysWhat(String name) {
        return name + " says: ";
    }



    /**
     * Main method
     *
     * @param args
     */
    public static void main( String[] args ) {
        KnockKnock.startJoke();
    }
}
