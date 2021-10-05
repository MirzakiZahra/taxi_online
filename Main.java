import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        DB_driver db_driver= new DB_driver();
        DB_passenger db_passenger= new DB_passenger();
        boolean check = true;
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
                        check=true;
                        throw new InputMismatchException("Please Enter Integer");
                    } else {
                        input = scanner.nextInt();
                        check = false;
                    }


                    switch (input) {
                        case 1:
                            System.out.println("please enter a number of driver you want to add");
                            int number=0;
                            if (!scanner.hasNextInt()) {
                                String number1 = scanner.next();
                                check=true;
                                throw new InputMismatchException("Please Enter Integer");
                            } else {
                               number = scanner.nextInt();
                                check = false;
                            }
                            for (int i = 0; i < number; i++) {
                                System.out.println("name,age,address,username,name_of_car,plaque,color_of_car");
                                Driver driver = new Driver();
                                if ((scanner.hasNext() && scanner.hasNextInt() && scanner.hasNext() &&
                                        scanner.hasNextInt() && scanner.hasNext() &&
                                        scanner.hasNextInt() && scanner.hasNext())) {
                                    check=true;
                                    throw new  InputMismatchException("please enter valid input");
                                }
                                else {
                                    driver.setName(scanner.next());
                                    driver.setAge(scanner.nextInt());
                                    driver.setAddress(scanner.next());
                                    driver.setUsername(scanner.nextInt());
                                    driver.getCar().setName_of_car(scanner.next());
                                    driver.getCar().setPlaque(scanner.nextInt());
                                    driver.getCar().setColor_of_car(scanner.next());
                                    db_driver.add_driver(driver);

                                   //((DB_driver) database).add_driver(driver);
                                    check=false;
                                }


                            }
                            break;
                        case 2:
                            System.out.println("please enter a number of passenger you want t add");
                            if (! scanner.hasNextInt()){
                                check=true;
                                throw new InputMismatchException("PLEASE enter integer");
                            }
                            else {
                                number = scanner.nextInt();
                                check = false;
                            }

                            for (int i = 0; i < number; i++) {
                                System.out.println("name,age,address,username,password,balance");
                                if ((scanner.hasNext() && scanner.hasNextInt() && scanner.hasNext() &&
                                        scanner.hasNextInt() &&
                                        scanner.hasNextInt() && scanner.hasNextInt())) {
                                    check = true;
                                    throw new InputMismatchException("please enter valid input");
                                } else {
                                    Passengers passengers = new Passengers();
                                    passengers.setName(scanner.next());
                                    passengers.setAge(scanner.nextInt());
                                    passengers.setAddress(scanner.next());
                                    passengers.setUsername(scanner.nextInt());
                                    passengers.setPassword(scanner.nextInt());
                                    passengers.setBalance(scanner.nextInt());
                                    db_passenger.add_passenger(passengers);
                                    // ((DB_passenger) database).add_passenger(passengers);
                                    check=false;

                                }
                            }
                            break;
                        case 3:
                            System.out.println("please enter your username");
                            int username=0;
                            if (! scanner.hasNextInt()){
                                check=true;
                                throw new InputMismatchException("PLEASE enter integer");
                            }
                            else {
                                 username = scanner.nextInt();
                                check = false;
                            }

                            Driver driver = new Driver();
                            int existance = db_driver.check_exist_driver(username);
                            if (existance == 0) {
                                System.out.println("name,age,address,username,name_of_color,plaque,color_of_car");
                                if ((scanner.hasNext() && scanner.hasNextInt() && scanner.hasNext() &&
                                        scanner.hasNextInt() && scanner.hasNext() &&
                                        scanner.hasNextInt() && scanner.hasNext())) {
                                    check=true;
                                    throw new  InputMismatchException("please enter valid input");
                                }
                                else {  driver.setName(scanner.next());
                                    driver.setAge(scanner.nextInt());
                                    driver.setAddress(scanner.next());
                                    driver.setUsername(scanner.nextInt());
                                    driver.getCar().setName_of_car(scanner.next());
                                    driver.getCar().setPlaque(scanner.nextInt());
                                    driver.getCar().setColor_of_car(scanner.next());
                                    db_driver.add_driver(driver);
                                    check=false;
                                }



                            } else {
                                System.out.println("user exist");

                            }
                            break;
                        case 4:
                            System.out.println("please enter your username");

                            if (! scanner.hasNextInt()){
                                check=true;
                                throw new InputMismatchException("PLEASE enter integer");
                            }
                            else {
                                username = scanner.nextInt();
                                check = false;
                            }

                            Passengers passengers = new Passengers();
                            existance = db_driver.check_exist_driver(username);
                            if (existance == 0) {
                                System.out.println("name,age,address,username,password,balance");
                                if ((scanner.hasNext() && scanner.hasNextInt() && scanner.hasNext() &&
                                        scanner.hasNextInt() &&
                                        scanner.hasNextInt() && scanner.hasNextInt())) {
                                    check = true;
                                    throw new InputMismatchException("please enter valid input");}
                                else {
                                passengers.setName(scanner.next());
                                passengers.setAge(scanner.nextInt());
                                passengers.setAddress(scanner.next());
                                passengers.setUsername(scanner.nextInt());
                                passengers.setPassword(scanner.nextInt());
                                passengers.setBalance(scanner.nextInt());
                                db_passenger.add_passenger(passengers);
                                check=false;}


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


                    }

                } while (input != 7);

            } catch (InputMismatchException inputMismatchException) {
                System.out.println(inputMismatchException.getMessage());
            }
        }
    }
}
