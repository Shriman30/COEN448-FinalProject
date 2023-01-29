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
    void moveRobotForward0Steps() {
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robo = new Robot(floor);
        robo.setIsFacing("NORTH");


        // Dont move robot any steps so should maintain initial position of (0,0)
        robo.moveRobotForward(0);
        assertEquals(robo.getXposition(), 0);
        assertEquals(robo.getYposition(), 0);

    }

    @org.junit.jupiter.api.Test
    void moveRobotNorth2Steps(){
        Floor floor = new Floor();
        floor.setFloor("I 3");
        Robot robo = new Robot(floor);
        robo.setIsFacing("NORTH");
        robo.moveRobotForward(2);
        assertEquals(robo.getXposition(),0);
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