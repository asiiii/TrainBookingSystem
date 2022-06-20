import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainBookingSystem implements BookingSystem{
    static final int SEATING_CAPACITY = 42;
    static final ArrayList<Station> stationList = new ArrayList<Station>();
    static final String stations[] = {"Colombo", "Polgahawela", "Gampola","Nawalapitiya", "Hatton", "Rozella", "Talawakele", "Nanuoya", "Haputale", "Diyatalawa", "Bandarawela", "Ella","Badulla"};
    static final String validEntries[] = {"A", "V", "E", "D", "F", "L", "S","O", "Q"};
    static final ArrayList<Customer> customerDetails = new ArrayList<Customer>();

    // method to create Station instances
    public static void addStationList(){
        for (int i = 0; i<stations.length;i++){
            String stationId = "st" + i;
            Station station = new Station(stationId, stations[i]);
            stationList.add(station);
        }
        //System.out.println(stationList.toString());
    }
    //checks the value entered as a menu option, only valid entries are allowed
    public static String checkInput(){
        String userInput;
        while (true){
            Scanner scan= new Scanner(System.in);
            System.out.print("Enter your option: ");
            userInput = scan.next().toUpperCase();
            boolean check = false;
            for (String s : validEntries){
                if(s == userInput){
                    return userInput;
                }
            }
            if (!check){
                continue;
            }

        }
    }

    public static void addSeats() {
    }

    public static void viewAllSeats() {
    }

    public static void emptySeats() {
    }

    public static void deleteSeats() {
    }

    public static void findSeats() {
    }

    public static void storeData() {
    }

    public static void loadData() {
    }

    public static void seatOrder() {
    }
}
