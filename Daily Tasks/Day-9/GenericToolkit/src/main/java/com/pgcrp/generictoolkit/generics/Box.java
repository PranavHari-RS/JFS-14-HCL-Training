package com.pgcrp.generictoolkit.generics;

public class Box<T extends Number> {

    private final T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double getDoubleValue() {
        return value.doubleValue();
    }

    @Override
    public String toString() {
        return "Box Value: " + value;
    }
}