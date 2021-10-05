public class Driver extends Person {
    Car car=new Car();

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver(String name, int age, String address, int username, Car car) {
        super(name, age, address, username);
        this.car = car;
    }

    public Driver(Car car) {
        this.car = car;
    }
    public Driver(){}
}
