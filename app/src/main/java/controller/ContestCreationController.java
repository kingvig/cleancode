package controller;

import datatransferobjects.ContestCreationDTO;
import entities.Contest;
import gateways.IRepository;
import usecases.CreateContestInteractor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ContestCreationController {
    IRepository<Contest> contestRepository;
    //this controller works with a contestRepository;
    //because we have a memory repository, we must initialize it
    // outside the controller, otherwise its state is lost
    public ContestCreationController(IRepository<Contest> contestRepository) {

        this.contestRepository = contestRepository;
    }

    public void run() {
        String userInput;
        do
        {
            System.out.println("Contest Creation");
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter university name or 'quit':");
            userInput = sc.nextLine();
            if (userInput.equals("quit")) return;
            String univName = userInput;

            System.out.println("Enter university address or 'quit':");
            userInput = sc.nextLine();
            if (userInput.equals("quit")) return;
            String univAddress = userInput;

            System.out.println("Enter contest code or 'quit':");
            userInput = sc.nextLine();
            if (userInput.equals("quit")) return;
            String contestCode = userInput;

            System.out.println("Enter contest name or 'quit':");
            userInput = sc.nextLine();
            if (userInput.equals("quit")) return;
            String contestName = userInput;

            System.out.println("Enter contest start date as yyyy-MM-dd or 'quit':");
            userInput = sc.nextLine();
            if (userInput.equals("quit")) return;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate contestStartDate = LocalDate.now();
            try {
                contestStartDate = LocalDate.parse(userInput, formatter);
            } catch (DateTimeParseException ex) {
                ex.printStackTrace();
                //TODO try again
            }

            System.out.println("Enter contest end date as yyyy-MM-dd or 'quit':");
            userInput = sc.nextLine();
            if (userInput.equals("quit")) return;
            LocalDate contestEndDate = LocalDate.now();
            try {
                contestEndDate = LocalDate.parse(userInput, formatter);
            } catch (DateTimeParseException ex) {
                ex.printStackTrace();
                //TODO try again
            }

            //*************************************************************************************************
            // connecting the app with the Use Case Interactor
            //*************************************************************************************************
            // 1. create the request message passing with the target student id and a list of selected contest codes
            var useCaseRequestMessage = new ContestCreationDTO(univName, univAddress, contestCode, contestName, contestStartDate, contestEndDate);

            // 2. instantiate Contest Registration Use Case injecting gateways
            //the repository cannot be instantiated here because it would be emptied at each user input
            //so I put it as a private attribute and instantiate it in main
            var contestCreationRequestUseCase = new CreateContestInteractor(contestRepository);


            // 3. call the use case and store the response
            var responseMessage = contestCreationRequestUseCase.handle(useCaseRequestMessage);

            //display the response
            System.out.println(responseMessage.getMessage());
            // 4. use a Presenter to format the use case response and display it
            // Presenter also displays to its associated view

        } while (true);
    }
}
