package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


class RobotTest {

    @org.junit.jupiter.api.Test
    void isInputParameterNumeric() {
    }

    @org.junit.jupiter.api.Test
    void initializeEnvironment() {
        
    }

    @org.junit.jupiter.api.Test
    void setFacingDirection() {
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
        assertEquals(robo.getYposition(), 2);

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
    void setPen() {
    }

    @org.junit.jupiter.api.Test
    void drawOnFloor() {
    }

    @org.junit.jupiter.api.Test
    void printRobotStatus() {
    }

    @org.junit.jupiter.api.Test
    void printFloor() {
    }
}