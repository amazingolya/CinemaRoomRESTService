package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SeatUnavailableException extends ResponseStatusException {
    public SeatUnavailableException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
