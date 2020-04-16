import entity.Customer;
import entity.TrainTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CRUD {


    public Customer createCustomer(String first, String last, String email, String phoneNumber, int age, String Gender) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Creating an Customer object...");
        Customer customer = new Customer(first, last, email, phoneNumber, age, Gender);


        //start a transaction

        System.out.println("Beginning transaction...");

        //save the student object
        session.save(customer);

        System.out.println("Saving the new customer...");

        //commit the transaction
        session.getTransaction().commit();
        System.out.println("Done!");

        return customer;

    }

    public TrainTicket createTicket(String date, String origin, String destination, String ETA, String departureTime, double ticketPrice) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(TrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Creating an Boarding Pass object...");
        TrainTicket ticket = new TrainTicket(date, origin, destination, ETA, departureTime, ticketPrice);


        //start a transaction

        System.out.println("Beginning transaction...");

        //save the student object
        session.save(ticket);

        System.out.println("Saving the new Boarding Pass...");

        //commit the transaction
        session.getTransaction().commit();
        System.out.println("Done!");
        return ticket;
    }

    public Customer readCustomerRow(int id) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Customer customer = session.get(Customer.class, id);
        System.out.println("Customer: " + customer);
        return customer;

    }


    public void readTicketRow(int id) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(TrainTicket.class)
                .buildSessionFactory();

    }

    public void queryRow(String x, String word) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List workers = session.createQuery("from Customer c where c." + x + "='" + word + "'").list();
        printC(workers);
        session.getTransaction().commit();
        factory.close();


    }


    public int queryRow() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List workers = session.createQuery("from Customer ").list();
        int amount = printC(workers);
        session.getTransaction().commit();
        factory.close();
        return amount;

    }

    public void queryTicketRow(String x) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(TrainTicket.class)
                .buildSessionFactory();
    }

    public void queryRow(String x) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Customer> workers = session.createQuery("from Customer s where s." + x + "='" + x + "'").getResultList();
        printC(workers);
        session.getTransaction().commit();
        factory.close();

    }

    public int printC(List<Customer> e) {
        int x = 1;
        for (Customer a : e) {
            System.out.println(x + ". " + a);
            x++;
        }
        return x;
    }

    public void printT(List<TrainTicket> e) {
        for (TrainTicket a : e) {
            System.out.println(a);
        }
    }

    public void deleteRow(int id) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Customer Emp = session.get(Customer.class, id);
        System.out.println("Delete employee: " + Emp.getFirstName() + " " + Emp.getLastName());
        session.delete(Emp);
        session.getTransaction().commit();
        factory.close();
    }
}
