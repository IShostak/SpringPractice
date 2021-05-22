package com.ishostak.springdemo.rest;

public class ru {
    public static void main(String[] args) {
        Integer i1 = 200;
        Integer i2 = 200;
        System.out.println(i1 == i2);

        int i3 = 200;
        int i4 = 200;
        System.out.println(i3 == i4);

        Integer i5 = 100;
        Integer i6 = 100;
        System.out.println(i5 == i6);

        Integer i7 = 100;
        Integer i8 = new Integer(100);
        System.out.println(i7 == i8);

        String s1 = "Hello!";
        String s2 = new String("Hello!").intern();

        System.out.println(s1 == s2);


    }
}
