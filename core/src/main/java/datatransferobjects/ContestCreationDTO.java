package datatransferobjects;

import java.time.LocalDate;

public final class ContestCreationDTO {
    //univ name, univ address,
    //contest attributes
    public String univName;
    public String univAddress;
    public String code;
    public String name;
    public LocalDate startDate;
    public LocalDate endDate;

    public ContestCreationDTO(String univName, String univAddress, String code, String name, LocalDate startDate, LocalDate endDate) {
        this.univName = univName;
        this.univAddress = univAddress;
        this.code = code;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
