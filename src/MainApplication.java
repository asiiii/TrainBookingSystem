import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;

public class MainApplication {


    public static void main(String args[]) throws ParseException {
        System.out.println("WELCOME TO DENUWARA MANIKE TRAIN BOOKING system\n\n");
        // create Station instances
        TrainBookingSystem.addStationList();

        // run Spring application here

        boolean exit = false;
        while (!exit){
            displayMenu();
            String userInput = TrainBookingSystem.checkInput();
            System.out.println(" ");

            switch (userInput){
                case "A":
                    TrainBookingSystem.addSeats(); //call function to add customer to seat
                    break;
                case "V":
                    TrainBookingSystem.viewAllSeats(); //call function to view seats
                    break;
                case "E":
                    TrainBookingSystem.emptySeats(); //call function to display empty seats
                    break;
                case "D":
                    TrainBookingSystem.deleteSeats(); //call function to delete customer from seat
                    break;
                case "F":
                    TrainBookingSystem.findSeats(); //call function to find seat assigned to customer name
                    break;
                case "S":
                    TrainBookingSystem.storeData();//call function to store program data
                    break;
                case "L":
                    TrainBookingSystem.loadData();//call function to load program data
                    break;
                case "O":
                    TrainBookingSystem.seatOrder();//call function to view ordered seats alphabetically
                    break;
                case "Q":
                    boolean stop=false;
                    while(!stop){
                        Scanner scan= new Scanner(System.in);
                        //gets confirmation to quit program
                        System.out.print("Enter 'y' to confirm quitting or enter any key to go back to menu: ");
                        String choice=scan.next().toLowerCase();
                        System.out.println(" ");
                        if(choice.equals("y")){
                            System.out.println("You are now exiting the system!");
                            exit=true;
                        }
                        stop=true;
                    }
                    break;
                default:
                    break;
            }
        }
        System.exit(-1);
    }

    //method to display menu options
    public static void displayMenu() {
        System.out.println("--------------------------------MENU--------------------------------");
        Scanner scan1 = new Scanner(System.in);
        //displaying menu in console
        System.out.println("Enter 'A' to add a customer to seat");
        System.out.println("Enter 'V' to view all seats");
        System.out.println("Enter 'E' to display empty seats");
        System.out.println("Enter 'D' to delete customer from seat");
        System.out.println("Enter 'F' to find seat assigned to customer name");
        System.out.println("Enter 'S' to store program data");
        System.out.println("Enter 'L' to load program data");
        System.out.println("Enter 'O' to view ordered seats alphabetically");
        System.out.println("Enter 'Q' to quit");
        System.out.println("--------------------------------------------------------------------");
        System.out.println(" ");
    }


}
