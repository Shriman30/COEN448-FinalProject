package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;



class RobotTest {

    @org.junit.jupiter.api.Test
    public void checkOutOfBounds(){
        int size = 100;
        int stepsOutOfBounds = 10;
        // Checking out of bounds for floors up to size 'size' going north
        Floor fl = new Floor();
        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i, and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("NORTH");
                robot.moveRobotForward(i+j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(fl.getSize() - 1,robot.getYposition());
            }

        }

        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i, and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("SOUTH");
                robot.moveRobotForward(i+j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(0,robot.getYposition());
            }

        }

        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i, and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("EAST");
                robot.moveRobotForward(i+j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(fl.getSize() - 1,robot.getXposition());
            }

        }

        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i, and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("WEST");
                robot.moveRobotForward(i+j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(0,robot.getXposition());
            }

        }

    }

    @org.junit.jupiter.api.Test
    void isInputParameterPositiveNumeric() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        assertEquals(true, robot.isInputParameterNumeric("6"));
    }
    @org.junit.jupiter.api.Test
    void isInputParameterNegativeNumeric() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        assertFalse(robot.isInputParameterNumeric("-5"));
    }
    @org.junit.jupiter.api.Test
    void isInputParameterNonNumeric() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        assertFalse(robot.isInputParameterNumeric("N"));
    }

    @org.junit.jupiter.api.Test
    void initializeEnvironment() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.initializeEnvironment(5);
        assertEquals("Up", robot.getIsPenFacing());
        assertEquals("NORTH", robot.getIsFacing());
        assertEquals(0, robot.getYposition());
    }

    @org.junit.jupiter.api.Test
    void setFacingDirectionNorthToWest() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("NORTH");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("WEST", robot.getIsFacing());

    }
    @org.junit.jupiter.api.Test
    void setFacingDirectionNorthToEast() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("NORTH");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("EAST", robot.getIsFacing());

    }
    @org.junit.jupiter.api.Test
    void setFacingDirectionEastToNorth() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("EAST");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("NORTH", robot.getIsFacing());

    }
    @org.junit.jupiter.api.Test
    void setFacingDirectionEastToSouth() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("EAST");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("SOUTH", robot.getIsFacing());
    }
    @org.junit.jupiter.api.Test
    void setFacingDirectionSouthToEast() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("SOUTH");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("EAST", robot.getIsFacing());

    }
    @org.junit.jupiter.api.Test
    void setFacingDirectionSouthToWest() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("SOUTH");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("WEST", robot.getIsFacing());

    }
    @org.junit.jupiter.api.Test
    void setFacingDirectionWestToSouth() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("WEST");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("SOUTH", robot.getIsFacing());

    }

    @org.junit.jupiter.api.Test
    void setFacingDirectionWestToNorth() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        robot.setIsFacing("WEST");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("NORTH", robot.getIsFacing());

    }


    @org.junit.jupiter.api.Test
    void moveRobotForward0Steps() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robot = new Robot(floor);
        robot.setIsFacing("NORTH");

        // Don't move robot any steps so should maintain initial position of (0,0)
        robot.moveRobotForward(0);
        assertEquals(robot.getXposition(), 0);
        assertEquals(robot.getYposition(), 0);

    }

    @org.junit.jupiter.api.Test
    void moveRobotNorth2Steps(){
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robot = new Robot(floor);
        robot.setIsFacing("NORTH");
        robot.moveRobotForward(2);
        assertEquals(robot.getXposition(),0);
        assertEquals(robot.getYposition(), 2);
    }

    @org.junit.jupiter.api.Test
    void setPenUp() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("U");
        assertEquals("Up",robot.getIsPenFacing());
    }
    @org.junit.jupiter.api.Test
    void setPenDown() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("D");
        assertEquals("Down",robot.getIsPenFacing());
    }
    @org.junit.jupiter.api.Test
    void setPenNotUp() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("U");
        assertNotEquals("Down",robot.getIsPenFacing());
    }
    @org.junit.jupiter.api.Test
    void setPenNotDown() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("D");
        assertNotEquals("Up",robot.getIsPenFacing());
    }
    @org.junit.jupiter.api.Test
    void drawOnFloor() {
    }

    @org.junit.jupiter.api.Test
    void printRobotStatus() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot Robo = new Robot(floor);
        // Checking if print is correct with documentation
       assertEquals("Position: 0, 0 - Pen: up - Facing: north", Robo.printRobotStatus());
    }

    @org.junit.jupiter.api.Test
    void printFloor() {

    }

    // For Requirement 1
    // R1: The floor must be represented as a two dimensional array that will be initialized to a size of NxN,
    //  where N is any integer greater than 1 and each floor cell will be initialized to an alphanumeric 
    //  character of ‘0’. 
    // This initialization must be a user-defined input and must be of the format “i N’ or “I N”.

    // Test for R1, to check for NxN 
    @org.junit.jupiter.api.Test
    public void floorSizeTest(){
        int testSize = 100;
        
        for (int i = 1; i < testSize; i++) {
            Floor floor = new Floor();
            floor.setSize(i);
            floor.initializeFloor();
            assertEquals(i, floor.getRows());
            assertEquals(i, floor.getColumns());
            assertEquals(i, floor.getSize());
        }
    }
}