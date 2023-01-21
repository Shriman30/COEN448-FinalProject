package org.example;

public class Floor {
    private char [][] floor;
    private int size, rows, cols = 0;

    public Floor(){
        // this.rows = rows;
        // this.cols = cols;
    }

    public void drawOnFloor(int x_position, int y_position, char val){
        this.floor[y_position][x_position] = val;
    }

    // Method used to initialize the floor according to the given requirements: called in the constructor
    public void initializeFloor(){
        this.rows = this.size;
        this.cols = this.size;
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

        public void setFloor(String commands) {
            // Initial input commands to set floor
            String[] commandParameters = commands.split(" ");
            if (commandParameters.length == 2) {
                if (commandParameters[0].equals("I") || commandParameters[0].equals("i")) {
                    if (isInputParameterNumeric(commandParameters[1])) {
                        this.size = Integer.parseInt(commandParameters[1]);
                    }
                }
            }
        }

        // Method used to validate whether an input parameter is numeric or alphabetic
        public boolean isInputParameterNumeric(String val) {
            if (val == null)
                return false;
            try {
                int i = Integer.parseInt(val);
                return true;
            } catch (NumberFormatException number) {
                return false;
            }
        }

        public int getSize(){
            return this.size;
        }

        public int getColumns(){
            return this.cols;
        }

        public int getRows(){
            return this.rows;
        }
}
