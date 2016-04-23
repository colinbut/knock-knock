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

    /**
     * Give response
     *
     * @return asking who is there?
     */
    public String giveResponse() {
        return "Who's there?";
    }

    /**
     * Give the repetitive response
     *
     * @param reply the reply to respond to
     * @return asking who it is?
     */
    public String giveRepitionResponse(String reply) {
        return reply + " who?";
    }
}
