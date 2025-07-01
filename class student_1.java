public class Student_1 {
  String name;
  int age;
  String department;
  Student_1(){
    name="Unknown";
    age=20;
    department="Unassigned";
   }
   Student_1(String name,int age) {
    this.name=name;
    this.age=age;
    department="IT";
  }
  Student_1(String name,int age,String department) {
    this.name=name;
    this.age=age;
    this.department=department;
  }
  void display() {
    System.out.println("name: "+name+"\nage: "+age+"\ndepartment:"+department);
    System.out.println();
  }
  public stac void main(String[] args) {
    Student_1 s1=new Student_1();
    s1.display();
    Student_1 s2=new Student_1("gayatri dhage",20);
    s2.display();
    Student_1 s3=new Student_1("sadhana chaugule",20,"Computer Engg.");
    s3.display();
  }
}