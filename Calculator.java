//Assignment-2.  
//●	Write a Java program that demonstrates method overloading by creating a class called Calculator.  
//●	Add three methods called add().  
//●	The first add() method should take two int variables as arguments and return their sum as int.  
//●	The second add() method should take three int variables as arguments and return their sum as int.  
//●	The third add() method should take two doubles as arguments and return their sum as double.  
//●	The program should allow the user to display the results of each method. 
 
//SOURCE CODE : 
import java.util.Scanner; 
 
public class Calculator {
    public int add(int a, int b) { 
        return a + b; 
    } 
    public int add(int a, int b, int c) {
        return a + b + c; 
    } 
    public double add(double a, double b) {
        return a + b; 
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        Calculator calc = new Calculator(); 
 
        System.out.println("Choose type of addition :"); 
        System.out.println("1. Add two int"); 
        System.out.println("2. Add three int"); 
        System.out.println("3. Add two doubles");
        System.out.print("Enter choice (1-3): "); 
        int choice = sc.nextInt(); 
 
        switch (choice) {             case 1: 
                System.out.print("Enter first int: ");
                int a = sc.nextInt(); 
                System.out.print("Enter second int: "); 
                int b = sc.nextInt(); 
                System.out.println("Sum: " + calc.add(a, b));
                break;
                case 2: 
                System.out.print("Enter first int: ");
                int x = sc.nextInt(); 
                System.out.print("Enter second int: ");
                int y = sc.nextInt(); 
                System.out.print("Enter third int: "); 
                int z = sc.nextInt(); 
                System.out.println("Sum: " + calc.add(x, y, z));
                break;
                case 3: 
                System.out.print("Enter first double: ");
                double p = sc.nextDouble(); 
                System.out.print("Enter second double: ");
                double q = sc.nextDouble(); 
                System.out.println("Sum: " + calc.add(p, q)); 
                break;
                default: 
                System.out.println("Invalid choice."); 
        } 
 
        sc.close(); 
    } 
} 
