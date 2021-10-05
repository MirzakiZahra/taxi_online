public class Passengers extends Person {

    private int password;
    int balance=0;
    Driver driver= new Driver();

    public Driver getDriver() {
        return driver;
    }
    public Passengers(){

    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passengers(String name, int age, String address, int username, int password, int balance) {
        super(name, age, address, username);
        this.password = password;
        this.balance = balance;
    }

    public Passengers(int password, int balance) {
        this.password = password;
        this.balance = balance;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}