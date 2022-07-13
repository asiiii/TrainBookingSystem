import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TrainBookingSystem implements BookingSystem{
    static final int SEATING_CAPACITY = 42;
    static final ArrayList<Station> stationList = new ArrayList<Station>();
    static final String stations[] = {"Colombo", "Polgahawela", "Gampola","Nawalapitiya", "Hatton", "Rozella", "Talawakele", "Nanuoya", "Haputale", "Diyatalawa", "Bandarawela", "Ella","Badulla"};
    static final String validEntries[] = {"A", "V", "E", "D", "F", "L", "S","O", "Q"};
    static final ArrayList<Customer> customerDetails = new ArrayList<Customer>();
    static final ArrayList<Train> trainList = new ArrayList<Train>();
    static final ArrayList<Booking> bookingList = new ArrayList<Booking>();

    // method to create Station instances
    public void addStationList(){
        for (int i = 0; i<TrainBookingSystem.stations.length;i++){
            String stationId = "st" + i;
            Station station = new Station(stationId, TrainBookingSystem.stations[i]);
            TrainBookingSystem.stationList.add(station);
        }
        //System.out.println(stationList.toString());
    }

    public void addSeats() {
        System.out.println("BOOK YOUR TRAIN SEAT");
        Scanner customerScan = new Scanner(System.in);

        System.out.print("Please enter date to book (dd/mm/yyyy): ");
        String dateInput = customerScan.nextLine();
        // TODO enter a method to validate date input

        Train train = new Train();
        int trainType= checkTrainTypeInput();
        System.out.println(" ");
        train = checkTrain(trainType, dateInput);

        System.out.print("Please enter you first name: ");
        String fName = customerScan.nextLine();
        System.out.print("Please enter you last name: ");
        String lName = customerScan.nextLine();

        int custIndex = 0;
        if (checkCustomer(fName, lName)){
            for(Customer cust: TrainBookingSystem.customerDetails){
                if(fName.equals(cust.getFirstName()) && lName.equals(cust.getLastName())){
                    custIndex = TrainBookingSystem.customerDetails.indexOf(cust);
                }
            }
        }else{
            String custId = "cust0";
            while (checkCustId(custId)) {
                String[] split = custId.split("t");
                int num = Integer.parseInt(split[1]);
                custId = "cust" + num+1; // each time a Customer object is created customerId increments
            }
            Customer customer = new Customer(fName, lName, custId);
            TrainBookingSystem.customerDetails.add(customer);
            custIndex = TrainBookingSystem.customerDetails.indexOf(customer);
        }

        // TODO implement method to get user input for stations and assign those to stationStart and stationEnd
        Station stationStart = TrainBookingSystem.stationList.get(0);
        Station stationEnd = TrainBookingSystem.stationList.get(5);
        Customer customer = TrainBookingSystem.customerDetails.get(custIndex);
        //FIXME: bug in the add seat functionality
        // already booked seats should not be included
        while (true){
            setSeat(train, customer, stationStart, stationEnd);
            System.out.print("Do you want to book another seat on the same train? \nIf yes, enter \"y\" or enter any other key to return to menu: ");
            String statusCheck = customerScan.nextLine().toLowerCase();
            if(!statusCheck.equals("y")){
                System.out.println("Thank you for choosing Denuwara Train for your travels!");
                break;
            }
        }
    }

    //checks the value entered as a menu option, only valid entries are allowed
    public String checkInput(){
        String userInput;
        while (true){
            Scanner scan= new Scanner(System.in);
            System.out.print("Enter your option: ");
            userInput = scan.next().toUpperCase();
            for (String s : TrainBookingSystem.validEntries){
                if(s.equals(userInput)){
                    return userInput;
                }
            }
            System.out.println("Enter a valid input!");
        }
    }



//    private static Date dateCheck(String dateInput) throws ParseException {
//        boolean check = false;
//        Date dateReturn = new Date();
//        for (Date date : dateList){
//            if (date.getDate().equals(dateInput)){
//                check = true;
//                dateReturn = date;
//                break;
//            }
//        }
//        System.out.println(" ");
//        if(check){
//            return dateReturn;
//        }else{
//            Date newDate = new Date(dateInput);
//            dateList.add(newDate);
//            return newDate;
//        }
//    }

    public void viewAllSeats() {
    }

    public void emptySeats() {
    }

    public void deleteSeats() {
    }

    public void findSeats() {
    }

    public void storeData() {
    }

    public void loadData() {
    }

    public void seatOrder() {
    }

    // method to check if Train object already exists and if not create new object
    private Train checkTrain(int trainType, String dateInput) {
        String[] dateSplit = dateInput.split("/");
        String trainId = "trn" + trainType + "_" + dateSplit[0] + dateSplit[1];

        // checks if Train object exists or not
        boolean check = false;
        Train trainReturn = new Train();
        for(Train train : TrainBookingSystem.trainList){
            if(train.getTrainId().equals(trainId)){
                check = true;
                trainReturn = train;
                break;
            }
        }
        System.out.println(" ");

        // if Train object exists, it is returned
        // if not, new Train object is created
        if(check){
            return trainReturn;
        }else{
            Station station1 = new Station();
            Station station2 = new Station();

            // starting and ending stations for the Train is set according to Train type
            if (trainType == 1){
                station1 = TrainBookingSystem.stationList.get(0);
                station2 = TrainBookingSystem.stationList.get(stationList.size()-1);
            }else if (trainType == 2){
                station1 = TrainBookingSystem.stationList.get(stationList.size()-1);
                station2 = TrainBookingSystem.stationList.get(0);
            }

            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            Date date = null;
            try {
                date = format.parse(dateInput);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Train newTrain = new Train(trainId, station1.getStationName() + " - " +station2.getStationName(), station1, station2, date);
            TrainBookingSystem.trainList.add(newTrain);
            return newTrain;
        }
    }

    // validates user input for Train
    private int checkTrainTypeInput(){
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

    // validates user input for Train
    private int seatInputCheck(Train train) {
        while (true) {
            train.printSeatList(train);
            System.out.print("Enter seat number (1-42): ");
            Scanner seatScan = new Scanner(System.in); //ensures input is an integer
            try {
                int x = seatScan.nextInt();
                //ensures input can be only be between 1-42
                if (x > 0 && x <= TrainBookingSystem.SEATING_CAPACITY) {
                    return x;
                } else {
                    System.out.println("Please enter a seat number between 1 and "+TrainBookingSystem.SEATING_CAPACITY + "!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter only number between 1 and "+TrainBookingSystem.SEATING_CAPACITY + "!");
            }
            System.out.println(" ");
        }
    }

    // sets Seat to Customer if Booking is confirmed
    private void setSeat(Train train, Customer customer, Station stationStart, Station stationEnd) {
        while(true){
            int seatNo = seatInputCheck(train);
            if(train.seatAvailabilityCheck(train,seatNo, stationStart, stationEnd)){
                for(Seat seat:train.getSeatList()){
                    if(seatNo==seat.getSeatId()){
                        if(confirmBooking(customer,train,seat, stationStart, stationEnd)){
                            seat.setCustomerId(customer.getCustId());
                            seat.setAvailability(false);

                            System.out.println("You have successfully booked seat " + seatNo + " from " + stationStart.getStationName() + " to " + stationEnd.getStationName() + "!" );
                            System.out.println(" ");
                            break;
                        }else{
                            System.out.println("You have cancelled your booking.");
                            System.out.println(" ");
                        }
                    }
                }
            }else{
                System.out.println("Seat is already booked! Please enter a different seat.");
                System.out.println(" ");
                continue;
            }
            break;
        }
    }

    // confirms Booking and creates new Booking object
    private  boolean confirmBooking(Customer customer, Train train, Seat seat, Station boardingStation, Station exitStation) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        System.out.print("To confirm your booking enter \"y\" or enter any other key to cancel: ");
        String statusCheck = scanner.nextLine().toLowerCase();
        if(statusCheck.equals("y")){
            String bookingId = "bk_0";
            while (checkBookingId(bookingId)) {
                String[] split = bookingId.split("_");
                int num = Integer.parseInt(split[1]);
                bookingId = "bk_" + num+1; // each time a Booking object is created bookingId increments
                Booking booking = new Booking(bookingId, train.getDate(), customer.getCustId(), train, seat, boardingStation, exitStation);
                TrainBookingSystem.bookingList.add(booking);
            }
            check = true;
        }
        return check;
    }

    // method to validate Booking Id
    private boolean checkBookingId(String bookingId) {
        for(Booking booking: TrainBookingSystem.bookingList){
            if(bookingId.equals(booking.getBookingId())){
                return true;
            }
        }
        return false;
    }

    // method to validate Customer
    private boolean checkCustomer(String firstName, String lastName){
        for(Customer customer: TrainBookingSystem.customerDetails){
            if(firstName.equals(customer.getFirstName()) && lastName.equals(customer.getLastName())){
                return true;
            }
        }
        return false;
    }

    // method to validate Customer Id
    private boolean checkCustId(String custId) {
        for(Customer customer: TrainBookingSystem.customerDetails){
            if(custId.equals(customer.getCustId())){
                return true;
            }
        }
        return false;
    }

//    for intermediate stations
//    for(int i= TrainBookingSystem.stationList.indexOf(startingStation); i<TrainBookingSystem.stationList.indexOf(endingStation); i++){
//
//    }
}
