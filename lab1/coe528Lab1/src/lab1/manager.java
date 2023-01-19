package lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lijac
 */
public class manager {

    ArrayList<flight> flights = new ArrayList<>();
    ArrayList<ticket> tickets = new ArrayList<>();
    public static void main(String[] args) {
        
    }
    
    public void createFlights() {
        Scanner input = new Scanner(System.in);
    }
    
    public void displayAvailableFlights (String origin, String destination) {
        for(int i = 0; i < flights.size(); i++) {
            String o = flights.get(i).getOrigin();
            String d = flights.get(i).getDestination();
            if (o.equals(origin) && d.equals(destination)) {
                System.out.println(flights.get(i));
            }
        }
    }
    
    public flight getFlight(int flightNumber) { //return flight obj for given flight number
        int i = 0;
        return flights.get(i);
    }
    
    public void bookSeat(int flightNumber, passenger p) {
    
    }
    
}
