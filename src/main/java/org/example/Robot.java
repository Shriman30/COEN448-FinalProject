package org.example;

import java.util.Scanner;

public class Robot {
    private char [][] floor ;
    private int rows, cols = 0;
    private Boolean isPenDown;
    private String isPenFacing;
    private int x_position, y_position, y_printPosition;    // x and y position of the robot
    private String isFacing;     // Orientation of the robot (N,E,W,S)

    //Constructor: Initialize the robot with the grid and the direction, and position [x,y] = [0,0]
    public Robot(){
        x_position =0;
        y_position =0;
        int size = 0;

        Scanner scanner = new Scanner (System.in);
        System.out.println("Please Enter Command:");
        String commands = scanner.nextLine();
        String [] commandParameters = commands.split(" ");
        if(commandParameters.length == 2){
            if(commandParameters[0].equals("I") || commandParameters[0].equals("i")){
                if(isInputParameterNumeric(commandParameters[1])){
                    size = Integer.parseInt(commandParameters[1]);
                }
            }
        }
        initializeEnvironment(size);
    }

    // Method used to validate whether an input parameter is numeric or alphabetic
    public boolean isInputParameterNumeric(String val){
        if(val == null) return false;
        try{
            int i = Integer.parseInt(val);
            return true;
        }catch(NumberFormatException number){
            return false;
        }
    }

    // Method used to initialize the floor according to the given requirements: called in the constructor
    public void initializeEnvironment(int size){
        this.rows = size;
        this.cols = size;
        this.floor = new char[rows][cols];

        for(int i=0;i<this.rows; i++){
            for (int j=0;j<this.cols; j++){
                floor[i][j] = '0';
            }
        };
        this.isPenFacing = "Up";
        this.isFacing = "NORTH";

        y_position = rows-1;
        y_printPosition = 0;
        floor[y_position][x_position] = '^';
    }

    // SETTERS
    private void setIsFacing(String isFacing){
        this.isFacing = isFacing;
    }
    private void setIsPenFacing(String isPenFacing){
        this.isPenFacing = isPenFacing;
    }
    private void setIsPenDown(boolean isPenDown){
        this.isPenDown = isPenDown;
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
    /* Todo: Refactor such that we store the cell where the robot is headed towards and keep track of it for
     *   when the robot moves away from that cell, we will put back the previous value. If the robot drew, then we will
     *   simply put a 1 on the cell where the robot was and move on
     */
    public void moveRobotForward(int steps){
        if(isFacing == "NORTH") {
            y_position  -= steps;
            y_printPosition = y_position+ steps;
            floor[y_position][x_position] = '^';
        }
        if(isFacing == "SOUTH") {
            y_position  += steps;
            y_printPosition = y_position-steps;
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


    // This method is used enable or disable the robot from drawing
    public void setPen (String command) {
        if(command.equals("U") || command.equals("u")){
            setIsPenDown(false);
            setIsPenFacing("Up");
        } else if(command.equals("D") ||command.equals("d")) {
            setIsPenDown(true);
            setIsPenFacing("Down");;
        }
    }

    // Method used to draw at the current position if the pen is down
    public void drawOnFloor(int x_position, int y_position){
        if(isPenDown){
            floor[y_position][x_position] ='1';
        }
    }

    // This method prints the current position of the pen, whether it is facing up/down and the direction (NEWS)
    public void printRobotStatus(){
        /*TODO: The isPenFacing and isFacing variables are not being updated. Need to check that*/
        System.out.println("Position:" + x_position + ", " + y_printPosition + " --" + "Pen: "+isPenFacing+ " --" + "Facing: "+ isFacing +" ");
    }

    // Method used to show the user the floor traversed by the robot
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
