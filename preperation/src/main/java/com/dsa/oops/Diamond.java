package com.dsa.oops;


interface A {
    default void m1() {
        System.out.println("A");
    }
}

interface B {
    default void m1() {
        System.out.println("B");
    }
}

public class Diamond implements A, B{

    @Override
    public void m1() {
        A.super.m1();
        B.super.m1();
    }
}
