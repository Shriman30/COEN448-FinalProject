package org.example;

public class Floor {
    private char [][] floor;
    private int rows, cols = 0;

    public Floor(int rows,int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public void drawOnFloor(int x_position, int y_position, char val){
        this.floor[y_position][x_position] = val;
    }

    // Method used to initialize the floor according to the given requirements: called in the constructor
    public void initializeFloor(int size){
        this.rows = size;
        this.cols = size;
        this.floor = new char[rows][cols];

        for(int i=0;i<this.rows; i++){
            for (int j=0;j<this.cols; j++){
                this.floor[i][j] = '0';
            }
        }
    }

        // Method used to show the user the floor traversed by the robot
        public void printFloor(){
            // printing of the floor
            for (int i=0;i< this.rows;i++){
                System.out.print("|");
                for (int j=0; j< this.cols;j++){
                    // replacing all ones with *
                    if(this.floor[i][j] == '1'){this.floor[i][j] = '*';}
                    if(this.floor[i][j] =='0'){this.floor[i][j] = ' ';}
                    // printing the floor
                    System.out.print( this.floor[i][j]+"|");
                    if(j == cols-1) System.out.println(" ");
                }
            }
        }
}
