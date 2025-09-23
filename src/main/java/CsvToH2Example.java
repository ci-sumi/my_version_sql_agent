import com.opencsv.CSVReader;
import org.apache.commons.lang3.ObjectUtils;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.*;

public class CsvToH2Example {
    public static void main(String[] args){
        System.out.println("*****Create table inside H2 Database****");
        String libcurl ="jdbc:h2:mem:test5";
        String user ="sa";
        String password="";
        try{
            Connection connection = DriverManager.getConnection(libcurl,user,password);
            System.out.println("Connection is created");
            Statement statement = connection.createStatement();
            String sql ="CREATE TABLE movies("+
                    "Film VARCHAR(255),"+
                    "Genre VARCHAR(255),"+
                    "Lead_studio VARCHAR(255),"+
                    "Audience_Score_pc INT,"+ "Profitability DECIMAL(10,2),"+ "Rotten_Tomatoes INT,"+
                    "Worldwide_Gross DECIMAL(15,2),"+ "Release_Year INT )";

            statement.execute(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }
        try(CSVReader reader = new CSVReader(new InputStreamReader
                (CsvToH2Example.class.getResourceAsStream("data.csv")))) {
            System.out.println("its reading");Connection connection = DriverManager.getConnection(libcurl,user,password);
            String insertsql = "INSERT INTO movies(Film,Genre,Lead_Studio,Audience_Score_pc,Profitability,"+
                    "Rotten_Tomatoes,Worldwide_Gross,Release_Year)"+"VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ptst = connection.prepareStatement(insertsql);
            String [] line;
            reader.readNext();
            while((line=reader.readNext())!= null){
                ptst.setString(1,line[0]);
                ptst.setString(2,line[1]);
                ptst.setString(3,line[2]);
                ptst.setInt(4,Integer.parseInt(line[3]));
                ptst.setBigDecimal(5,new BigDecimal(line[4]));
                ptst.setInt(6,Integer.parseInt(line[5]));
                ptst.setBigDecimal(7,new BigDecimal(line[6])) ;
                ptst.setInt(8,Integer.parseInt(line[7]));
                ptst.addBatch();

            }
            ptst.executeBatch();
            System.out.println("CSV file loaded to H2 databse Successfully");



        }catch (Exception e){
            e.printStackTrace();
        }


    }
}