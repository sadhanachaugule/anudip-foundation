import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {

    static final String DB_URL = "jdbc:mysql://localhost:3306/empdb";
    static final String USER = "root";
    static final String PASS = "sadhana@9421"; // Change this

    static Connection conn;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            while (true) {
                System.out.println("\n---- Employee Management System ----");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Search Employee by ID");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewAllEmployees();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        searchEmployeeById();
                        break;
                    case 5:
                        conn.close();
                        System.out.println("Exited.");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addEmployee() throws SQLException {
        System.out.print("Enter name: ");
        sc.nextLine(); // consume leftover newline
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setDouble(3, salary);
        ps.executeUpdate();
        System.out.println("Employee added successfully.");
    }

    static void viewAllEmployees() throws SQLException {
        String sql = "SELECT * FROM employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n-- All Employees --");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id")
                    + ", Name: " + rs.getString("name")
                    + ", Email: " + rs.getString("email")
                    + ", Salary: " + rs.getDouble("salary"));
        }
    }

    static void updateEmployee() throws SQLException {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new email: ");
        String email = sc.nextLine();
        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employee SET name=?, email=?, salary=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setDouble(3, salary);
        ps.setInt(4, id);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    static void searchEmployeeById() throws SQLException {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        String sql = "SELECT * FROM employee WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("id")
                    + ", Name: " + rs.getString("name")
                    + ", Email: " + rs.getString("email")
                    + ", Salary: " + rs.getDouble("salary"));
        } else {
            System.out.println("Employee not found.");
        }
    }
}
