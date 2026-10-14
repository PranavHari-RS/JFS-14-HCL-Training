package com.pgcrp.generictoolkit.resource;

public class CustomResource implements AutoCloseable {

    private final String resourceName;

    public CustomResource(String resourceName) {

        this.resourceName = resourceName;

        System.out.println(resourceName + " opened");
    }

    public void execute() {

        System.out.println(resourceName + " executing");
    }

    @Override
    public void close() {

        System.out.println(resourceName + " closed");
    }
}