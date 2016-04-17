/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.knockknock;

import java.util.concurrent.Exchanger;

/**
 * Knock Knock
 *
 * @author colin
 */
public class App {

    /**
     * Main method
     *
     * @param args
     */
    public static void main( String[] args ) {

        final Exchanger<String> exchanger = new Exchanger<String>();

        Thread person1 = new Thread(new Runnable() {

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
        });


        Thread person2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String reply = exchanger.exchange("Who's there?");
                    System.out.println(reply);

                    reply = exchanger.exchange("Dozen" + " who?");
                    System.out.println(reply);

                    reply = exchanger.exchange("");
                    System.out.println(reply);


                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        });

        person2.start();
        person1.start();


    }
}
