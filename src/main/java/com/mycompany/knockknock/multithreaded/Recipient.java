/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock.multithreaded;

import java.util.concurrent.Exchanger;

/**
 * Second Person - Recipient
 *
 * @author colin
 */
public class Recipient extends Person implements Runnable {

    private Exchanger<String> exchanger;

    /**
     * Constructor
     *
     * @param name name of the Person
     * @param exchanger a mechanism to exchange
     */
    public Recipient(String name, Exchanger<String> exchanger) {
        super(name);
        this.exchanger = exchanger;
    }


    @Override
    public void run() {

        try {
            String reply = exchanger.exchange(KnockKnock.displayWhoSaysWhat(name) + "Who's there?");
            System.out.println(reply);

            reply = exchanger.exchange(KnockKnock.displayWhoSaysWhat(name) + "Dozen" + " who?");
            System.out.println(reply);

            reply = exchanger.exchange("");
            System.out.println(reply);


        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
