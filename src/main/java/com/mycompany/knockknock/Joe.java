/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock;

import java.util.concurrent.Exchanger;

/**
 * First person - Joe
 *
 * @author colin
 */
public class Joe extends Person implements Runnable {

    private Exchanger<String> exchanger;


    public Joe(String name, Exchanger<String> exchanger) {
        super(name);
        this.exchanger = exchanger;
    }


    @Override
    public void run() {

        try {
            String reply = exchanger.exchange(whoSaysWhat() + "Knock Knock");
            System.out.println(reply);

            reply = exchanger.exchange(whoSaysWhat() + "Dozen");
            System.out.println(reply);

            reply = exchanger.exchange(whoSaysWhat() + "Doesn't anybody want to let me in!");


        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
