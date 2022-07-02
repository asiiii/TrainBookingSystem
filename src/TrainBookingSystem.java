import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainBookingSystem implements BookingSystem{
    static final int SEATING_CAPACITY = 42;
    static final ArrayList<Station> stationList = new ArrayList<Station>();
    static final String stations[] = {"Colombo", "Polgahawela", "Gampola","Nawalapitiya", "Hatton", "Rozella", "Talawakele", "Nanuoya", "Haputale", "Diyatalawa", "Bandarawela", "Ella","Badulla"};
    static final String validEntries[] = {"A", "V", "E", "D", "F", "L", "S","O", "Q"};
    static final ArrayList<Customer> customerDetails = new ArrayList<Customer>();
    static final ArrayList<Date> dateList = new ArrayList<Date>();

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
            for (String s : validEntries){
                if(s.equals(userInput)){
                    return userInput;
                }
            }
            System.out.println("Enter a valid input!");
        }
    }

    public static void addSeats() throws ParseException {
        System.out.println("BOOK YOUR TRAIN SEAT");
        Scanner customerScan = new Scanner(System.in);

        System.out.print("Please enter date to book (dd/mm/yyyy): ");
        String dateInput = customerScan.nextLine();
        // enter a method to validate date input
        Date date = dateCheck(dateInput);

        Train train = new Train();
        int trainId=checkTrain();
        System.out.println(" ");
        if (trainId == 1){
            train = date.getTrain1();
        }else if (trainId == 2){
            train = date.getTrain2();
        }

        System.out.print("Please enter you first name: ");
        String fName = customerScan.nextLine();
        System.out.print("Please enter you last name: ");
        String lName = customerScan.nextLine();
        // check if customer already created
        Customer customer = new Customer(fName, lName);
        customerDetails.add(customer);

        while (true){
            setSeat(train, customer);
            System.out.println("Do you want to book another seat on the same train? \nIf yes, enter \"y\" or enter any other key to return to menu: ");
            String statusCheck = customerScan.nextLine().toLowerCase();
            if(statusCheck.equals("y")){
                setSeat(train,customer);
            }else{
                System.out.println("Thank you for choosing Denuwara Train for your travels!");
                break;
            }
        }
    }



    private static Date dateCheck(String dateInput) throws ParseException {
        boolean check = false;
        Date dateReturn = new Date();
        for (Date date : dateList){
            if (date.getDate().equals(dateInput)){
                check = true;
                dateReturn = date;
                break;
            }
        }
        System.out.println(" ");
        if(check){
            return dateReturn;
        }else{
            Date newDate = new Date(dateInput);
            dateList.add(newDate);
            return newDate;
        }
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

    private static int checkTrain(){
        System.out.println("To book seats for the train from Colombo to Badulla enter 1.\nTo book seats for the train from Badulla to Colombo enter 2.");
        while (true){
            System.out.print("Enter train number: ");
            Scanner trainScan=new Scanner(System.in);
            //ensures input is an integer
            try{
                int x=trainScan.nextInt();
                //ensures input can be only 1 or 2
                if (x==1 || x==2){
                    return x;
                }
                else{
                    System.out.println("Please enter only 1 or 2!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Please enter only 1 or 2!");
            }
            System.out.println(" ");
        }
    }

    private static int seatCheck(Train train) {
        while (true) {
            train.printSeatList(train);
            System.out.print("Enter seat number (1-42): ");
            Scanner seatScan = new Scanner(System.in); //ensures input is an integer
            try {
                int x = seatScan.nextInt();
                //ensures input can be only be between 1-42
                if (x > 0 && x < 43) {
                    return x;
                } else {
                    System.out.println("Please enter a seat number between 1 and 42!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter only number between 1 and 42!");
            }
            System.out.println(" ");
        }
    }

    private static void setSeat(Train train, Customer customer) {
        while(true){
            int seatNo = seatCheck(train);
            if(train.seatCheck(train,seatNo)){
                for(Seat seat:train.getSeatList()){
                    if(seat.getSeatId()==seatNo){
                        seat.setCustomerId(customer.getCustId());
                        seat.setAvailability(false);
                        System.out.println("You have successfully booked seat " + seatNo + "!" );
                        System.out.println(" ");
                    }
                    break;
                }
                break;
            }else{
                System.out.println("Seat is already booked! Please enter a different seat.");
                System.out.println(" ");
                continue;
            }
        }
    }

}
