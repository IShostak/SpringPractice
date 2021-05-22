package com.ishostak.springdemo.config;

import java.util.function.IntUnaryOperator;

public class temp {
    public static void main(String[] args) {
        IntUnaryOperator mult2 = num -> num * 2;
        IntUnaryOperator add3 = num -> num + 3;

        IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
        int result = combinedOperator.applyAsInt(5);

        System.out.println(result);
    }
}
