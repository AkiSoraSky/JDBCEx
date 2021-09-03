package example;

import java.sql.*;

public class DatabaseHelper {

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DATABASE_NAME = "example1";

    public static final String TABLE_EMP = "emp";
    public static final String E_ID = "id";
    public static final String E_NAME = "name";
    public static final String E_DESIG = "designation";
    public static final String E_SALARY = "salary";
    public static final String E_ADDRESS = "address";
    public static final String E_PHONE = "phone";
    public Connection conn;

    DatabaseHelper(){
        conn = connect();
    }

    private Connection connect(){            //general class to connect to database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Closing Error-> " +e.getMessage());
        }
    }

    public ResultSet getEmployee(){
        String query = "SELECT * FROM %s".formatted(TABLE_EMP);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Select query error: "+e.getMessage());
        }
        return null;
    }
}
/*
    1. Constructor
    2. connection OPen method
    3. Connection closing method
    4. Data Retrieval method (Select Query)
    5. Data Deletion method (Deletion Query)
    6. Data update method (Update Query)
    and search method (SELECT QUERY with WHERE clause)
     */