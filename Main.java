import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DB_driver db_driver = new DB_driver();
        DB_passenger db_passenger = new DB_passenger();
		DB_trip db_trip = new DB_trip();
        Management management = new Management();
        Driver driver = new Driver();
        Trip trip = new Trip();
        boolean check = true;
        String name;
        String address;
        String name_of_car;
        String color_of_car;
		 int width = 0;
        int length = 0;
        while (check == true) {
            try {
                Scanner scanner = new Scanner(System.in);
                Database database = new Database();
                int input = 0;
                do {
                    System.out.println("1.Add  a group of drivers\n2.add a group of passengers\n" +
                            "3.driver signup or login\n4.passenger signup or login\n" +
                            "5.show a list of driver\n6.show a list of passengers\n7.exit");
                    if (!scanner.hasNextInt()) {
                        String input1 = scanner.next();
                        check = true;
                        throw new InputMismatchException("Please Enter Integer");
                    } else {
                        input = scanner.nextInt();
                        check = false;
                    }


                    switch (input) {
                        case 1:
                            System.out.println("please enter a number of driver you want to add");
                            int number = 0;
                            if (!scanner.hasNextInt()) {
                                String number1 = scanner.next();
                                check = true;
                                throw new InputMismatchException("Please Enter Integer");
                            } else {
                                number = scanner.nextInt();
                                check = false;
                            }
                            int age, username, plaque;
                            for (int i = 0; i < number; i++) {
                                System.out.println("name,age,address,username,name_of_car," +
                                        "plaque,color_of_car,Width,Length");
                                Driver driver = new Driver();
                                name = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String age1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    age = scanner.nextInt();
                                    check = false;
                                }
                                address = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String username1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    username = scanner.nextInt();
                                    check = false;
                                }
                                name_of_car = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String plaque1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    plaque = scanner.nextInt();
                                    check = false;
                                }
                                color_of_car = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String width1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    width = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String length1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    length = scanner.nextInt();
                                    check = false;
                                }
                                driver.setName(name);
                                driver.setAge(age);
                                driver.setAddress(address);
                                driver.setUsername(username);
                                driver.getCar().setName_of_car(name_of_car);
                                driver.getCar().setPlaque(plaque);
                                driver.getCar().setColor_of_car(color_of_car);
                                driver.setWidth(width);
                                driver.setLength(length);
                                db_driver.add_driver(driver);
                                management.drivers.add(driver);
                                check = false;
                            }


                            break;
                        case 2:
                            System.out.println("please enter a number of passenger you want t add");
                            int password, balance;
                            if (!scanner.hasNextInt()) {
                                String number1 = scanner.next();
                                check = true;
                                throw new InputMismatchException("PLEASE enter integer");
                            } else {
                                number = scanner.nextInt();
                                check = false;
                            }

                            for (int i = 0; i < number; i++) {
                                System.out.println("name,age,address,username,password,balance");
                                name = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String age2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    age = scanner.nextInt();
                                    check = false;
                                }
                                address = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String username2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    username = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String password2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    password = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String balance2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    balance = scanner.nextInt();
                                    check = false;
                                }
                                Passengers passengers = new Passengers();
                                passengers.setName(name);
                                passengers.setAge(age);
                                passengers.setAddress(address);
                                passengers.setUsername(username);
                                passengers.setPassword(password);
                                passengers.setBalance(balance);
                                db_passenger.add_passenger(passengers);
                                check = false;

                            }
                            break;
                        case 3:
                            System.out.println("please enter your username");
                            username = 0;
                            if (!scanner.hasNextInt()) {
                                check = true;
                                throw new InputMismatchException("PLEASE enter integer");
                            } else {
                                username = scanner.nextInt();
                                check = false;
                            }
                            int register;
                            Driver driver = new Driver();
                            int existance = db_driver.check_exist_driver(username);
                            if (existance == 0) {
                                System.out.println("1.register\n2.Exit");
                                if (!scanner.hasNextInt()) {
                                    String register1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    register = scanner.nextInt();
                                    check = false;
                                }
                                if (register == 1) {
                                    System.out.println("name,age,address,username,name_of_car,plaque,color_of_car");
                                    name = scanner.next();
                                    if (!scanner.hasNextInt()) {
                                        String age1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        age = scanner.nextInt();
                                        check = false;
                                    }
                                    address = scanner.next();
                                    if (!scanner.hasNextInt()) {
                                        String username1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        username = scanner.nextInt();
                                        check = false;
                                    }
                                    name_of_car = scanner.next();
                                    if (!scanner.hasNextInt()) {
                                        String plaque1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        plaque = scanner.nextInt();
                                        check = false;
                                    }
                                    color_of_car = scanner.next();
                                    driver.setName(name);
                                    driver.setAge(age);
                                    driver.setAddress(address);
                                    driver.setUsername(username);
                                    driver.getCar().setName_of_car(name_of_car);
                                    driver.getCar().setPlaque(plaque);
                                    driver.getCar().setColor_of_car(color_of_car);
                                    db_driver.add_driver(driver);
                                    check = false;

                                }
                                if (register == 2) {
                                    break;
                                }
                            } else {
                                System.out.println("user exist");

                            }
                            break;
                        case 4:
                            System.out.println("please enter your username");

                            if (!scanner.hasNextInt()) {
                                check = true;
                                throw new InputMismatchException("PLEASE enter integer");
                            } else {
                                username = scanner.nextInt();
                                check = false;
                            }

                            Passengers passengers = new Passengers();
                            existance = db_driver.check_exist_driver(username);
                            if (existance == 0) {
                                System.out.println("name,age,address,username,password,balance");
                           /* if ((!scanner.hasNext()) || (!scanner.hasNextInt()) || (!scanner.hasNext()) ||
                                    (!scanner.hasNextInt()) ||
                                    (!scanner.hasNextInt()) || (!scanner.hasNextInt())) {
                                check = true;
                                throw new InputMismatchException("please enter valid input");
                            } else {
                                passengers.setName(scanner.next());
                                passengers.setAge(scanner.nextInt());
                                passengers.setAddress(scanner.next());
                                passengers.setUsername(scanner.nextInt());
                                passengers.setPassword(scanner.nextInt());
                                passengers.setBalance(scanner.nextInt());
                                db_passenger.add_passenger(passengers);
                                check = false;
                            }*/
                                name = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String age2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    age = scanner.nextInt();
                                    check = false;
                                }
                                address = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String username2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    username = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String password2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    password = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String balance2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    balance = scanner.nextInt();
                                    check = false;
                                }
                                passengers = new Passengers();
                                passengers.setName(name);
                                passengers.setAge(age);
                                passengers.setAddress(address);
                                passengers.setUsername(username);
                                passengers.setPassword(password);
                                passengers.setBalance(balance);
                                db_passenger.add_passenger(passengers);
                                check = false;


                            } else {
                                int choice = 0;
                                do {
                                    System.out.println("1.increase account balance\n2.exist");
                                    choice = scanner.nextInt();
                                    if (choice == 1) {
                                        System.out.println("please enter fund");
                                        db_passenger.increase_balance(username, scanner.nextInt());

                                    }
                                } while (choice != 2);

                            }
                            break;
                        case 5:
                            db_driver.show_driver();
                            break;
                        case 6:
                            db_passenger.show_passenger();
                            break;
                        case 7:
                            break;
                        default:
                            check=true;
                            throw new InputMismatchException("Please Enter Value Between 1-7");


                    }

                } while (input != 7);

            } catch (InputMismatchException inputMismatchException) {
                System.out.println(inputMismatchException.getMessage());
            }
        }
    }
}
