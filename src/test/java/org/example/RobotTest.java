package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Test;

class RobotTest {

    @org.junit.jupiter.api.Test
    public void addHistoryTest(){
        Floor floor = new Floor();
        floor.setSize(5);
        Robot robo = new Robot(floor);
        robo.addHistory("m 2");
        robo.addHistory("d");
        robo.addHistory("u");
        List<String> commandHistory = robo.getHistoryList();
        assertEquals(commandHistory.get(0),"m 2");
        assertEquals(commandHistory.get(1),"d");
        assertEquals(commandHistory.get(2),"u");
        System.out.println("");
    }

    @org.junit.jupiter.api.Test
    void printHistoryFromMainTest() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robo = new Robot(floor);

        // For testing System.out.println() statements
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        InputStream originalIn = System.in;
        String input = "I 3\nm 2\nu\nd\nh\nq\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[] {});

        // Removing white space and line breaks due to limitations of comparing strings
        String out = outContent.toString().replaceAll("\\s", "");
        String expected = "PleaseEnterCommandtoinitializefloor:PleaseEnterCommand:PleaseEnterCommand:PleaseEnterCommand:PleaseEnterCommand:CommandHistory:m2udhPleaseEnterCommand:";

        assertEquals(expected, out);

        // Setting print back to before
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // R6
    @org.junit.jupiter.api.Test
    public void checkOutOfBoundsNorth() {
        int size = 100;
        int stepsOutOfBounds = 10;
        // Checking out of bounds for floors up to size 'size' going north
        Floor fl = new Floor();
        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i,
            // and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("NORTH");
                robot.moveRobotForward(i + j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(fl.getSize() - 1, robot.getYposition());
            }

        }
    }

    // R6
    @org.junit.jupiter.api.Test
    public void checkOutOfBoundsSouth() {
        // Checking out of bounds for floors up to size 'size' going south
        int size = 100;
        int stepsOutOfBounds = 10;
        Floor fl = new Floor();
        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i,
            // and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("SOUTH");
                robot.moveRobotForward(i + j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(0, robot.getYposition());
            }

        }
    }

    // R6
    @org.junit.jupiter.api.Test
    public void checkOutOfBoundsEast() {
        int size = 100;
        int stepsOutOfBounds = 10;
        // Checking out of bounds for floors up to size 'size' going east
        Floor fl = new Floor();

        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i,
            // and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("EAST");
                robot.moveRobotForward(i + j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(fl.getSize() - 1, robot.getXposition());
            }

        }
    }

    // R6
    @org.junit.jupiter.api.Test
    public void checkOutOfBoundsWest() {
        int size = 100;
        int stepsOutOfBounds = 10;
        // Checking out of bounds for floors up to size 'size' going north
        Floor fl = new Floor();
        for (int i = 1; i < size; i++) {
            fl.setSize(i);
            // Checking out of bounds for a floor that is size i,
            // and robot moves stepsOutOfBounds steps out of bounds
            for (int j = 0; j < stepsOutOfBounds; j++) {
                Robot robot = new Robot(fl);
                robot.setIsFacing("WEST");
                robot.moveRobotForward(i + j);
                // Robot should be at edge of floor when going out of bounds
                assertEquals(0, robot.getXposition());
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
        assertEquals(0, robot.getXposition());
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

    // R4
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

    // R4
    @org.junit.jupiter.api.Test
    void moveRobotNorth2Steps() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robot = new Robot(floor);
        robot.setIsFacing("NORTH");
        robot.moveRobotForward(2);
        assertEquals(robot.getXposition(), 0);
        assertEquals(robot.getYposition(), 2);
    }

    @org.junit.jupiter.api.Test
    void setPenUp() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("U");
        assertEquals("Up", robot.getIsPenFacing());
    }

    @org.junit.jupiter.api.Test
    void setPenDown() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("D");
        assertEquals("Down", robot.getIsPenFacing());
    }

    // R7
    @org.junit.jupiter.api.Test
    void setPenNotUp() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("U");
        assertNotEquals("Down", robot.getIsPenFacing());
    }

    // R7
    @org.junit.jupiter.api.Test
    void setPenNotDown() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        robot.setPen("D");
        assertNotEquals("Up", robot.getIsPenFacing());
    }

    @org.junit.jupiter.api.Test
    void drawOnFloor() {
    }

    // R8
    @org.junit.jupiter.api.Test
    void printRobotStatus() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot Robo = new Robot(floor);
        // Checking if print is correct with documentation
        assertEquals("Position: 0, 0 - Pen: up - Facing: north", Robo.printRobotStatus());
    }

    // R9
    @org.junit.jupiter.api.Test
    void printFloor() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robo = new Robot(floor);

        // For testing System.out.println() statements
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // moving the robot 1 north with pen down then face east, then printing
        robo.setPen("D");
        robo.moveRobotForward(1);
        robo.setIsFacing("EAST");
        robo.printFloor();

        // Removing white space and line breaks due to limitations of comparing strings
        String out = outContent.toString().replaceAll("\\s", "");
        String expected = "| | | | |*| | | |*| | | ".replaceAll("\\s", "");

        assertEquals(expected, out);

        // Setting print back to before
        System.setOut(originalOut);
    }

}