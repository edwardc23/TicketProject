import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static CRUD crud= new CRUD();
    public static void main(String[] args) {
        LocalTime lt= LocalTime.now();//
      String fName="Edward";
      String lName="Cochran";
      String email=in.next();
      String phoneNumber=in.next();
      int age =in.nextInt();
       String Gender = in.next();

        crud.createCustomer(fName,lName,email,phoneNumber,age,Gender);
        System.out.println("Did it");


    }
}