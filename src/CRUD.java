import entity.Customer;
import entity.TrainTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Time;
import java.util.List;

public class CRUD {


    public void createCustomer(String first, String last, String email, String phoneNumber, int age, String Gender) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

            System.out.println("Creating an employee object...");
           Customer cust = new Customer(first, last, email,phoneNumber,age,Gender);


            //start a transaction

            System.out.println("Beginning transaction...");

            //save the student object
            session.save(cust);

            System.out.println("Saving the new employee...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");


    }
    public void createTicket(String date, String origin, String destination, Time ETA, String departureTime, double ticketPrice) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

            System.out.println("Creating an employee object...");
           TrainTicket ticket = new TrainTicket(date,origin,destination,ETA,departureTime,ticketPrice);


            //start a transaction

            System.out.println("Beginning transaction...");

            //save the student object
            session.save(ticket);

            System.out.println("Saving the new employee...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");


    }
    public void readCustomerRow(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Customer cust= session.get(Customer.class,id);
        System.out.println("Customer: "+ cust);

    }
    public void readTicketRow(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(TrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        TrainTicket tic= session.get(TrainTicket.class,id);
        System.out.println("Train Ticket: "+ tic);

    }
    public void queryRow(String x){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Customer> workers= session.createQuery("from Customer s where s."+x+"='"+x+"'").getResultList();
        printC(workers);
        session.getTransaction().commit();
        factory.close();


    }public void queryTicketRow(String x){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(TrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<TrainTicket> workers= session.createQuery("from TrainTicket s where s."+x+"='"+x+"'").getResultList();
        printT(workers);
        session.getTransaction().commit();
        factory.close();


    }
    public void printC(List<Customer>e)
    {
        for(Customer a:e)
        {
            System.out.println(a);
        }
    }
    public void printT(List<TrainTicket>e)
    {
        for(TrainTicket a:e)
        {
            System.out.println(a);
        }
    }
    public void deleteRow(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Customer Emp= session.get(Customer.class,id);
        System.out.println("Delete employee: "+ Emp.getFirstName()+" "+Emp.getLastName());
        session.delete(Emp);
        session.getTransaction().commit();
        factory.close();
    }


}
