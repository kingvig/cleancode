package controller;

import java.util.Scanner;

public class ControllerFacade {
     ContestCreationController creationController;

    public ControllerFacade(ContestCreationController creationController) {
         this.creationController = creationController;
    }

    //controller handles user input and decides what to do with it
    public void run()  {
        //get user input

        String userInput;
        do
        {
            System.out.println("Select one operation (1 or 2) or quit:");
            System.out.println("1. Contest Creation");
            System.out.println("2. another use case - not implemented");

            Scanner sc = new Scanner(System.in);
            userInput = sc.nextLine();

            switch (userInput) {
                case "1":
                    creationController.run();
                    break;
                case "quit":
                    break;
            }

        } while (!userInput.equals("quit"));
    }
}
