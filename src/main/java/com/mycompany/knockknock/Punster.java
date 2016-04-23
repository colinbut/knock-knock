/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock;

import java.util.concurrent.Exchanger;

/**
 * First person - Punster
 *
 * @author colin
 */
public class Punster extends Person implements Runnable {

    private Exchanger<String> exchanger;

    /**
     * Constructor
     *
     * @param name name of the Person
     * @param exchanger a mechanism to exchange
     */
    public Punster(String name, Exchanger<String> exchanger) {
        super(name);
        this.exchanger = exchanger;
    }


    @Override
    public void run() {

        try {
            String reply = exchanger.exchange(KnockKnock.displayWhoSaysWhat(name) + "Knock Knock");
            System.out.println(reply);

            reply = exchanger.exchange(KnockKnock.displayWhoSaysWhat(name) + "Dozen");
            System.out.println(reply);

            reply = exchanger.exchange(KnockKnock.displayWhoSaysWhat(name) + "Doesn't anybody want to let me in!");


        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
