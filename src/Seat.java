public class Seat {
    private int seatId;
    private String customerId;
    private boolean availability;

    public Seat(int seatId, String customerId, boolean availability) {
        this.seatId = seatId;
        this.customerId = customerId;
        this.availability = availability;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
