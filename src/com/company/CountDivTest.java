package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountDivTest {
    @Test
    public void mainTest() {
        assertEquals(3, CountDiv.solution(6, 11, 2));
        assertEquals(1, CountDiv.solution(0, 0, 11));
        assertEquals(8, CountDiv.solution(0, 14, 2));
    }
}