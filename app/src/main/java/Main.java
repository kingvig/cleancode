import controller.ContestCreationController;
import controller.ControllerFacade;
import entities.Contest;
import gateways.IRepository;
import repositories.MemoryRepository;

public class Main {
    public static void main(String[] args) {

        IRepository<Contest> contestRepository = new MemoryRepository<>();
        ContestCreationController creationController = new ContestCreationController(contestRepository);

        ControllerFacade controllerFacade = new ControllerFacade(creationController);
        controllerFacade.run();
    }
}
