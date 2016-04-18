/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock;

import java.util.concurrent.Exchanger;

/**
 * Second Person - Alice
 *
 * @author colin
 */
public class Alice extends Person implements Runnable {

    private Exchanger<String> exchanger;

    public Alice(String name, Exchanger<String> exchanger) {
        super(name);
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        try {
            String reply = exchanger.exchange(whoSaysWhat() + "Who's there?");
            System.out.println(reply);

            reply = exchanger.exchange(whoSaysWhat() + "Dozen" + " who?");
            System.out.println(reply);

            reply = exchanger.exchange("");
            System.out.println(reply);


        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
