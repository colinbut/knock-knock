/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.knockknock;

/**
 * A person
 *
 * @author colin
 */
public class Person {

    protected String name;


    public Person(String name) {
        this.name = name;
    }


    public String whoSaysWhat() {
        return name + " says: ";
    }
}
