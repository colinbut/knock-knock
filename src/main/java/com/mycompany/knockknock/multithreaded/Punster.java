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
 * First person - Punster
 *
 * @author colin
 */
public class Punster extends Person implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(Punster.class);

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

        LOG.trace(">> run()");

        try {
            exchangingJokeConversation();
        } catch (InterruptedException e) {
            LOG.error("{}", e);
        }

        LOG.trace("<< run()");

    }

    /**
     * Exchanging the joke with the recipient
     *
     * @throws InterruptedException
     */
    private void exchangingJokeConversation() throws InterruptedException {
        LOG.debug("Exchanging conversation with the recipient");
        LOG.debug("Knocking on the door!");

        String initiateExchangeMessage = KnockKnock.displayWhoSaysWhat(name) + "Knock Knock";

        if(LOG.isDebugEnabled()) {
            LOG.debug(initiateExchangeMessage);
        }

        String reply = exchanger.exchange(initiateExchangeMessage);
        LOG.debug("Received reply {} from recipient.", reply);
        System.out.println(reply);

        reply = exchanger.exchange(KnockKnock.displayWhoSaysWhat(name) + "Dozen");
        LOG.debug("Received another reply {} from recipient.", reply);
        System.out.println(reply);

        String finalPunchLine = KnockKnock.displayWhoSaysWhat(name) + "Doesn't anybody want to let me in!";
        if (LOG.isDebugEnabled()) {
            LOG.debug(finalPunchLine);
        }
        reply = exchanger.exchange(finalPunchLine);
    }
}
