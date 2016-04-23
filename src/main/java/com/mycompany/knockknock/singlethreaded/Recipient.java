/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock.singlethreaded;

/**
 * The recipient of the Knock Knock Joke
 *
 * @author colin
 */
public class Recipient extends Person {

    /**
     * {@inheritDoc}
     */
    public Recipient(String name) {
        super(name);
    }

    public String giveResponse() {
        return "Who's there?";
    }

    public String giveRepitionResponse(String reply) {
        return reply + " who?";
    }
}
