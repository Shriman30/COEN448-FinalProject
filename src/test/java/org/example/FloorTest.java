package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @Test
    void drawOnFloor() {
    }

    @Test
    void inputForSetFloor(){
        String command = "I 1";
        Floor floor = new Floor();
        assertTrue(floor.setFloor(command));
        command = "I 2";
        assertTrue(floor.setFloor(command));
        command = "ABCDEF";
        assertFalse(floor.setFloor(command));
    }

    @Test
    void isFloorSquare(int n) {
        Floor floor = new Floor();
        floor.setSize(n);
        floor.initializeFloor();
        // Check if floor is Square
        assertEquals(floor.getRows(), floor.getColumns());
    }

    @Test void isFloorSquare100(){
        for (int i = 0; i < 100; i++) {
            isFloorSquare(i);
        }
    }

    @Test
    void printFloor() {
    }
}