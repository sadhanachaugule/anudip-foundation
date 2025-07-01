import java.util.Scanner; 
public class car {     String make;     String model;     short year; 
    int price; 
 
    public car(String make, String model, short year, int price) {         this.make = make;         this.model = model;         this.year = year; 
        this.price = price; 
    } 
 
    public void displayInfo() { 
        System.out.println("Make  : " + make); 
        System.out.println("Model : " + model); 
        System.out.println("Year  : " + year); 
        System.out.println("Price : " + price); 
    }     
    public static void main(String[] args) {         Scanner sc = new Scanner(System.in); 
 
        System.out.print("How many cars do you want to enter? ");         int count = sc.nextInt();         sc.nextLine();  
 
        car[] cars = new car[count]; 
 
        for (int i = 0; i < count; i++) { 
            System.out.println("\nEnter details for Car #" + (i + 1)); 
 
            System.out.print("Enter Make: "); 
            String make = sc.nextLine(); 
 
            System.out.print("Enter Model: "); 
            String model = sc.nextLine(); 
 
            System.out.print("Enter Year: ");             short year = sc.nextShort(); 
 
            System.out.print("Enter Price: ₹"); 
            int price = sc.nextInt();             sc.nextLine();  
            cars[i] = new car(make, model, year, price); 
        } 
        System.out.println("\nCAR DETAILS"); 
        for (car c : cars) { 
            c.displayInfo(); 
        } 
        sc.close(); 
    } 
} 
