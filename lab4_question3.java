//ASSIGNMENT 3 
//3. Write a program to count and print the total number of odd and even numbers from user inputs. Program will ask for user inputs in a loop. Loop will terminate if -1 is entered as input. 
 
//SOURCE CODE: 

import java.util.Scanner; 
 
public class lab4_question3 {     
    public static void main(String[] args) {         
        Scanner sc = new Scanner(System.in);         
        int evenCount = 0, oddCount = 0; 
 
        while (true) { 
            System.out.print("Enter a number (-1 to stop): ");             
            int num = sc.nextInt();             
            if (num == -1) {                 
                break; 
            } 
            if (num % 2 == 0) {                 
                evenCount++; 
            } else { 
                oddCount++; 
            } 
        } 
 
        System.out.println("Total even numbers: " + evenCount); 
        System.out.println("Total odd numbers: " + oddCount); 
    } 
} 
