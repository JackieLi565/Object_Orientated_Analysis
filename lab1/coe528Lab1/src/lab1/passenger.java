package lab1;

public abstract class passenger {
    protected String name;
    protected int age; 

    passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    abstract double applyDiscount(double ticketPrice);
}
