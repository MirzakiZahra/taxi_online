import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_driver extends Database {

    public DB_driver() throws SQLException, ClassNotFoundException {
    }

    public void add_driver(Driver driver) throws SQLException, ClassNotFoundException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            int indicator = this.check_exist_driver(driver.getUsername());
            if (indicator == 0) {
                DB_car db_car = new DB_car();
                db_car.add_car(driver.getCar());
                String sql = "select  id from   car where name_of_car= '" + driver.getCar().getName_of_car() + "'";
                ResultSet resultSet = statement.executeQuery(sql);
                int car_id = 0;
                while (resultSet.next()) {
                    car_id = resultSet.getInt(1);
                }
                sql = "insert into driver(name,age,address,username,car_id, width, length) values " +
                        "('" + driver.getName() + "','" + driver.getAge() + "','" + driver.getAddress() + "'," +
                        "'" + driver.getUsername() + "','" + car_id + "','" + driver.getWidth() + "'" +
                        ",'"+driver.getLength()+"')";
                int updated_field = statement.executeUpdate(sql);
                System.out.println("user" + " " + driver.getUsername() + " " + "Added");

            } else {
                System.out.println("user exist");

            }
        } else {
            System.out.println("ERORR in Connection with DB");
        }

    }

    public int check_exist_driver(int username) throws SQLException {
        Statement statement = connection.createStatement();
        int indicator = 0;
        String sql = "select username from driver where username = '" + username + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            indicator++;
        }
        return indicator;
    }

    public void show_driver() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select * from driver ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getInt("age") + " " +
                        resultSet.getString("address") + " " +
                        resultSet.getInt("username") + " " +
                        resultSet.getInt("car_id"));

            }

        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }
	 public String getStatus(int username) throws SQLException {
        String tripStatus = new String();
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select tripStatue from driver where username=  '" + username + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tripStatus = resultSet.getString("tripStatue");
            }
        } else {
            System.out.println("ERORR in Connection with DB");
        }
        return tripStatus;

    }

    public void changeStatus(int username) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            if (this.getStatus(username) == "on") {
                String sql = "update driver set tripStatue = 'off' where username='" + username + "'";
                statement.executeUpdate(sql);
            } else {
                String sql = "update driver set tripStatue = 'on' where username='" + username + "'";
                statement.executeUpdate(sql);

            }
        } else {
            System.out.println("ERORR in Connection with DB");
        }

    }

   
}
