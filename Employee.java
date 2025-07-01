//ASSIGNMENT-2.  
//●	Create a new class Employee  
//●	Add member variables: id and age of type int, name of type String and isPermanent of type boolean  ● Now assign values 35.5 to age; See the error message. ● How can you avoid this error? Correct the error by casting.  
//●	Make all the members protected ● Add a main method to it. Print message “Successfully started”.  
//●	Compile the class.  
 
//SOURCE CODE : 
public class Employee {
protected int id,age;
protected String name;     
protected boolean ispermanent; 
 
    public static void main(String[] args) {
        Employee em1 = new Employee(); 
        em1.id = 100;  // em1.age = 35.5;   //datatype mismatch         
        em1.age = (int)35.5;  //implicit type cast         em1.ispermanent = true; 
 
        System.out.println("successfully started !!"); 
    }     
} 
 

