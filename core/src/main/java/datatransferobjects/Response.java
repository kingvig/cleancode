package datatransferobjects;

import java.util.ArrayList;
import java.util.List;

public final class Response {
    final private String message;
    final private boolean success;
    private List<String> errorList = new ArrayList<>();

    public Response(boolean success, String message, List<String> errors) {
        this.message = message;
        this.errorList = errors;
        this.success = success; //true or false
    }

    public void addError(String error) {
        this.errorList.add(error);
    }

    public String getMessage() {
        return message;
    }
    public boolean getSuccess() {
        return success;
    }
    public List<String> getErrors() {
        return errorList;
    }
}
