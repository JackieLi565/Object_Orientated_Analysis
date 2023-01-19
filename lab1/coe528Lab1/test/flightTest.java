package lab1.coe528Lab1.test;
import lab1.*;

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
    }
    
    @After
    public void tearDown() {
        flightTest = null;
    }
    
    @Test
    public void testConstructoor() {
    
    }
    
    @Test
    public void testInvalidConstructoor() {
    
    }

    /**
     * Test of getFlightNumber method, of class flight.
     */
    @Test
    public void testGetFlightNumber() {
        int answer = 888;
        int result = flightTest.getFlightNumber();
        assertEquals(answer, result);
    }

    /**
     * Test of getOrigin method, of class flight.
     */
    @Test
    public void testGetOrigin() {
        String expected = "Toronto";
        String actual = flightTest.getOrigin();
        assertTrue(expected.equals(actual));
    }

    /**
     * Test of getDestination method, of class flight.
     */
    @Test
    public void testGetDestination() {
        String expected = "Vancouver";
        String actual = flightTest.getDestination();
        assertTrue(expected.equals(actual));
    }

    /**
     * Test of getDepartureTime method, of class flight.
     */
    @Test
    public void testGetDepartureTime() {
        String expected = "01/02/03 2:30 pm";
        String actual = flightTest.getDepartureTime();
        assertTrue(expected.equals(actual));
    }

    /**
     * Test of getCapacsity method, of class flight.
     */
    @Test
    public void testGetCapacity() {
        int expected = 100;
        int actual = flightTest.getCapacity();
        assertEquals(expected,actual);
    }

    /**
     * Test of getOriginalPrice method, of class flight.
     */
    @Test
    public void testGetOriginalPrice() {
        double expected = 780.89;
        double actual = flightTest.getOriginalPrice();
        assertEquals(expected,actual,0.001);
    }

    /**
     * Test of bookSeat method, of class flight.
     */
    @Test
    public void testBookSeat() {
        boolean expected = true;
        boolean actual = flightTest.bookSeat();
        assertEquals(expected,actual);
    }

    /**
     * Test of toString method, of class flight.
     */
    @Test
    public void testToString() {
    }
    
}