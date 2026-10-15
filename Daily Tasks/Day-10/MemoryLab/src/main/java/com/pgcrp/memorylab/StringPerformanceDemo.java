package com.pgcrp.memorylab;

public class StringPerformanceDemo {

    public static void main(String[] args) {

        int iterations = 20000;

        String text = "";

        long start1 = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            text += i;
        }

        long end1 = System.nanoTime();

        StringBuilder builder = new StringBuilder();

        long start2 = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            builder.append(i);
        }

        String result = builder.toString();

        long end2 = System.nanoTime();

        System.out.println("String += Time: "
                + (end1 - start1) / 1_000_000.0 + " ms");

        System.out.println("StringBuilder Time: "
                + (end2 - start2) / 1_000_000.0 + " ms");

        System.out.println("String length: " + text.length());
        System.out.println("StringBuilder length: " + result.length());
    }
}