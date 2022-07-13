import java.util.ArrayList;
import java.util.Date;

public class Train {
    private String trainId;
    private String trainType;
    private ArrayList<Seat> seatList= new ArrayList<Seat>();
    private Station startingStation;
    private Station endingStation;
    private Date date;

    public Train(String trainId, String trainType, Station startingStation, Station endingStation, Date date) {
        this.trainId = trainId;
        this.trainType = trainType;
        for (int i = 1; i< TrainBookingSystem.SEATING_CAPACITY+1 ;i++){
            Seat seat = new Seat(i, null, true);
            seatList.add(seat);
        }
        this.startingStation=startingStation;
        this.endingStation=endingStation;
        this.date = date;
    }
    public Train(){

    }
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public Station getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(Station startingStation) {
        this.startingStation = startingStation;
    }

    public Station getEndingStation() {
        return endingStation;
    }

    public void setEndingStation(Station endingStation) {
        this.endingStation = endingStation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // FIxME seatAvailabilityCheck should get the starting and ending stations from booking and checks if user input stations do not overlap
    public boolean seatAvailabilityCheck(Train train, int seatNo, Station startingStart, Station stationEnd){
        boolean availability = true;
        for (Seat seat: train.getSeatList()){
            if(seat.getSeatId() == seatNo){
                availability = seat.isAvailability();
                break;
            }
        }
        return availability;
    }

    public void printSeatList(Train train){
        StringBuilder availableSeats = new StringBuilder("");
        for (Seat seat: train.getSeatList()){
            if(seat.isAvailability()){
                if(seat.getSeatId()==42){
                    availableSeats.append(seat.getSeatId());
                }
                else{
                    availableSeats.append(seat.getSeatId()).append(", ");
                }
            }
        }
        if (availableSeats.toString().equals("")){
            System.out.println("No seat available on this train");
        }else{
            System.out.println(availableSeats.toString());
        }
        System.out.println(" ");
    }
}
