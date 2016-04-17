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
     * Main method
     *
     * @param args
     */
    public static void main( String[] args ) {

        final Exchanger<String> exchanger = new Exchanger<>();

        Joe joe = new Joe("Joe", exchanger);
        Alice alice = new Alice("Alice", exchanger);

        new Thread(joe).start();
        new Thread(alice).start();

    }
}
