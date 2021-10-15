mport java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_trip extends Database {

    public DB_trip() throws SQLException, ClassNotFoundException {
    }
	public void addTrip(Trip trip) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select id from driver where username = '" + trip.driver.getUsername() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            int idDriver = 0;
            while (resultSet.next()) {
                idDriver = resultSet.getInt(1);
            }
            sql = "select id from passenger where username = '" + trip.passengers.getUsername() + "'";
            resultSet = statement.executeQuery(sql);
            int idPassenger = 0;
            while (resultSet.next()) {
                idPassenger = resultSet.getInt(1);
            }
            sql = "insert into trip (destinationLength,destinationWidth, originLength,originWidth," +
                    " driverId, passengerId, paymentType, tripStatue) values " +
                    "('" + trip.getDestinationLength() + "','" + trip.getDestinationWidth() + "'," +
                    "'" + trip.getOriginalLength() + "','" + trip.getOrigenWidth() + "'," +
                    "'" + idDriver + "','" + idPassenger + "','"+trip.getPaymentType()+"','on')";
            int updated_field = statement.executeUpdate(sql);
            System.out.println("Trip Added to DB");

        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }
	 public int findTripDestinationLength(int username) throws SQLException {
        if (connection != null) {

            Statement statement = connection.createStatement();
            String sql = "select id from driver where username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            int idDriver = 0;
            while (resultSet.next()) {
                idDriver = resultSet.getInt(1);
            }
            sql = "select destinationLength from trip where driverId = '" + idDriver + "' and " +
                    "tripStatue = '"+"on"+"'";
            resultSet = statement.executeQuery(sql);
            int destinationLength=0;
            while (resultSet.next()) {
              destinationLength = resultSet.getInt(1);
            }
            return destinationLength;

        }else {
            System.out.println("ERORR in Connection with DB");
        }
        return 0;
    }
    public int findTripDestinationWidth(int username) throws SQLException {
        if (connection != null) {

            Statement statement = connection.createStatement();
            String sql = "select id from driver where username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            int idDriver = 0;
            while (resultSet.next()) {
                idDriver = resultSet.getInt(1);
            }
            sql = "select destinationWidth from trip where driverId = '" + idDriver + "' and " +
                    "tripStatue = '"+"on"+"'";
            resultSet = statement.executeQuery(sql);
            int destinationWidth=0;
            while (resultSet.next()) {
                destinationWidth = resultSet.getInt(1);
            }
            return destinationWidth;

        }else {
            System.out.println("ERORR in Connection with DB");
        }
        return 0;
    }
    public void changeStatue(int username) throws SQLException {
        if (connection != null) {

            Statement statement = connection.createStatement();
            String sql = "select id from driver where username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            int idDriver = 0;
            while (resultSet.next()) {
                idDriver = resultSet.getInt(1);
            }
            sql = "update trip set tripStatue = 'off' where driverId = '" + idDriver + "' and " +
                    "tripStatue = '"+"on"+"'";
           statement.executeUpdate(sql);
        }else {
            System.out.println("ERORR in Connection with DB");
        }

    }
}