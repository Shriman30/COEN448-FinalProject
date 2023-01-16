package org.example;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot();
        while(true){
            Scanner scanner = new Scanner (System.in);
            System.out.println("Please Enter Command:");
            String commands = scanner.nextLine();
            String [] commandParameters = commands.split(" ");

            // if commandParameters length is 1, then make sure that it is a string
            if(commandParameters.length == 1){
                if(!robot.isInputParameterNumeric(commandParameters[0])){
                    // if the command is up or down set the pen position accordingly
                    /*TODO: We can maybe try to remove the if checks and simply do robot.setPen(commandParameters[0]),
                       since the check for up or down is being done inside setPen() already.
                    */
                    if(commandParameters[0].equals("U") || commandParameters[0].equals("u") ||
                            commandParameters[0].equals("D") || commandParameters[0].equals("d")){
                        robot.setPen(commandParameters[0]);
                    }
                    // if the command is left or right, then rotate the robot accordingly
                    /*TODO: We can maybe try to remove the if checks and simply do robot.setFacingDirection(commandParameters[0]),
                       since the check for R and L are being done inside setPen() already.
                    */
                    else if(commandParameters[0].equals("R") || commandParameters[0].equals("r") ||
                            commandParameters[0].equals("L") || commandParameters[0].equals("l")){
                        robot.setFacingDirection(commandParameters[0]);
                    }
                    // if the command is  C, then print the current status of the robot and its pen
                    else if(commandParameters[0].equals("C") || commandParameters[0].equals("c")){
                        robot.printRobotStatus();
                    }
                    // if the command is P, then display the floor
                    else if(commandParameters[0].equals("P") || commandParameters[0].equals("p")){
                        robot.printFloor();
                    }
                    // if the command is  Q, then exit the program
                    else if(commandParameters[0].equals("Q") || commandParameters[0].equals("q")){
                        break;
                    }
                }
            }
            // if the commandParameters length = 2
            else if(commandParameters.length == 2){
                // if the first parameter is a letter and the second parameter is a number
                if(!robot.isInputParameterNumeric(commandParameters[0]) && robot.isInputParameterNumeric(commandParameters[1])){
                    // if the first parameter is M, then move forward in the specified direction
                    if(commandParameters[0].equals("M")||commandParameters[0].equals("m")){
                        robot.moveRobotForward(Integer.parseInt(commandParameters[1]));
                    } else System.out.println("Invalid input, please try again.");
                }
                else System.out.println("Invalid input, please try again.");
            }
            else System.out.println("Invalid command, please try again.");
        }

        /// Todo: Make sure the user can never provide an input that would make the robot step out of the floor
    }
}