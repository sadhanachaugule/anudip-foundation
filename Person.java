//ASSIGNMENT-3.  
//●	Create a class Person  
//●	Add member variables name as String, age and salary as int  ● Initialize the member variable along with declaration.  
//●	Now put the previous Person class in a package com.anudip.learning  ● Add a main method. Add a print message “Test Successful”.  
//●	Run the class after compilation.  
//●	Modify the classpaths to see the error messages on the console. 
 
//package com.anudip.learning;

public class Person {
    String name = "sadhana chaugule";
    int age = 20;
    int salary = 30000;

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println("Test successful");
    }
} 

