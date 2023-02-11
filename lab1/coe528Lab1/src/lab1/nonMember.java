package lab1;
/*
    *by Jackie Li
    *COE528 Lab1 Flight Booking System
    *Section 10 for Luella Marcos
*/
public class nonMember extends passenger {

    nonMember(int age, String name) {
        super(name, age);
    }

    double applyDiscount(double ticketPrice) {
        if (age > 65) {
            return ticketPrice - (ticketPrice * 0.10);
        } else {
            return ticketPrice;
        }
    }
}
