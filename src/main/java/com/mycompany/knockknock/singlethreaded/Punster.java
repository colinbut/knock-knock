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
     *
     * @return
     */
    public String knockOnDoor() {
        return "Knock, Knock";
    }

    /**
     *
     * @return
     */
    public String giveVariableResponse() {
        return "Woo";
    }

    /**
     *
     * @return
     */
    public String deliverPunchLine() {
        return "Don't get too excited. It's just a joke";
    }
}
