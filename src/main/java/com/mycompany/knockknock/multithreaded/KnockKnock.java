/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.knockknock.multithreaded;

import java.util.concurrent.Exchanger;

/**
 * Knock Knock joke
 *
 * @author colin
 */
public class KnockKnock {

    private static final String PUNSTER_NAME = "Joe";
    private static final String JOKE_RECIPIENT = "Alice";

    /**
     * Starts the joke around
     */
    public static void startJoke() {
        final Exchanger<String> exchanger = new Exchanger<>();

        Punster punster = new Punster(PUNSTER_NAME, exchanger);
        Recipient recipient = new Recipient(JOKE_RECIPIENT, exchanger);

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
