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

    /**
     * Main entry
     *
     * @param args
     */
    public static void main(String[] args) {

        Punster joe = new Punster("Joe");
        Recipient alice = new Recipient("Alice");

        System.out.println(joe.knockOnDoor());
        System.out.println(alice.giveResponse());

        String reply = joe.giveVariableResponse();
        System.out.println(reply);

        System.out.println(alice.giveRepitionResponse(reply));
        System.out.println(joe.deliverPunchLine());
    }

}
