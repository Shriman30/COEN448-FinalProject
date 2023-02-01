package org.example;

import java.util.Scanner;

public class Robot {
    // private char [][] floor ;
    // private int rows, cols = 0;
    private Floor floor;
    private Boolean isPenDown = false;
    private String isPenFacing;
    private int x_position, y_position, y_printPosition =0;    // x and y position of the robot
    private String isFacing;     // Orientation of the robot (N,E,W,S)

    //Constructor: Initialize the robot with the grid and the direction, and position [x,y] = [0,0]
    public Robot(Floor fl){
        x_position =0;
        y_position =0;
        this.floor = fl;
        // Sets floor to proper size and all 0
        this.floor.initializeFloor();
        initializeEnvironment(floor.getSize());
    }

    public String getIsPenFacing(){
        return isPenFacing;
    }
    public String getIsFacing(){
        return isFacing;
    }
    // Method used to validate whether an input parameter is numeric (and positive) or alphabetic
    public boolean isInputParameterNumeric(String val){
        if(val == null) return false;
        try{
            int i = Integer.parseInt(val);
            if (i < 0){
                return false;
            }
            return true;
        }catch(NumberFormatException number){
            return false;
        }
    }

    // Method used to initialize the floor according to the given requirements: called in the constructor
    public void initializeEnvironment(int size){
        this.isPenFacing = "Up";
        this.isFacing = "NORTH";

        y_position = size-1;
        y_printPosition = 0;
    }

    // SETTERS
    public void setIsFacing(String isFacing){
        this.isFacing = isFacing;
    }
    private void setIsPenFacing(String isPenFacing){
        this.isPenFacing = isPenFacing;
    }

    // This method is used to set the direction the robot is facing, i.e., turn the robot (N,E,S,W)
    public void setFacingDirection(String turnCommand){
        // check what the command is and then compare with the current position
        if(isFacing.equals("NORTH")) {
            if (turnCommand.equals("L") || turnCommand.equals("l")) {setIsFacing("WEST");}
            else if( turnCommand.equals("R")|| turnCommand.equals("r")){setIsFacing("EAST");}
        } else if(isFacing.equals("EAST")){
            if (turnCommand.equals("L") || turnCommand.equals("l")) {setIsFacing ("NORTH");}
            else if( turnCommand.equals("R")|| turnCommand.equals("r")){setIsFacing("SOUTH");}
        }else if(isFacing.equals("SOUTH")){
            if (turnCommand.equals("L") || turnCommand.equals("l")) {setIsFacing("EAST");}
            else if( turnCommand.equals("R")|| turnCommand.equals("r")){setIsFacing("WEST");}
        } else if (isFacing.equals("WEST")){
            if (turnCommand.equals("L")|| turnCommand.equals("l")) {setIsFacing("SOUTH");}
            else if( turnCommand.equals("R")|| turnCommand.equals("r")){setIsFacing ("NORTH");}
        }
    }

    // Method is used to move the robot forward by a specified number of steps.
    public void moveRobotForward(int steps){
        if(isFacing.equals("NORTH")) {
            for (int i=0;i<steps;i++){
                drawOnFloor(x_position,y_position);
                y_position--;
            }
            y_printPosition += steps;
            drawOnFloor(x_position,y_position);
        }
        if(isFacing.equals("SOUTH")) {
//            this.floor.drawOnFloor(x_position, y_position, 'v');
            for (int i=0;i<steps;i++){
                drawOnFloor(x_position,y_position);
                y_position++;
            }
            y_printPosition -= steps;
            drawOnFloor(x_position,y_position);
        }
        if(isFacing.equals("EAST")) {
            for (int i=0;i<steps;i++){
                drawOnFloor(x_position,y_position);
                x_position++;
            }
            drawOnFloor(x_position,y_position);
        }
        if(isFacing.equals("WEST")) {
            for (int i=0;i<steps;i++){
                drawOnFloor(x_position,y_position);
                x_position --;
            }
            drawOnFloor(x_position,y_position);
        }
    }


    // This method is used enable or disable the robot from drawing
    public void setPen (String command) {
        if(command.equals("U") || command.equals("u")){
            setIsPenFacing("Up");
        } else if(command.equals("D") ||command.equals("d")) {
            setIsPenFacing("Down");;
        }
    }

    // Method used to draw at the current position if the pen is down
    public void drawOnFloor(int x_position, int y_position){
        if(isPenFacing.equals("Down")){
            this.floor.drawOnFloor(x_position, y_position, '1');
        }
    }

    // This method prints the current position of the pen, whether it is facing up/down and the direction (NEWS)
    public void printRobotStatus(){
        System.out.println("Position:" + x_position + ", " + y_printPosition + " --" + "Pen: "+isPenFacing+ " --" + "Facing: "+ isFacing +" ");
    }

    // // Method used to show the user the floor traversed by the robot
    public void printFloor(){
        this.floor.printFloor();
    }

    // returns the x position of the robot
    public int getXposition(){
        return this.x_position;
    }

    // returns the y position of the robot
    public int getYposition(){
        return this.y_printPosition;
    }

}
