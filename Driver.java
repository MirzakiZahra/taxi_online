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
	 public int calculateDistance(int passengerWidth,int passengerLength){
        return ((this.Length-passengerLength)+(this.Width-passengerWidth));
    }

    @Override
    public String toString() {
        return "Driver{" +
                "car=" + car +
                ", balance=" + balance +
                ", tripStatue=" + tripStatue +
                ", Width=" + Width +
                ", Length=" + Length +
                ", paymentType=" + paymentType +
                '}';
    }
}
