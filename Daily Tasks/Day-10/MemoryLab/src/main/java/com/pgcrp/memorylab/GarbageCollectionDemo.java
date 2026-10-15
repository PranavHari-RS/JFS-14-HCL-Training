package com.pgcrp.memorylab;

public class GarbageCollectionDemo {

    public static void main(String[] args) {

        System.out.println("Garbage Collection Demo Started");

        for (int i = 0; i < 1000; i++) {

            byte[] data = new byte[1024 * 1024];

            data[0] = 1;
        }

        System.out.println("Garbage Collection Demo Completed");
    }
}