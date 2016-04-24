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
 * Second Person - Recipient
 *
 * @author colin
 */
public class Recipient extends Person implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(Recipient.class);

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

        LOG.trace(">> run()");

        try {
            exchangeJokeWithPunster();

        } catch (InterruptedException e) {
            LOG.error("{}", e);
        }

        LOG.trace("<< run()");
    }

    /**
     * Exchanging joke conversation with the Punster
     *
     * @throws InterruptedException
     */
    private void exchangeJokeWithPunster() throws InterruptedException {
        String exchangeMessageWithPunster = KnockKnock.displayWhoSaysWhat(name) + "Who's there?";
        if(LOG.isDebugEnabled()) {
            LOG.debug(exchangeMessageWithPunster);
        }

        String reply = exchanger.exchange(exchangeMessageWithPunster);
        LOG.debug("Received reply {} from Punster ", reply);
        System.out.println(reply);

        String askingForWhoMessage = KnockKnock.displayWhoSaysWhat(name) + "Dozen" + " who?";
        if(LOG.isDebugEnabled()) {
            LOG.debug(askingForWhoMessage);
        }

        reply = exchanger.exchange(askingForWhoMessage);
        LOG.debug("Received reply {} from Punster", reply);
        System.out.println(reply);

        reply = exchanger.exchange("");
        System.out.println(reply);
    }
}
