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
public class Joe implements Runnable {

    private String name;
    private Exchanger<String> exchanger;


    public Joe(String name, Exchanger<String> exchanger) {
        this.name = name;
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        try {
            String reply = exchanger.exchange("Knock Knock");
            System.out.println(reply);

            reply = exchanger.exchange("Dozen");
            System.out.println(reply);

            reply = exchanger.exchange("Doesn't anybody want to let me in!");


        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
