package com.kernelsoft.testing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import static org.junit.Assume.assumeTrue;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class Main {
    @Test
    public void func() {
        assertEquals(7, 3 + 4);
    }

    @Test()
    @Order(1)
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });

    }

    @Test
    @DisplayName("ensure env variable")
    public void testOnDevelopmentEnvironment() {
        assumeTrue(System.getenv("ENV").equals("DEV"));
    }
}
