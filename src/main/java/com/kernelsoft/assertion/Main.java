package com.kernelsoft.assertion;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws SQLException {

        String str = "value";
        assert str.isEmpty();

        List<String> cities = List.of("Istanbul", "Izmir", "Adana", "");

        assert cities.size() == 3 : "City's list size must be 3";

        System.out.println(cities);
        cities.forEach(s -> {
            assert Objects.equals(s, "Adana") : "city name cannot be empty";
        });

        try {
            assert !str.isEmpty() : "Assertion failed";
        } catch (AssertionError e) {

            System.err.println("Assertion failed: " + e.getMessage());
        }


        /*

        Connection conn = getConnection("url");
        if(conn == null) {
            throw new RuntimeException("Connection is null");
        }

        Connection conn = getConnection("url");
        assert conn != null;
        */

    }
}
