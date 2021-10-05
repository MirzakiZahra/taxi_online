import java.sql.SQLException;
import java.sql.Statement;

public class DB_car extends Database{

    public DB_car() throws SQLException, ClassNotFoundException {
    }
    public void add_car(Car car) throws SQLException {
        if (connection!= null){
            Statement statement = connection.createStatement();
            String sql="insert into car (name_of_car,plaque,color_of_car) values " +
                    "('"+car.getName_of_car()+"','"+car.getPlaque()+"','"+car.getColor_of_car()+"')";
            int updated_field = statement.executeUpdate(sql);

        }
        else {
            System.out.println("ERORR in Connection with DB");}

    }
}
