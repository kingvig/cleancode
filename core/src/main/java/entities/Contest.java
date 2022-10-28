package entities;

import java.time.LocalDate;
import java.util.UUID;

public class Contest extends Entity {
    private String code;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private University university;

    public Contest(UUID id, String code, String name, LocalDate startDate, LocalDate endDate, University univ) {
        this.code = code;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
        this.university = univ;
    }

    public void setCode(String code) {
        this.code = code;
    }
    //add the rest of the methods set/get if needed
    //add other methods that make sense for your use case
    public String getCode() {
        return code;
    }
}
