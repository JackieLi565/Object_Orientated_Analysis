package lab1;

public class member extends passenger{
    private int yearsOfMembership;

    member(int yearsOfMembership, int age, String name) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }

    public int getYearsOfMembership() {
        return this.yearsOfMembership;
    }

    @Override
    double applyDiscount(double ticketPrice) {
        if (yearsOfMembership > 5) {
            return ticketPrice * 0.5;
        } else if (yearsOfMembership > 1 && yearsOfMembership <= 5) {
            return ticketPrice * 0.1;
        } else {
            return ticketPrice;
        }
    }

}
