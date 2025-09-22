import java.sql.*;

public class H2DatabaseExample {
    public static void main(String[] args){
        try{
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test","sa","");
        System.out.println("Connected");
        connection.close();
    } catch (ClassNotFoundException e) {
            System.err.println("H2 Driver not found.Please add Jar");
        }catch(SQLException e) {
            System.err.println("Database connection failed" + e.getMessage());
        }catch (Exception e) {
            System.err.println("Unexpected error:" + e.getMessage());
        }
        System.out.println("Program completed");


        }

        }
