package cinema.controllers;

import cinema.InvalidPasswordException;
import cinema.InvalidTokenException;
import cinema.SeatUnavailableException;
import cinema.models.Error;
import cinema.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class CinemaController {
    MovieTheatre myMovieTheatre = new MovieTheatre(9, 9);

    @GetMapping("/seats")
    public Info getAvailableSeatsInfo() {
        return myMovieTheatre.getAvailableSeatsInfo();
    }

    @PostMapping("/purchase")
    public PurchasedTicket buyTicket(@RequestBody BookingRequest bookingRequest) {
        int row = bookingRequest.getRow();
        int column = bookingRequest.getColumn();

        if (row < 0 || row > myMovieTheatre.getRows() || column < 0 || column > myMovieTheatre.getColumns()) {
            throw new SeatUnavailableException("The number of a row or a column is out of bounds!");
        }
        Seat seat = myMovieTheatre.getSeat(row, column);
        if (!seat.isAvailable()) {
            throw new SeatUnavailableException("The ticket has been already purchased!");
        } else {
            return new PurchasedTicket(myMovieTheatre.bookSeat(seat), seat);
        }
    }

    @PostMapping("/return")
    public ReturnedTicket returnTicket(@RequestBody ReturnRequest returnRequest) {
        UUID token = UUID.fromString(returnRequest.getToken());
        Seat seat = myMovieTheatre.getBookedTicket(token);
        if (seat == null) {
            throw new InvalidTokenException("Wrong token!");
        } else {
            myMovieTheatre.returnTicket(token, seat);
            return new ReturnedTicket(seat);
        }
    }

    @ExceptionHandler
    public ResponseEntity<Error> handleException(ResponseStatusException e) {
        Error error = new Error(e.getReason());
        return new ResponseEntity<>(error, e.getStatus());
    }

    @PostMapping("/stats")
    public Statistics getStats(@RequestParam(defaultValue = "") String password) {
        if (password.equals("super_secret")) {
            return new Statistics(myMovieTheatre.getIncome(), myMovieTheatre.getNumberOfAvailableSeats(),
                    myMovieTheatre.getNumberOfPurchasedTickets());
        } else {
            throw new InvalidPasswordException("The password is wrong!");
        }
    }
}
