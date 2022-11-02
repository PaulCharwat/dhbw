package de.paulcharwat.java1.chapter7;

import de.paulcharwat.java1.chapter6.Calculator;

public class Plotter {
    public static final int MAX = 120;

    public static void main(String[] args) {
        for (int line = 1; line <= 6; line++){
            long value = value(line);
            long length = Calculator.min(value, MAX);
            System.out.print("+");
            for(int pos = 1; pos <= length; pos++){
                System.out.print("-");
            }
            System.out.println(value <=MAX ? "+" : ">");
        }
    }

    public static long value(int x){
        return (long) Calculator.PI * x * x;
        //return Calculator.factorial(x);
    }
}
