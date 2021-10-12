package cinema.models;

public class Error {
    private final String error;

    public Error(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }
}
