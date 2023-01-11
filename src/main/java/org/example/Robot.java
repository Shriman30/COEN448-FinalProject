package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Robot {

    private char [][] floor ;
    private int rows, cols = 0;
    // Pen position:
    private Boolean isPenUp = true;
    private Boolean isPenDown = false;

    // x and y position of the robot
    private int x_position, y_position;
    private char prevVal=' ';

    // Orientation (N,E,W,S)
    private String isFacing;

    //Constructor: Initialize the robot with the grid and the direction, and position [x,y] = [0,0]
    public Robot(){
        x_position =0;
        y_position =0;
        // Initialize function
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please initialize your environment:");

        int size = 1;
        String commands = scanner.nextLine();
        String [] commandParameters = commands.split(" ");
        if(commandParameters.length == 2){
            if(commandParameters[0].equals("I") || commandParameters[0].equals("i")){
                if(isSecondInputParameterNumeric(commandParameters[1])){
                    size = Integer.parseInt(commandParameters[1]);
                }
            }
        }
        initializeEnvironment(size);
    }

    public boolean isSecondInputParameterNumeric(String val){
        if(val == null) return false;
        try{
            int i = Integer.parseInt(val);
        }catch(NumberFormatException number){
            return false;
        }
        return true;
    }
    public void initializeEnvironment(int size){
        this.rows = size;
        this.cols = size;
        this.floor = new char[rows][cols];
        for(int i=0;i<this.rows; i++){
            for (int j=0;j<this.cols; j++){
                floor[i][j] = '0';
            }
        };
        this.isFacing = "NORTH";
        y_position = rows-1;
        floor[y_position][x_position] = '^';
    }

    // This method is used to set the direction the robot is facing, i.e., turn the robot (N,E,S,W)
    public void setFacingDirection(String turnCommand){
        if(isFacing == "NORTH") {
            if (turnCommand == "L" || turnCommand == "l") {isFacing = "WEST";}
            else if( turnCommand == "R"|| turnCommand =="r"){isFacing = "EAST";}
        } else if(isFacing == "EAST"){
            if (turnCommand == "L" || turnCommand == "l") {isFacing = "NORTH";}
            else if( turnCommand == "R"|| turnCommand =="r"){isFacing = "SOUTH";}

        }else if(isFacing == "SOUTH"){
            if (turnCommand == "L" || turnCommand == "l") {isFacing = "EAST";}
            else if( turnCommand == "R"|| turnCommand =="r"){isFacing = "WEST";}

        } else if (isFacing == "WEST"){
            if (turnCommand == "L" || turnCommand == "l") {isFacing = "SOUTH";}
            else if( turnCommand == "R"|| turnCommand =="r"){isFacing = "NORTH";}
        }

    }

    // This method is used to set the number of steps the robot will be able to take moving forward.
    /* Todo: Need to refactor this so that:
        the old position gets erased and replaced with a 0 if nothing is drawn, a 1 if something was drawn,
        temporarily replace any drawn value on the currently sitting floor cell with the robot
        put back the old value once the robot has moved */

    public void moveRobotForward(int steps){ // The lowest position the robot can move to is [0,y] vertically and [x,0] horizontally
        if(isFacing == "NORTH") {
            y_position  -= steps;
            floor[y_position][x_position] = '^';
        }
        if(isFacing == "SOUTH") {
            y_position  += steps;
            floor[y_position][x_position] = 'V';
        }
        if(isFacing == "EAST") {
            x_position += steps;
            floor[y_position][x_position] = '>';
        }
        if(isFacing == "WEST") {
            x_position -= steps;
            floor[y_position][x_position] = '<';
        }
    }

    // This method will be used to navigate the robot in the specified direction
    public void navigateRobot(String command, int steps){
        setFacingDirection(command);
        moveRobotForward(steps);
    }

    // This method is used enable or disable the robot from drawing
    public void setPen (String command) {
        if(command == "U" || command == "u"){
            isPenUp = true;
            isPenDown = false;
        } else if(command == "D" ||command=="d") {
            isPenDown = true;
            isPenUp = false;
        }
    }

    // Method used to draw at the current position if the pen is down
    public void drawOnFloor(int x, int y){
        if(isPenDown){

        }
    }

    public void printFloor(){
        // printing of the floor
        for (int i=0;i< rows;i++){
            System.out.print("|");
            for (int j=0; j<cols;j++){
                // replacing all ones with *
                if(floor[i][j] == '1'){floor[i][j] = '*';}

                // printing the floor
                System.out.print( floor[i][j]+"|");
                if(j == cols-1) System.out.println(" ");
            }
        }
    }



}
