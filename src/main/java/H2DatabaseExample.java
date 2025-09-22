import java.sql.*;

public class H2DatabaseExample {
    public static void main(String[] args){
        try{
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test","sa","");
        System.out.println("Connected");
        createTable(connection);
        insertTable(connection);
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
        public static void createTable(Connection connection){

            try{
                Statement statement = connection.createStatement();
                String sql= "CREATE TABLE users(id INT PRIMARY KEY,name VARCHAR(25),email VARCHAR(25),age INT)";
                statement.execute(sql);
                System.out.println("table created");
            } catch (SQLException e) {
                System.out.println("Statement not established"+e.getMessage());
            }

        }
        public static void insertTable(Connection connection){
        try(Statement statement = connection.createStatement()){
            statement.execute("INSERT INTO users VALUES(1,'Alice','example1@gmail.com',25)");
            System.out.println("Rows created");


       }catch (SQLException e){
            System.out.println("Cant able to insert into table"+e.getMessage());
        }
        }
        }



