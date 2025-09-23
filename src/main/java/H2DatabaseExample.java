import java.sql.*;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;


public class H2DatabaseExample {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
            System.out.println("Connected");
//            createTable(connection);
//            insertTable(connection);
//            selectTable(connection);
//            csvLoadData(connection, "/data.csv");
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("H2 Driver not found.Please add Jar");
        } catch (SQLException e) {
            System.err.println("Database connection failed" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error:" + e.getMessage());
        }
        System.out.println("Program completed");


    }

//    public static void createTable(Connection connection) {
//
//        try {
//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE users(id INT PRIMARY KEY,name VARCHAR(25),email VARCHAR(25),age INT)";
//            statement.execute(sql);
//            System.out.println("table created");
//        } catch (SQLException e) {
//            System.out.println("Statement not established" + e.getMessage());
//        }
//
//    }

//    public static void insertTable(Connection connection) {
//        try (Statement statement = connection.createStatement()) {
//            statement.execute("INSERT INTO users VALUES(1,'Alice','example1@gmail.com',25)");
//            System.out.println("Rows created");
//
//
//        } catch (SQLException e) {
//            System.out.println("Cant able to insert into table" + e.getMessage());
//        }
//    }

//    public static void selectTable(Connection connection) {
//        try (Statement statement = connection.createStatement()) {
//            ResultSet result = statement.executeQuery("SELECT * FROM users");
//            System.out.println("id|name|email|age");
//            while (result.next()) {
//                int id = result.getInt("id");
//                String name = result.getString("name");
//                String email = result.getString("email");
//                int age = result.getInt("age");
//                System.out.println(id + name + email);
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println("Rows re not selected" + e.getMessage());
//        }
//
//    }


}



