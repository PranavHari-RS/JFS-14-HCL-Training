package com.pgcrp.generictoolkit.generics;

import java.util.List;

public class GenericUtils {

    public static <T extends Comparable<T>> T max(T a, T b) {

        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void printList(List<?> list) {

        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static double sumNumbers(List<? extends Number> numbers) {

        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }

    public static void addIntegers(List<? super Integer> list) {

        list.add(10);
        list.add(20);
        list.add(30);
    }
}