/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock.singlethreaded;

/**
 * The 'Punster' i.e. The Joke Teller
 *
 * @author colin
 */
public class Punster extends Person {


    /**
     * {@inheritDoc}
     */
    public Punster(String name) {
        super(name);
    }

    /**
     * Knock the door!
     *
     * @return "Knock, Knock"
     */
    public String knockOnDoor() {
        return "Knock, Knock";
    }

    /**
     * Give the response back to say who you are
     *
     * @return who are you?
     */
    public String giveVariableResponse() {
        return "Woo";
    }

    /**
     * Delivering the final pun
     *
     * @return the final punch line
     */
    public String deliverPunchLine() {
        return "Don't get too excited. It's just a joke";
    }
}
