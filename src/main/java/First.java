import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class First {
    static String userName = "root";
    static String password = "12345";
    static String connectionUrl = "jdbc:mysql://localhost:3306/qatest?serverTimezone=Europe/Moscow&useSSL=false";

    public static void addDataInBooksTable(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO books (name) VALUES ('%s')", name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addDataInUsersTable(int id, String fName, String lName){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO users (ID, First_Name, Last_Name) VALUES ('%d', '%s', '%s');", id, fName,lName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllDataFromBooksTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println(id + "  " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getAllDataFromUsersTable(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fName = resultSet.getString(2);
                String lName = resultSet.getString(3);
                String date = resultSet.getString(4);
                System.out.println(id + " | " + fName + " | " + lName + " | " + " | " + date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //addDataInBooksTable("Driver");
        //getAllDataFromBooksTable();
        //addDataInUsersTable(2,"Vasya","Ivanov");
        //getAllDataFromUsersTable();
    }
}
