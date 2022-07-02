import java.util.ArrayList;

public class Train {
    private String trainId;
    private String trainType;
    private ArrayList<Seat> seatList= new ArrayList<Seat>();

    public Train(String trainId, String trainType) {
        this.trainId = trainId;
        this.trainType = trainType;
        for (int i = 1; i<43;i++){
            Seat seat = new Seat(i, null, true);
            seatList.add(seat);
        }
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

    public boolean seatCheck(Train train, int seatNo){
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
