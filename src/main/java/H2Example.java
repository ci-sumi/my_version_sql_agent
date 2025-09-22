import java.sql.*;
public class H2Example {
    public static void main(String[] args){
        try{
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test1","sa","");
            System.out.println("connected");
            connection.close();

        }catch (ClassNotFoundException e){
            System.err.println("H2 driver is not found,Please add the jar");


        }catch (SQLException e){
            System.out.println("Sql connection failed"+ e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error"+e.getMessage());
        }
        System.out.println("Program completed");
    }
}