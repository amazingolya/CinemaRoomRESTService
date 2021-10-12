package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PurchasedTicket {
    private final UUID token;
    @JsonProperty("ticket")
    private final Seat seat;

    public PurchasedTicket(UUID token, Seat seat) {
        this.token = token;
        this.seat = seat;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getSeat() {
        return seat;
    }
}
