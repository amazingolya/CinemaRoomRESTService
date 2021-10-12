package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Info {
    @JsonProperty("total_rows")
    private final int totalRows;

    @JsonProperty("total_columns")
    private final int totalColumns;

    @JsonProperty("available_seats")
    private final List<Seat> availableSeats;

    public Info(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
