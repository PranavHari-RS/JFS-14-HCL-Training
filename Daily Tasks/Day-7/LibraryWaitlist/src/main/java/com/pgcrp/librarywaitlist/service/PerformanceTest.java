package com.pgcrp.librarywaitlist.service;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceTest {

    public static void comparePerformance() {

        int size = 100000;

        // ArrayList uses a dynamic array, providing O(1) indexed access.
        // Inserting at the beginning requires shifting elements: O(n).
        ArrayList<Integer> arrayList = new ArrayList<>();

        // LinkedList uses linked nodes, allowing O(1) insertion at the beginning.
        // Accessing an element using get(i) requires traversal: O(n).
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();

        arrayList.add(0, 999);

        long end = System.nanoTime();

        System.out.println("ArrayList Insert: " + (end - start) + " ns");

        start = System.nanoTime();

        linkedList.add(0, 999);

        end = System.nanoTime();

        System.out.println("LinkedList Insert: " + (end - start) + " ns");

        start = System.nanoTime();

        int arrayValue = arrayList.get(size / 2);

        end = System.nanoTime();

        System.out.println("ArrayList get(i): " + (end - start) + " ns");

        start = System.nanoTime();

        int linkedValue = linkedList.get(size / 2);

        end = System.nanoTime();

        System.out.println("LinkedList get(i): " + (end - start) + " ns");

        System.out.println("Retrieved values: "
                + arrayValue + ", " + linkedValue);
    }
}