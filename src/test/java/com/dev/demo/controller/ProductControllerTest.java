package com.dev.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductControllerTest {

    @Test
    @DisplayName("Addition of 1 + 1 should equal 2")
    void testAdditionOnePlusOneEqualsTwo() {
        assert 1 + 1 == 2;
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }

    @Test
    void testMultipleAdditionValues () {
        assertTrue( 3 + 3 == 6, "3 + 3 should equal 6");
        assert -3 + 3 == 0;
        assert -3 + (-3) == -6;
        assert 0 + 3 == 3;

    }
}
