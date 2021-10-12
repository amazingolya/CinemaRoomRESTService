package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidPasswordException extends ResponseStatusException {
    public InvalidPasswordException(final String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
