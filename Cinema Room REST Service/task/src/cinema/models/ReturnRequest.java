package cinema.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnRequest {
    private final String token;

    @JsonCreator
    public ReturnRequest(@JsonProperty String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
