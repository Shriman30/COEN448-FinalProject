package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @Test
    void drawOnFloor() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        floor.initializeFloor();
        floor.drawOnFloor(1,1, '^');
        assertEquals(floor.getFloorValue(1,1), '^');
        assertNotEquals(floor.getFloorValue(1,1),' ');
        assertNotEquals(floor.getFloorValue(1,1),'v');
        assertNotEquals(floor.getFloorValue(1,1),'>');
        assertNotEquals(floor.getFloorValue(1,1),'<');
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