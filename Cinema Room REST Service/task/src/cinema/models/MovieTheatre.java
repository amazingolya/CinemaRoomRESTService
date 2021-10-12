package cinema.models;

import java.util.*;

public class MovieTheatre {
    private final int rows;
    private final int columns;
    private final Seat[][] seats;
    private final Map<UUID, Seat> bookedSeats = new HashMap<>();
    private int income = 0;

    public MovieTheatre(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = fillInSeats(rows, columns);
    }

    private Seat[][] fillInSeats(final int rows, final int columns) {
        Seat[][] seats = new Seat[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat(i + 1, j + 1);
            }
        }
        return seats;
    }

    private List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat[] seat : seats) {
            for (int j = 0; j < seats.length; j++) {
                if (seat[j].isAvailable()) {
                    availableSeats.add(seat[j]);
                }
            }
        }
        return availableSeats;
    }

    public UUID bookSeat(final Seat seat) {
        UUID token = UUID.randomUUID();
        seat.purchase();
        bookedSeats.put(token, seat);
        income += seat.getPrice();
        return token;
    }

    public Info getAvailableSeatsInfo() {
        return new Info(rows, columns, getAvailableSeats());
    }

    public Seat getSeat(final int row, final int column) {
        return seats[row - 1][column - 1];
    }

    public Seat getBookedTicket(final UUID token) {
        return bookedSeats.get(token);
    }

    public void returnTicket(final UUID token, final Seat seat) {
        seat.returned();
        bookedSeats.remove(token, seat);
        income -= seat.getPrice();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getNumberOfAvailableSeats() {
        return getAvailableSeats().size();
    }
    public int getIncome() {
        return income;
    }
    public int getNumberOfPurchasedTickets() {
        return bookedSeats.size();
    }
}

