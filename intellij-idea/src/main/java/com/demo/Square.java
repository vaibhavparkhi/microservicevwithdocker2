package com.demo;

import java.util.Optional;

public class Square implements Shape {

    private final int numberofCorner = 4;
    private final int numberOfEdges = 4;

    String json = "{\n" +
            "  \"name\": \"vaibhav\",\n" +
            "  \"address\": \"Pune\"\n" +
            "}";


    public int getNumberOfCorners() {

        Optional<String> optional = Optional.of("vp");
        String value = optional.orElse(null);

        if (value == null) {
            System.out.println(value);
        }
        return 4;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;

    }

    private String switchExpression(int port) {
        return switch (port) {
            case 20 -> "20";
            default -> throw new IllegalStateException("Unexpected value: " + port);
        };
    }

}
