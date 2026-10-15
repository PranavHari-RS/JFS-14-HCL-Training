package com.pgcrp.memorylab;

public class IntegerCacheDemo {

    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;

        Integer c = 200;
        Integer d = 200;

        System.out.println("100 == 100: " + (a == b));
        System.out.println("200 == 200: " + (c == d));

        System.out.println("100 equals 100: " + a.equals(b));
        System.out.println("200 equals 200: " + c.equals(d));
    }
}