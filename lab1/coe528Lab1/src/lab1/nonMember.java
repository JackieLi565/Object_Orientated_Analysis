package lab1;

public class nonMember extends passenger {
    private int yearsOfMembership;

    nonMember(int yearsOfMembership, int age, String name) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }

    public int getYearsOfMembership() {
        return this.yearsOfMembership;
    }

    double applyDiscount(double ticketPrice) {
        if (age > 65) {
            return (Double)ticketPrice * 0.10;
        } else {
            return ticketPrice;
        }
    }

}
