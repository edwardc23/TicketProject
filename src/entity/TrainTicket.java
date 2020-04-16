package entity;



import javax.persistence.*;
import java.sql.Time;

//Student Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "train_ticket") //This is for the actual name of the database table name we are mapping to the class.
public class TrainTicket {
    //Database Mapping
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "Boarding_Pass_Num") //This is mapping the primary key to the id column in your database.
    private int boardingPass;

    @Column(name = "Customer_ID")
    private int customerPFK;

    @ManyToOne(targetEntity = Customer.class, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})//This links the Customer Id to the train ticket.
    @JoinColumn(name = "Customer_ID", referencedColumnName = "Customer_ID")
    private Customer customer; //This is mapping the primary key to the id column in your database.


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
    public TrainTicket() {

    }

    public TrainTicket(String date, String origin, String destination, String ETA, String departureTime, double ticketPrice) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer id) {
        this.customer = customer;
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
//    public String toString() {
////        return "Student{" +
////                "id=" + id +
////                ", firstName='" + firstName + '\'' +
////                ", lastName='" + lastName + '\'' +
////                ", Email='" + email + '\'' +
////                ", Phone Number='" + phoneNumber + '\'' +
////                ", Age ='" + String.valueOf(age)+ '\'' +
////                ", Gender ='" + Gender+ '\'' +
////                '}';
//    }
}


