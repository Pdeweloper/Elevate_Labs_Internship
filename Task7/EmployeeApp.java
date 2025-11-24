package Elevate_Labs_Intership.Task7;

import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {

	    private static final String URL = "jdbc:mysql://localhost:3306/employee_db"; 
	    private static final String USER = "root";     
	    private static final String PASS = "password";

	    private Connection conn;
	    private Scanner scanner;

	    //Constructor of Class to Establish Connection.
	    public EmployeeApp() {
	        scanner = new Scanner(System.in);
	        connect();
	    }

	    //Connect to DB
	    private void connect() {
	        try {
	            conn = DriverManager.getConnection(URL, USER, PASS);
	            System.out.println("Connected to database successfully!");
	        } catch (Exception e) {
	            System.out.println("Connection failed: " + e.getMessage());
	        }
	    }

	    //Function for Add employee
	    private void addEmployee() {
	        try {
	            System.out.print("Enter name: ");
	            String name = scanner.nextLine();

	            System.out.print("Enter email: ");
	            String email = scanner.nextLine();

	            System.out.print("Enter salary: ");
	            double salary = Double.parseDouble(scanner.nextLine());

	            String sql = "INSERT INTO employees_Intern (name, email, salary) VALUES (?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);

	            stmt.setString(1, name);
	            stmt.setString(2, email);
	            stmt.setDouble(3, salary);

	            stmt.executeUpdate();
	            System.out.println("Employee added successfully!");
	        } catch (Exception e) {
	            System.out.println("Error adding employee: " + e.getMessage());
	        }
	    }

	    //Function for View employees
	    private void viewEmployees() {
	        try {
	            String sql = "SELECT * FROM employees_Intern";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            System.out.println("\n--- Employee List ---");
	            while (rs.next()) {
	                System.out.println(
	                        rs.getInt("id") + " | " +
	                        rs.getString("name") + " | " +
	                        rs.getString("email") + " | " +
	                        rs.getDouble("salary")
	                );
	            }
	            System.out.println("-----------------------\n");

	        } catch (Exception e) {
	            System.out.println("Error retrieving employees: " + e.getMessage());
	        }
	    }

	    //Function for Update employee
	    private void updateEmployee() {
	        try {
	            System.out.print("Enter employee ID to update: ");
	            int id = Integer.parseInt(scanner.nextLine());

	            System.out.print("New name: ");
	            String name = scanner.nextLine();

	            System.out.print("New email: ");
	            String email = scanner.nextLine();

	            System.out.print("New salary: ");
	            double salary = Double.parseDouble(scanner.nextLine());

	            String sql = "UPDATE employees_Intern SET name=?, email=?, salary=? WHERE id=?";
	            PreparedStatement stmt = conn.prepareStatement(sql);

	            stmt.setString(1, name);
	            stmt.setString(2, email);
	            stmt.setDouble(3, salary);
	            stmt.setInt(4, id);

	            int rows = stmt.executeUpdate();
	            if (rows > 0)
	                System.out.println("Employee updated successfully!");
	            else
	                System.out.println("Employee not found.");

	        } catch (Exception e) {
	            System.out.println("Error updating employee: " + e.getMessage());
	        }
	    }

	    //Function for Delete employee
	    private void deleteEmployee() {
	        try {
	            System.out.print("Enter employee ID to delete: ");
	            int id = Integer.parseInt(scanner.nextLine());

	            String sql = "DELETE FROM employees_Intern WHERE id = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, id);

	            int rows = stmt.executeUpdate();
	            if (rows > 0)
	                System.out.println("Employee deleted successfully!");
	            else
	                System.out.println("Employee not found.");

	        } catch (Exception e) {
	            System.out.println("Error deleting employee: " + e.getMessage());
	        }
	    }

	    //Function for App Menu
	    public void menu() {
	        while (true) {
	            System.out.println("\n===== Employee Database App =====");
	            System.out.println("1. Add Employee");
	            System.out.println("2. View Employees");
	            System.out.println("3. Update Employee");
	            System.out.println("4. Delete Employee");
	            System.out.println("0. Exit");
	            System.out.print("Choose an option: ");

	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1": addEmployee(); break;
	                case "2": viewEmployees(); break;
	                case "3": updateEmployee(); break;
	                case "4": deleteEmployee(); break;
	                case "0":
	                    System.out.println("Exiting... Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid option. Try again.");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        EmployeeApp app = new EmployeeApp();
	        app.menu();
	    }

}

