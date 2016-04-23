/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock.singlethreaded;

/**
 * The Knock Knock Joke
 *
 * @author colin
 */
public class KnockKnockJoke {

    private static final String PUNSTER_NAME = "Joe";
    private static final String RECIPIENT_NAME = "ALICE";

    /**
     * Main entry
     *
     * @param args
     */
    public static void main(String[] args) {

        Punster joe = new Punster(PUNSTER_NAME);
        Recipient alice = new Recipient(RECIPIENT_NAME);

        String knockingOnDoor = joe.knockOnDoor();
        System.out.println(knockingOnDoor);

        String initialResponse = alice.giveResponse();
        System.out.println(initialResponse);

        String reply = joe.giveVariableResponse();
        System.out.println(reply);

        String askingWho = alice.giveRepitionResponse(reply);
        System.out.println(askingWho);

        String punchLine = joe.deliverPunchLine();
        System.out.println(punchLine);
    }

}
