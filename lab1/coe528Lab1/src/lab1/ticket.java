package lab1;

public class ticket {
    private flight flight;
    private passenger passenger;
    private int price;
    private static int ticketNumber;

    ticket(flight flight, passenger passenger, int price, int ticketNumber) {
        this.flight = flight;
        this.passenger = passenger;
        this.price = price;
        ticketNumber++;
    }

    public flight getFlight() {
        return this.flight;
    }

    public passenger getPassenger() {
        return this.passenger;
    }
    
    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getPrice() {
        return this.price;
    }
 
    @Override
    public String toString() {
        String origin = getFlight().getOrigin();
        String destination = getFlight().getDestination();
        int flightNumber = getFlight().getFlightNumber();
        String name = getPassenger().getName();
        double originalPrice = getFlight().getOriginalPrice();
        String flightTime = getFlight().getDepartureTime();

        return (name + ", Flight " + flightNumber + " " + origin + " to " + 
               destination + ", " + flightTime + ", original price: " + originalPrice + ", ticket price: $" + this.price);
    }
}
