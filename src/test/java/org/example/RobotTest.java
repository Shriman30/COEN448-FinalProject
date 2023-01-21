package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
        // TODO : add way of implement input for robot to continue
        Robot robo = new Robot("I 3");
        robo.setIsFacing("NORTH");


        // Dont move robot any steps so should maintain initial position of (0,0)
        robo.moveRobotForward(0);
        assertEquals(robo.getXposition(), 0);
        // y coordinate should b N - 1, so 3 - 1 = 2
        assertEquals(robo.getYposition(), 2);
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