//* Write a Java program that allows the user to create a bank account and perform
//transactions such as deposit, withdrawal, and balance inquiry.
//Using a conditional operator (ternary operator ), display the message whether minimum
//balance is maintained or not. Steps:
//● Create a class BankAccount
//● Add three member variables: String accountHolderName , int accountNumber and
//int balance;
//● Add a constructors using all three members
//● Add getters and setters.
//● Add method deposit (int), withdraw(int)
//● Implement the methods by increasing or decreasing the balance
//● In the main method create a bank account
//● Withdraw money from this account and/or deposit into this account
//● Get the balance
//● Create a string variable “status” inside the main method
//● Assign values to status as “Minimum Balance Maintained” if balance is above or
//equal to 5000.
//Otherwise values of status will be “Minimum Balance not Maintained”.
//Use conditional operator (ternary operator ) to assign the values of the status.
//● Display the status */
//Code:-
import java.util.Scanner;
public class BankAccount {
private String accountHolderName;
private int accountNumber;
private int balance;
public BankAccount(String accountHolderName, int accountNumber, int balance) {
this.accountHolderName = accountHolderName;
this.accountNumber = accountNumber;
this.balance = balance;
}
public String getAccountHolderName() {
return accountHolderName;
}
public int getAccountNumber() {
return accountNumber;
}
public int getBalance() {
return balance;
}
public void setAccountHolderName(String name) {
this.accountHolderName = name;
}
public void setAccountNumber(int number) {
this.accountNumber = number;
}
public void setBalance(int balance) {
this.balance = balance;
}
public void deposit(int amount) {
balance += amount;
System.out.println("Deposited: ₹" + amount);
}
public void withdraw(int amount) {
if (amount > balance) {
System.out.println("Insufficient balance! Withdrawal failed.");
} else {
balance -= amount;
System.out.println("Withdrawn: ₹" + amount);
}
}
public static void main(String[] args) {
Scanner nk = new Scanner(System.in);
System.out.print("Enter Account Holder Name: ");
String name = nk.nextLine();
System.out.print("Enter Account Number: ");
int number = nk.nextInt();
System.out.print("Enter Initial Balance: ");
int initialBalance = nk.nextInt();
BankAccount account = new BankAccount(name, number, initialBalance);
System.out.print("Enter amount to deposit: ");
int depositAmount = nk.nextInt();
account.deposit(depositAmount);
System.out.print("Enter amount to withdraw: ");
int withdrawAmount = nk.nextInt();
account.withdraw(withdrawAmount);
int currentBalance = account.getBalance();
System.out.println("Final Balance: ₹" + currentBalance);
String status = (currentBalance >= 5000) ? "Minimum Balance Maintained" :
"Minimum Balance not Maintained";
System.out.println("Status: " + status);
}
}