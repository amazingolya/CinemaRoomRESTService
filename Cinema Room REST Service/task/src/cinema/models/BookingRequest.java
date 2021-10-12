package cinema.models;

public class BookingRequest {
    private final int row;
    private final int column;

    public BookingRequest(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
