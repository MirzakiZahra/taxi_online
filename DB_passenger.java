import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_passenger extends Database{

    public DB_passenger() throws SQLException, ClassNotFoundException {
    }
	 public void add_passenger(Passengers passengers) throws SQLException {
        if (connection != null) {

            Statement statement = connection.createStatement();
            int indicator = this.check_exist_of_user(passengers.getUsername());
            if (indicator == 0) {
                String sql = "select id from driver where username = '" + passengers.getDriver().getUsername() + "'";
                ResultSet resultSet = statement.executeQuery(sql);

                int id_driver = 0;
                while (resultSet.next()) {
                    id_driver = resultSet.getInt(1);
                }
                sql = "insert into passenger (name,age,address,username,userpassword,balance,width,length) values " +
                        "('" + passengers.getName() + "','" + passengers.getAge() + "','" + passengers.getAddress() +
                        "','" + passengers.getUsername() + "','" + passengers.getPassword() + "','" + passengers.getBalance() + "'," +
                        "'" + passengers.getWidth() + "','" + passengers.getLength() + "')";
                int updated_field = statement.executeUpdate(sql);
                System.out.println("user" + " " + passengers.getUsername() + " " + "Added");
            } else {
                System.out.println("user exist");
            }

        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }

    public int check_exist_of_user(Passengers passengers) throws SQLException {
        Statement statement = connection.createStatement();
        int indicator=0;
        String sql="select username from passenger where username= '"+passengers.getUsername()+"'";
        ResultSet resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            indicator++;
        }
        return indicator;
    }
    public void show_passenger() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql= "select * from passenger ";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("name")+" "+
                       resultSet.getInt("age")+" "+
                        resultSet.getString("address")+" "+
                        resultSet.getInt("username")+" "+
                                resultSet.getInt("userpassword")+" "+
                                resultSet.getInt("balance"));
            }

        }
    }
    public void increase_balance(int username,int fund) throws SQLException {
        if (connection!= null){
            Statement statement=connection.createStatement();
            String sql="select balance from passenger where username='"+username+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            int temp=0;
            while (resultSet.next()){
               temp= resultSet.getInt("balance");
            }
            temp=temp+fund;
            sql="update passenger set balance= '"+temp+"' where username = '"+username+"'";
            int number=statement.executeUpdate(sql);


        }
    }
	 public void increase_balance(int username, int fund) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select balance from passenger where username='" + username + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            int temp = 0;
            while (resultSet.next()) {
                temp = resultSet.getInt("balance");
            }
            temp = temp + fund;
            sql = "update passenger set balance= '" + temp + "' where username = '" + username + "'";
            int number = statement.executeUpdate(sql);


        }
    }

    public void decreaseBalance(int username, int fund) throws SQLException {
        int balance = 0;
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select balance from passenger where username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                balance = resultSet.getInt(1);
            }
            if (balance >= fund) {
                balance = balance - fund;
                sql = "update passenger set balance='" + balance + "' where username='" + username + "'";
                statement.executeUpdate(sql);
            } else {
                System.out.println("please increase your balance");
            }

        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }

    public int findBalance(int username) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "select balance from passenger where username=  '" + username + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            int balance = 0;
            while (resultSet.next()) {
                balance = resultSet.getInt(1);
            }
            return balance;
        } else {
            System.out.println("ERORR in Connection with DB");
        }
        return 0;
    }
}
