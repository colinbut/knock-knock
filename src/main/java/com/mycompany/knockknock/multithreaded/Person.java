/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock.multithreaded;

/**
 * A person
 *
 * @author colin
 */
public abstract class Person {

    protected final String name;

    /**
     * Constructor
     *
     * @param name name of the Person
     */
    public Person(String name) {
        this.name = name;
    }

}
