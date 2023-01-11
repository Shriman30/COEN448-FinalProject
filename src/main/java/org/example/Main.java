package org.example;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Need to refactor such that we take user command inputs.
        Robot robot = new Robot();
        robot.printFloor();
        System.out.println(" ");
        robot.navigateRobot("r",4);
        robot.navigateRobot("l",3 );
        robot.navigateRobot("r",0 );
        robot.navigateRobot("r",3 );
        /// Todo: Make sure the user can never provide an input that would make the robot step out of the floor
        robot.printFloor();
    }
}