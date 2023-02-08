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

        Robot robot = new Robot(floor);
        robot.setPen("D");
        robot.setIsFacing("NORTH");
        robot.moveRobotForward(2);
        floor.printFloor();

        assertEquals( '*', floor.getFloorValue(0,0), '1');
        assertEquals( '*', floor.getFloorValue(0,1), '1');
    }

    @Test
    void drawOnFloor100(){
        // testing for floor size 100
        Floor floor = new Floor();
        floor.setFloor("I 100");
        floor.initializeFloor();

        Robot robot = new Robot(floor);
        robot.setPen("D");

        robot.setPen("D");
        robot.setIsFacing("NORTH");
        robot.moveRobotForward(99);
        robot.setIsFacing("EAST");
        robot.moveRobotForward(99);
        robot.setIsFacing("SOUTH");
        robot.moveRobotForward(99);
        floor.printFloor();

        assertEquals( '*', floor.getFloorValue(0,0), '1');
        assertEquals( '*', floor.getFloorValue(0,1), '1');
    }

    @Test
    void notdrawOnFloor(){
        Floor floor = new Floor();
        floor.setFloor("I 3");
        floor.initializeFloor();
        Robot robot = new Robot(floor);
        robot.setIsFacing("NORTH");
        robot.moveRobotForward(2);
        floor.printFloor();
        assertEquals( ' ', floor.getFloorValue(0,0), '0');
        assertEquals( ' ', floor.getFloorValue(0,1), '0');

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