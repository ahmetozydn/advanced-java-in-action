package com.kernelsoft.testing;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeAll
    static void setup() {
    }

    @Test
    @DisplayName("addition test is successful")
    public void testAddition() {


        assertEquals(7, 3 + 4);

    }
}