import java.sql.*;

public class Database {
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "54321");

    public Database() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }


}