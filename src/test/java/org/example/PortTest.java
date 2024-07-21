package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PortTest {
    private Port port;
    @BeforeEach
    void setUp() {
        port = new Port();
    }

    @Test
    void convert() {
        List<List<Integer>> actual = port.convert(new String[]{"1,3-5", "2", "3-4"});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(0, Arrays.asList(1,3,4,5));
        expected.add(1, Arrays.asList(2));
        expected.add(2, Arrays.asList(3,4));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void convertInvalid(){
        List<List<Integer>> actual = port.convert(new String[]{"1,3-5", "2", "3-4"});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(0, Arrays.asList(1,5));
        expected.add(1, Arrays.asList(2));
        expected.add(2, Arrays.asList(4));
        assertNotEquals(expected, actual);
    }

    @Test
    void uniqueСombination() {
        List<List<Integer>> actual = port.uniqueСombination(new String[]{"1,3-5", "2"});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(0, Arrays.asList(1,2));
        expected.add(1, Arrays.asList(3,2));
        expected.add(2, Arrays.asList(4,2));
        expected.add(3, Arrays.asList(5,2));
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void uniqueСombinationInvalid() {
        List<List<Integer>> actual = port.uniqueСombination(new String[]{"1,3-5", "2"});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(0, Arrays.asList(1,2));
        expected.add(1, Arrays.asList(3,2));
        expected.add(2, Arrays.asList(4,2));
        assertNotEquals(expected, actual);
    }
}