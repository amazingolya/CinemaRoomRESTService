package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics {
    @JsonProperty("current_income")
    private final int currentIncome;
    @JsonProperty("number_of_available_seats")
    private final int numberOfAvailableSeats;
    @JsonProperty("number_of_purchased_tickets")
    private final int numberOfPurchasedTickets;

    public Statistics(int currentIncome, int numberOfAvailableSeats, int numberOfPurchasedTickets) {
        this.currentIncome = currentIncome;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }
}
