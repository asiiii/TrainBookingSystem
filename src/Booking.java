import java.util.ArrayList;
import java.util.Date;

public class Booking {
    private String bookingId;
    java.util.Date date;
    private String custId;
    private Train trainId;
    private ArrayList<Seat> seatList;
    private Station boardingStation;
    private Station exitStation;

    public Booking(String bookingId, Date date, String custId, Train trainId, Seat seat, Station boardingStation, Station exitStation) {
        this.bookingId=bookingId;
        this.date = date;
        this.custId = custId;
        this.trainId = trainId;
        this.seatList = new ArrayList<Seat>();
        seatList.add(seat);
        this.boardingStation = boardingStation;
        this.exitStation = exitStation;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Train getTrainId() {
        return trainId;
    }

    public void setTrainId(Train trainId) {
        this.trainId = trainId;
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public Station getBoardingStation() {
        return boardingStation;
    }

    public void setBoardingStation(Station boardingStation) {
        this.boardingStation = boardingStation;
    }

    public Station getExitStation() {
        return exitStation;
    }

    public void setExitStation(Station exitStation) {
        this.exitStation = exitStation;
    }

    private void addSeat(Seat seat){
        this.seatList.add(seat);
    }

    private void deleteSeat(Seat seat){
        for(Seat s:this.seatList){
            if(s.equals(seat)){
                this.seatList.remove(seat);
            }
        }
    }
}
