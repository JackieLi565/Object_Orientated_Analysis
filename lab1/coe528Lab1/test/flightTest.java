package lab1;

/*
    *by Jackie Li
    *COE528 Lab1 Flight Booking System
    *Section 10 for Luella Marcos
*/
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class flightTest {
    flight flightTest;

    @Before
    public void setUp() {
        int flightNumber = 888;
        String origin = "Toronto";
        String destination = "Vancouver";
        String departureTime = "01/02/03 2:30 pm";
        int capacity = 100;
        double originalPrice = 780.89;
        flightTest = new flight(flightNumber, origin, destination, departureTime, capacity, originalPrice);
        flightTest.bookSeat();
    }

    @After
    public void tearDown() {
        flightTest = null;
    }

    @Test
    public void testConstructor() {
        boolean actual;
        try {
            int flightNumber = 888;
            String origin = "Toronto";
            String destination = "Vancouver";
            String departureTime = "01/02/03 2:30 pm";
            int capacity = 100;
            double originalPrice = 780.89;
            flightTest = new flight(flightNumber, origin, destination, departureTime, capacity, originalPrice);

            actual = true;
        } catch (IllegalArgumentException e) {
            actual = false;
        }

        assertTrue("Constructor Passed", actual);
    }

    @Test
    public void testInvalidConstructor() {
        boolean actual;
        try {
            int flightNumber = 888;
            String origin = "Toronto";
            String destination = "Toronto";
            String departureTime = "01/02/03 2:30 pm";
            int capacity = 100;
            double originalPrice = 780.89;
            flightTest = new flight(flightNumber, origin, destination, departureTime, capacity, originalPrice);

            actual = false;
        } catch (IllegalArgumentException e) {
            actual = true;
        }

        assertTrue("InvalidConstructor Passed", actual);
    }

    /**
     * Test of getFlightNumber method, of class flight.
     */
    @Test
    public void testGetFlightNumber() {
        int answer = 888;
        int result = flightTest.getFlightNumber();
        assertEquals("FlightNumber Passed", answer, result);
    }

    /**
     * Test of getOrigin method, of class flight.
     */
    @Test
    public void testGetOrigin() {
        String expected = "Toronto";
        String actual = flightTest.getOrigin();
        assertTrue("GetOrigin Passed", expected.equals(actual));
    }

    /**
     * Test of getDestination method, of class flight.
     */
    @Test
    public void testGetDestination() {
        String expected = "Vancouver";
        String actual = flightTest.getDestination();
        assertTrue("GetDestination Passed", expected.equals(actual));
    }

    /**
     * Test of getDepartureTime method, of class flight.
     */
    @Test
    public void testGetDepartureTime() {
        String expected = "01/02/03 2:30 pm";
        String actual = flightTest.getDepartureTime();
        assertTrue("GetDepartureTime Passed", expected.equals(actual));
    }

    /**
     * Test of getCapacsity method, of class flight.
     */
    @Test
    public void testGetCapacity() {
        int expected = 100;
        int actual = flightTest.getCapacity();
        assertEquals("GetCapacity Passed", expected, actual);
    }

    /**
     * Test of getOriginalPrice method, of class flight.
     */
    @Test
    public void testGetOriginalPrice() {
        double expected = 780.89;
        double actual = flightTest.getOriginalPrice();
        assertEquals("GetOriginalPrice Passed", expected, actual, 0.001);
    }

    /**
     * Test of getNumberofSeats method, of class flight.
     */
    @Test
    public void testGetNumberOfSeats() {
        int expected = 99;
        int actual = flightTest.getNumberofSeats();
        assertEquals("GetNumberOfSeats Passed", expected, actual);
    }

    /**
     * Test of bookSeat method, of class flight.
     */
    @Test
    public void testBookSeat() {
        boolean expected = true;
        boolean actual = flightTest.bookSeat();
        assertEquals("BookedSeat Passed", expected, actual);
    }

    /**
     * Test of toString method, of class flight.
     */
    @Test
    public void testToString() {
        String expected = "Flight: 888, Toronto to Vancouver, 01/02/03 2:30 pm, Original Price: 780.89$";
        String actual = flightTest.toString();
        assertEquals("ToStirng Passed", expected, actual);
    }

}