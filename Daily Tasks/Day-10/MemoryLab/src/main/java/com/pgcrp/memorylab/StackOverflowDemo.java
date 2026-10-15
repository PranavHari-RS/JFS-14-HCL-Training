package com.pgcrp.memorylab;

public class StackOverflowDemo {

    static int depth = 0;

    public static void recursiveMethod() {
        depth++;
        recursiveMethod();
    }

    public static void main(String[] args) {

        try {
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError occurred!");
            System.out.println("Maximum recursion depth: " + depth);
        }
    }
}