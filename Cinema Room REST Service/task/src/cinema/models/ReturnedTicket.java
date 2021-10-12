package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnedTicket {
    @JsonProperty("returned_ticket")
    private final Seat seat;

    public ReturnedTicket(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }
}
