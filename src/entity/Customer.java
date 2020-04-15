package entity;



import javax.persistence.*;
//Student Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "Customer") //This is for the actual name of the database table name we are mapping to the class.
public class Customer {
    //Database Mapping
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "ID") //This is mapping the primary key to the id column in your database.
    private int id;

    @Column(name = "firstName") //This will map the firstName field to the column named first_name in your student table.
    private String firstName;

    @Column(name = "lastName") //This will map the lastName field to the column named last_name in your student table.
    private String lastName;

    @Column(name = "Email") //This will map the email field to the column named email in your student table.
    private  String email;

    @Column(name = "Phone_Number") //This will map the email field to the column named email in your student table.
    private  String phoneNumber;

    @Column(name = "Age") //This will map the email field to the column named email in your student table.
    private  int age;

    @Column(name = "Gender") //This will map the email field to the column named email in your student table.
    private  String Gender;

    //Constructors
    public  Customer() {

    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, int age,String Gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.Gender = Gender;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {return email; }

    public void setEmail(String email) {this.email = email; }

    public String getPhoneNumber() {return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public int getAge() {return age; }

    public void setAge(int age) {this.age = age; }

    public String getGender() {return Gender; }

    public void setGender(String gender) {this.Gender = gender; }

    //To string method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Email='" + email + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", Age ='" + String.valueOf(age)+ '\'' +
                ", Gender ='" + Gender+ '\'' +
                '}';
    }
}


