package lab1;
/*
    *by Jackie Li
    *COE528 Lab1 Flight Booking System
    *Section 10 for Luella Marcos
*/
public class flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;

    public flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {

        if(origin.equals(destination)) {
            throw new IllegalArgumentException("Origin destination canno't be the same as final destination");
        };

        this.flightNumber = flightNumber;
        this.destination = destination;
        this.origin = origin;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.originalPrice = originalPrice;
        numberOfSeatsLeft = capacity;
    };

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getNumberofSeats() {
        return numberOfSeatsLeft;
    }
    
    public double getOriginalPrice() {
        return this.originalPrice;
    }

    public boolean bookSeat() {
        if (this.numberOfSeatsLeft > 0) {
            this.numberOfSeatsLeft--;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String flightPath = this.origin + " to " + this.destination;
        return ("Flight: " + this.flightNumber + ", " + flightPath + ", " + this.departureTime + ", Original Price: " + originalPrice + "$");
    }

}
