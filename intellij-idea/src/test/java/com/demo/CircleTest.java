package com.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @Test
    void shouldHaveNoCorners(){
        Shape circle = new Circle();
        int numberOfCorners = circle.getNumberOfCorners();
        assertEquals(0, numberOfCorners);
    }

}