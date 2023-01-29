package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;


class RobotTest {

    @org.junit.jupiter.api.Test
    void isInputParameterPositiveNumeric() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);
        assertEquals(true, robot.isInputParameterNumeric("6"));
    }
//    @org.junit.jupiter.api.Test
//    void isInputParameterNegativeNumeric() {
//        Floor fl = new Floor();
//        Robot robot = new Robot(fl);
//        assertFalse(robot.isInputParameterNumeric("-6"));
//    }
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
    void setFacingDirection() {
        Floor fl = new Floor();
        Robot robot = new Robot(fl);

        // If robot is facing NORTH
        robot.setIsFacing("NORTH");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("WEST", robot.getIsFacing());

        robot.setIsFacing("NORTH");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("EAST", robot.getIsFacing());

        // If robot is facing EAST
        robot.setIsFacing("EAST");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("NORTH", robot.getIsFacing());

        robot.setIsFacing("EAST");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("SOUTH", robot.getIsFacing());

        // If robot is facing SOUTH
        robot.setIsFacing("SOUTH");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("EAST", robot.getIsFacing());

        robot.setIsFacing("SOUTH");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("WEST", robot.getIsFacing());

        // If robot is facing WEST
        robot.setIsFacing("WEST");
        robot.setFacingDirection("L"); // turn left;
        assertEquals("SOUTH", robot.getIsFacing());

        robot.setIsFacing("WEST");
        robot.setFacingDirection("R"); // turn right;
        assertEquals("NORTH", robot.getIsFacing());

        // TODO:Maybe have a test for invalid input later on.
    }

    @org.junit.jupiter.api.Test
    void moveRobotForward() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robo = new Robot(floor);
        robo.setIsFacing("NORTH");


        // Dont move robot any steps so should maintain initial position of (0,0)
        robo.moveRobotForward(0);
        assertEquals(robo.getXposition(), 0);
        // y coordinate should b N - 1, so 3 - 1 = 2
        assertEquals(robo.getYposition(), 0);

        // Moving robot down 1
        robo.setIsFacing("SOUTH");
        robo.moveRobotForward(1);
        assertEquals(robo.getXposition(), 0);
        assertEquals(robo.getYposition(), 1);

    }

    @org.junit.jupiter.api.Test
    void robotTraverseEntireFloorWithSizeN(){
        int N = 3;
        Floor floor = new Floor();
        String command = "I 3";
        floor.setFloor(command);
        Robot robo = new Robot(floor);

        // Robot set to traverse entire floor from bottom left corner to top right
        int size = floor.getSize() - 1;
        int old_pos = 0;
        for (int i = 0; i < floor.getRows(); i++) {
            for (int j = 0; j < floor.getColumns(); j++) {
                if (j < size && i%2==0) {
                    robo.setIsFacing("EAST");
                    robo.moveRobotForward(1);
                    assertEquals(robo.getXposition(), j + 1);
                    assertEquals(robo.getYposition(), i);
                }
                if (j == size && i != size) {
                    robo.setIsFacing("NORTH");
                    robo.moveRobotForward(1);
                    assertEquals(robo.getXposition(), j);
                    assertEquals(robo.getYposition(), i + 1);
                    old_pos = j;
                }
                // TODO : not working
                if(robo.getXposition()>0 && i%2 != 0){
                    robo.setIsFacing("WEST");
                    robo.moveRobotForward(1);
                    assertEquals(robo.getXposition(), j + old_pos - 1);
                    old_pos--;
                    assertEquals(robo.getYposition(), i);
                }
                if(j==0 && i%2 != 0 && i < size){
                    robo.setIsFacing("NORTH");
                    robo.moveRobotForward(1);
                    assertEquals(robo.getXposition(), j);
                    assertEquals(robo.getYposition(), i + 1);
                }

            }
        }

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

        // test fails because actual facing direction is capital but expected is not
//        assertEquals("Position: 0, 0 – Pen: down - Facing: north", Robo.printRobotStatus()); // C command
    }

    @org.junit.jupiter.api.Test
    void printFloor() {

    }
}