//ASSIGNMENT 1 
//1. Write a program to find out all the armstrong numbers within a given range using a method named printArmstrongNumber( int start, int end) by taking input from the user. The program should print the Armstrong number in a given range starting from “start” and ending with “end”. Armstrong Number Example: 153 1 3+5 3+3 3 =153 (Number which is equal to the sum of the cubes of its digits) Note: input should be taken from the keyboard. Use a loop to calculate the Armstrong number from “start” to “end”. Also use loops to calculate the cube of a number. Do not use the Math.pow() function. 
 
//SOURCE CODE : 
import java.util.Scanner; 
 
public class Lab4_question1 {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);         
        System.out.print("Enter start of range: ");         
        int start = sc.nextInt(); 
        System.out.print("Enter end of range: ");         
        int end = sc.nextInt(); 
        printArmstrongNumber(start, end);         
        sc.close(); 
    } 
 
    static void printArmstrongNumber(int start, int end) {
        System.out.println("Armstrong numbers in the range:");
        for (int num = start; num <= end; num++) {             
            int original = num;             
            int sum = 0;
            int temp = num;            
            int digits = 0; 
 
            while (temp > 0) {                 
                digits++;                 
                temp /= 10; 
            } 
 
            temp = num;             
            while (temp > 0) {                 
                int digit = temp % 10;                 
                int cube = 1; 
                for (int i = 0; i < digits; i++) {                     
                    cube *= digit; 
                } 
                sum += cube;
                temp /= 10; 
            } 
 
            if (sum == original) { 
                System.out.println(original); 
            } 
        } 
    } 
} 
