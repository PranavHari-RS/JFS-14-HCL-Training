package com.pgcrp.memorylab;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryDemo {

    public static void main(String[] args) {

        List<byte[]> memory = new ArrayList<>();

        int count = 0;

        try {
            while (true) {
                memory.add(new byte[1024 * 1024]);
                count++;

                System.out.println("Allocated: " + count + " MB");
            }

        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError occurred!");
            System.out.println("Arrays allocated: " + count);
        }
    }
}