/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.knockknock;

import java.util.concurrent.Exchanger;

/**
 * Knock Knock
 *
 * @author colin
 */
public class KnockKnock {

    /**
     * Starts the joke around
     */
    public static void startJoke() {
        final Exchanger<String> exchanger = new Exchanger<>();

        Joe joe = new Joe("Joe", exchanger);
        Alice alice = new Alice("Alice", exchanger);

        new Thread(joe).start();
        new Thread(alice).start();
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
