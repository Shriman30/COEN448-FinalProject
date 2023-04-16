package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Getting user input for initial floor size
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please Enter Command to initialize floor:");
        String commands = scanner.nextLine();
        if(commands.length() < 3){
            System.out.println("The command that you entered is not a valid initialization command. Please restart and try again!");
            scanner.close();
            return;
        }
        commands = cleanInputString(commands);
        Floor floor = new Floor();
        // Setting floor size
        floor.setFloor(commands);
        // Passing floor to this robot to use
        Robot robot = new Robot(floor);
        List<String> commandHistory = new ArrayList<String>();
        while(true){
            System.out.println("Please Enter Command:");
            commands = scanner.nextLine();
            commands = cleanInputString(commands);
            String [] commandParameters = commands.split(" ");
            commandHistory.add(commands);
            // if command is H or h, replay command history
            if(commandParameters.length == 1 && (commandParameters[0].equals("H") || commandParameters[0].equals("h"))){
                System.out.println("Command History:");
                for (int i =0;i<commandHistory.size();i++){
                    System.out.println(commandHistory.get(i));
                }
//                continue; // continue to the next iteration of the while loop
            }

            // if commandParameters length is 1, then make sure that it is a string
            if(commandParameters.length == 1){
                if(!robot.isInputParameterNumeric(commandParameters[0])){
                    // if the command is up or down set the pen position accordingly
                        robot.setPen(commandParameters[0]);
                    // if the command is left or right, then rotate the robot accordingly
                        robot.setFacingDirection(commandParameters[0]);
                    // if the command is  C, then print the current status of the robot and its pen
                    if(commandParameters[0].equals("C") || commandParameters[0].equals("c")){
                        System.out.println(robot.printRobotStatus());
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
            // if the commandParameters length <1 or >2
            else System.out.println("Invalid command, please try again.");
        }


        scanner.close();
    }

    public static String cleanInputString(String userInput){
        userInput = userInput.trim();
        return userInput;
    }
}