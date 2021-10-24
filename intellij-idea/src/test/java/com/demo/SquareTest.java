package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

class SquareTest {
    @Test
    void shouldHaveFourCorners() {
        Square square = new Square();
        int numberOfCorners = square.getNumberOfCorners();
       assertValues(4, square::getNumberOfCorners);
    }

    @Test
    void shouldHaveFourEdges(){
        Square square = new Square();
        assertValues(4, square::getNumberOfEdges);
    }

    private void assertValues(int expected, IntSupplier intSupplier) {
        Assertions.assertEquals(expected, intSupplier.getAsInt());

    }

    @Test
    void name() {
    }
}