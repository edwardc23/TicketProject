package entity;



import javax.persistence.*;
import java.text.DecimalFormat;

//Student Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "CustomerTrainTicket") //This is for the actual name of the database table name we are mapping to the class.
public class CustomerTrainTicket {
    //Database Mapping
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "Boarding_Pass_Num") //This is mapping the primary key to the id column in your database.
    private int boardingPass;

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

    @Column(name = "Date") //This will map the firstName field to the column named first_name in your student table.
    private String date;

    @Column(name = "Origin") //This will map the lastName field to the column named last_name in your student table.
    private String origin;

    @Column(name = "Destination") //This will map the lastName field to the column named last_name in your student table.
    private String destination;

    @Column(name = "EstimatedTimeOfArrival") //This will map the email field to the column named email in your student table.
    private String ETA;

    @Column(name = "DepartureTime") //This will map the email field to the column named email in your student table.
    private  String departureTime;

    @Column(name = "TicketPrice") //This will map the email field to the column named email in your student table.
    private  double ticketPrice;



    //Constructors
    public CustomerTrainTicket() {

    }

    public CustomerTrainTicket(String firstName, String lastName, String email, String phoneNumber, int age,String Gender,String date, String origin, String destination, String ETA, String departureTime, double ticketPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.Gender = Gender;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.ETA = ETA;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;

    }

    public int getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(int boardingPass) {
        this.boardingPass = boardingPass;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

//    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat("0.00");

        return  boardingPass +", Date: " +date +", Origin: " + origin +  ", Destination: " + destination +", Estimated time of Arrival: " + ETA + ", Departure time: " + departureTime+"\n"+
                firstName + " " + lastName +", Email: " + email +  ", Phone Number: " + phoneNumber +", Gender: " + Gender + ", Age: " + age+"\n"+
                "Ticket Price: $"+df2.format(ticketPrice);


    }
}


