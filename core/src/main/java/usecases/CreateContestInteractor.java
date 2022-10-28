package usecases;

import datatransferobjects.ContestCreationDTO;
import datatransferobjects.Response;
import entities.Contest;
import entities.University;
import gateways.IRepository;

import java.util.ArrayList;
import java.util.UUID;

/**
 * this class implements the steps and variations of your use case
 */
public class CreateContestInteractor {
    final private IRepository<Contest> memoryRepository;

    public CreateContestInteractor(IRepository<Contest> memoryRepository) {
       //the services are given through dependency injection
        this.memoryRepository = memoryRepository;
    }

    public Response handle (ContestCreationDTO request) {
        //implement here the steps and the variations of your use case
        //request is the data transfer object that gives you input from the user
        //Response is the data transfer object that you will fill with information for the user
        // (errors/ messages/ list of entities for display...)
        Contest contest = new Contest(UUID.randomUUID(), request.code, request.name, request.startDate, request.endDate,
                new University(UUID.randomUUID(), request.univName, request.univAddress));
        //save the new contest to the repository
        //repository is created somewhere else
        memoryRepository.addEntity(contest);

        memoryRepository.searchByFilter(s -> s.getCode().equals(request.code));

        ArrayList<String> errors = new ArrayList<>();
        //TODO error handling here (as described in the use case)
        return new Response(true, "contest added successfully", errors);
    }
}
