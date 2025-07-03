public import java.sql.*;
import java.util.Scanner;

public class PROJECT2_JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/student_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "moreboi10";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("database connected !! ");

            createTable(connection);
            Scanner sc = new Scanner(System.in);
            int ch;
            do {
                System.out.println("--------------------------------------------MENU-----------------------------------");
                System.out.println("1 . ADD Student ");
                System.out.println("2 . VIEW TABLE ");
                System.out.println("3 . UPDATE TABLE ");
                System.out.println("4 . remove student ");
                System.out.println("5 . SELECT VIA ID");
                System.out.println("0 . EXIT");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println();
                System.out.print("Enter your choice : ");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        int n;
                        System.out.println("Enter the number of Students to add : ");
                        n = sc.nextInt();
                        for (int i = 0; i < n; i++) {
                            System.out.print("enter Studend_id  : ");
                            int stud_id = sc.nextInt();
                            System.out.print("enter name    : ");
                            String name = sc.next();
                            System.out.print("enter email   : ");
                            String email = sc.next();
                            System.out.print("enter allowance  : ");
                            int allowance = sc.nextInt();
                            System.out.print("enter graduation year  : ");
                            int grad_year = sc.nextInt();
                            System.out.print("enter branch  : ");
                            String branch = sc.next();
                            insertData(connection, stud_id, name, email, allowance, grad_year, branch);
                        }
                        break;

                    case 2:
                        retrieveData(connection);
                        break;

                    case 3:
                        int t;
                        System.out.println("Enter the number of Students to update : ");
                        t = sc.nextInt();
                        for (int i = 0; i < t; i++) {
                            System.out.print("enter stud_id to make changes to : ");
                            int id = sc.nextInt();
                            System.out.print("enter new_allowance  : ");
                            int new_allowance = sc.nextInt();
                            updateData(connection, id, new_allowance);
                        }
                        break;

                    case 4:
                        System.out.print("Enter stud_id to remove Student : ");
                        int id = sc.nextInt();
                        deleteData(connection, id);
                        break;

                    case 5:
                        System.out.print("Enter the stud_id to display : ");
                        int stud_id = sc.nextInt();
                        selectviaid(connection, stud_id);
                        break;
                }
            } while (ch != 0);
            connection.close();
            System.out.println("database closed !");
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createtablesql = "CREATE TABLE IF NOT EXISTS users (" +
                "stud_id INT PRIMARY KEY," +
                "name varchar(50)," +
                "email varchar(100) UNIQUE," +
                "allowance INT," +
                "grad_year INT," +
                "branch varchar(50)" +
                ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createtablesql);
            System.out.println("Table User created succesfully !!");
        }
    }

    private static void insertData(Connection connection, int stud_id, String name, String email, int allowance, int grad_year, String branch) throws SQLException {
        String insertdatasql = "INSERT INTO users (stud_id,name,email,allowance,grad_year,branch) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertdatasql)) {
            pstmt.setInt(1, stud_id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setInt(4, allowance);
            pstmt.setInt(5, grad_year);
            pstmt.setString(6, branch);
            pstmt.executeUpdate();
            System.out.println("Inserted: " + name);
        }
    }

    private static void retrieveData(Connection connection) throws SQLException {
        String retrivedata = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(retrivedata)) {
            System.out.println("Student Data");
            while (rs.next()) {
                System.out.println("stud_id :" + rs.getInt("stud_id") + ", Name : " + rs.getString("name") + ", Email : " + rs.getString("email") + ", allowance :" + rs.getInt("allowance") +
                        ", grad_year : " + rs.getInt("grad_year") +
                        ", branch : " + rs.getString("branch"));
            }
        }
    }

    private static void updateData(Connection connection, int id, int new_allowance) throws SQLException {
        String updatesql = "UPDATE users SET allowance = ? WHERE stud_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updatesql)) {
            pstmt.setInt(1, new_allowance);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("updated allowance for ID :" + id);
            } else {
                System.out.println("nothing updated !!");
            }
        }
    }

    private static void deleteData(Connection connection, int id) throws SQLException {
        String deletesql = "DELETE FROM users WHERE stud_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deletesql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Deleted user with stud_id : " + id);
        }
    }

    private static void selectviaid(Connection connection, int id) throws SQLException {
        String selectQuery = "SELECT * FROM users WHERE stud_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectQuery)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Employee Data:");
                if (rs.next()) {
                    System.out.println("stud_id: " + rs.getInt("stud_id") +
                            ", Name: " + rs.getString("name") +
                            ", Email: " + rs.getString("email") +
                            ", allowance: " + rs.getInt("allowance") +
                            ", Graduation Year: " + rs.getInt("grad_year") +
                            ", Branch: " + rs.getString("branch"));
                } else {
                    System.out.println("No student found with ID: " + id);
                }
            }
        }
    }

}
