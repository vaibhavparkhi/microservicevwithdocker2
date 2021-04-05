package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void shouldHaveFourCorners() {
        Square square = new Square();
        int numberOfCorners = square.getNumberOfCorners();

        Assertions.assertEquals(4, numberOfCorners);
    }
}