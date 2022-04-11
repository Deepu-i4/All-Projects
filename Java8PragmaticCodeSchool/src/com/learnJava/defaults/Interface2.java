package com.learnJava.defaults;

/**
 * Created by z001qgd on 8/2/18.
 */
public interface Interface2 extends Interface1{

    default void methodB(){
        System.out.println("Interface2 Inside method B");
    }

    default void methodA(){
        System.out.println("Interface2 Inside method A "+ Interface2.class);
    }
}
