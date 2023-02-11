package lab1;

/*
    *by Jackie Li
    *COE528 Lab1 Flight Booking System
    *Section 10 for Luella Marcos
*/
import java.util.ArrayList;
import java.util.Scanner;

public class manager {
    static Scanner input = new Scanner(System.in);
    ArrayList<flight> flights = new ArrayList<>();
    ArrayList<passenger> passengers = new ArrayList<>();
    ArrayList<ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        /*
         * Welcome Back Manager!
         * to use this program please select the inputs shown on the screen
         * the program will yell at you if you dont select a correct number
         * be sure to select the correct input as you will not be able to go back
         * i shouldve added a back feature but it was getting too long :(
         * Have Fun!
         */
        manager testManager = new manager();
        // add passengers
        testManager.passengers.add(new nonMember(65, "Chisato Nishikigi"));
        testManager.passengers.add(new nonMember(88, "Takina Inoue"));
        testManager.passengers.add(new member(4, 35, "Kurumi"));
        testManager.passengers.add(new member(8, 28, "Mizuki Nakahara"));
        testManager.passengers.add(new member(1, 35, "Mika"));

        boolean loggedIn = true;
        System.out.println("\n");
        System.out.println("---------------------------------------------------------");
        System.out.println("| Welcome Back Manager! What will you like to do today? |");
        System.out.println("---------------------------------------------------------");
        while (loggedIn) {
            System.out.println("");
            System.out.println("1) | Create a new Flight.");
            System.out.println("2) | Display available Flights.");
            System.out.println("3) | Book a seat for a passanger.");
            System.out.println("4) | Display Issued Tickets"); // please add method to this
            System.out.println("5) | Logout");
            System.out.print("------> ");
            int selection = input.nextInt();
            System.out.println("");
            switch (selection) {
                case 1:
                    System.out.println("-------------------------");
                    System.out.println("| Creating a new Flight |");
                    System.out.println("-------------------------\n");
                    testManager.createFlights();
                    break;
                case 2:
                    System.out.println("------------------------");
                    System.out.println("| Searching for Flight |");
                    System.out.println("------------------------\n");
                    System.out.println("Origin of flight?");
                    String origin = input.next();
                    System.out.println("Destination of flight?");
                    String destination = input.next();
                    testManager.displayAvailableFlights(origin.toLowerCase(), destination.toLowerCase());
                    break;
                case 3:
                    System.out.println("--------------------");
                    System.out.println("| Booking a Flight |");
                    System.out.println("--------------------\n");
                    System.out.println("What is the flight number?");
                    int flightNumber = input.nextInt();
                    System.out.println("Which passenger would you like to book for?");
                    passenger selectedPassegner = testManager.selectPassenger(testManager.passengers); // retrun index
                                                                                                       // of passegner
                    testManager.bookSeat(flightNumber, selectedPassegner);

                    break;
                case 4:
                    System.out.println("-------------------------");
                    System.out.println("| Display total Tickets |");
                    System.out.println("-------------------------\n");
                    testManager.displayTickets(testManager.tickets);
                    break;
                case 5:
                    loggedIn = false;
                    System.out.println("Sucessfully Logged Out");
                    break;
                default:
                    System.out.println("That is not an available selection");
                    break;
            }
        }
    }

    // create flights
    public void createFlights() {
        try {
            System.out.print("Input flight number: ");
            int flightNumber = input.nextInt();
            System.out.print("Input flight origin: ");
            String origin = input.next();
            System.out.print("Input flight destination: ");
            String destination = input.next();
            System.out.print("Input flight departure time {Day/Month/Year, time}: ");
            String departureTime = input.next();
            departureTime += input.nextLine();
            System.out.print("Input flight max capacity: ");
            int capacity = input.nextInt();
            System.out.print("Input flight marketprice: ");
            double originalPrice = input.nextDouble();

            flights.add(new flight(flightNumber, origin.toLowerCase(), destination.toLowerCase(), departureTime,
                    capacity, originalPrice));
            System.out.println("\nFlight: " + flightNumber + " has been sucesfully added");
        } catch (Exception e) {
            System.out.println("An error occured" + e);
        }
    }

    // display flights
    public void displayAvailableFlights(String origin, String destination) {
        boolean flightFound = false;
        for (int i = 0; i < flights.size(); i++) {
            String o = flights.get(i).getOrigin();
            String d = flights.get(i).getDestination();
            if (o.equals(origin) && d.equals(destination) && flights.get(i).getNumberofSeats() != 0) {
                flightFound = true;
                System.out.println("\n" + flights.get(i));
            }
        }
        if (!flightFound) {
            System.out.println("No flights available from: " + origin + " to " + destination);
        }
    }

    // get flights
    public flight getFlight(int flightNumber) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber() == flightNumber) {
                return flights.get(i);
            }
        }
        return null;
    }

    // books seat
    public void bookSeat(int flightNumber, passenger p) {
        flight flight = getFlight(flightNumber);
        if (flight != null) { // isNull also works here but i like the != more
            boolean check = flight.bookSeat();
            if (check) {
                double disountedPrice = p.applyDiscount(flight.getOriginalPrice());
                ticket ticket = new ticket(flight, p, disountedPrice, flightNumber);
                tickets.add(ticket);
                System.out.println(
                        "Please hand ticket number: " + ticket.getTicketNumber() + " over to passenger: " + ticket);
                System.out.println("Number of seats left: " + flight.getNumberofSeats());
            } else {
                System.out.println("Flight is full");
            }
        } else {
            System.out.println("Flight: " + flightNumber + " does not exsit");
        }
    }

    // select a passenger for seat booking
    public passenger selectPassenger(ArrayList<passenger> passengerList) {
        System.out.println("| Choose passenger you attach the ticket to\n");
        for (int i = 0; i < passengerList.size(); i++) {
            System.out.println("" + i + ") " + passengerList.get(i).getName());
        }
        System.out.println("_______________________________________");
        System.out.print("Select passegner according to number: ");
        int choice = input.nextInt();
        return passengerList.get(choice);
    }

    // display ticket
    public void displayTickets(ArrayList<ticket> ticket) {
        System.out.println("| Tickets handed out");
        for (int i = 0; i < ticket.size(); i++) {
            System.out.println("" + i + ") " + ticket.get(i));
        }
    }
}
