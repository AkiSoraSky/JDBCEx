package example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

    public static void main(String[] args) {
        DatabaseHelper db = new DatabaseHelper();
        ResultSet employee = db.getEmployee();
        //Displaying data

        System.out.println("Company employee List: ");
        try {
            while (employee.next()) {
                int id = employee.getInt(DatabaseHelper.E_ID);
                String name = employee.getString(DatabaseHelper.E_NAME);
                String desig = employee.getString(DatabaseHelper.E_DESIG);
                float salary = employee.getFloat(DatabaseHelper.E_SALARY);
                String address = employee.getString(DatabaseHelper.E_ADDRESS);
                String phone = employee.getString(DatabaseHelper.E_PHONE);
                System.out.println("=========================================");
                System.out.println("Id: " + id);
                System.out.println("name: " + name);
                System.out.println("salary: " + salary);
                System.out.println("address: " + address);
                System.out.println("Phone: " + phone);
                System.out.println("=========================================");
            }
        }catch (SQLException e) {
                e.printStackTrace();
            }
        db.close();
    }
}
