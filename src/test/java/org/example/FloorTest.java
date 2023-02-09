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



    @Test void isFloorSquare100(){
        for (int i = 0; i < 100; i++) {
            Floor floor = new Floor();
            floor.setSize(i);
            floor.initializeFloor();
            // Check if floor is Square
            assertEquals(floor.getRows(), floor.getColumns());
        }
    }

    @Test
    void printFloor() {
    }

    // Check every position in matrix for its initialized value of '0'
    // For Requirement R1
    @org.junit.jupiter.api.Test
    public void checkFloorForInitializedValues(){
        int floorSize = 10;
        for (int i = 1; i < floorSize; i++) {
            Floor floor = new Floor();
            // uses a 'user input'
            floor.setFloor("I " + i);
            floor.initializeFloor();
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i; k++) {
                    assertEquals('0', floor.getFloorValue(k, j));
                }
            }
            

        }
    }

    // Test for R1, to check for NxN 
    // Tests all the way till 100x100
    @org.junit.jupiter.api.Test
    public void floorSizeTest(){
        int testSize = 100;
        
        for (int i = 1; i < testSize; i++) {
            Floor floor = new Floor();
            // uses a 'user input'
            floor.setFloor("I " + i);
            floor.initializeFloor();
            assertEquals(i, floor.getRows());
            assertEquals(i, floor.getColumns());
            assertEquals(i, floor.getSize());
        }
    }
}