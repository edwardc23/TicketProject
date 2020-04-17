import entity.CustomerTrainTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class CRUD {



    public CustomerTrainTicket createTicket(String first, String last, String email, String phoneNumber, int age, String Gender,String date, String origin, String destination, String ETA, String departureTime, double ticketPrice) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)

                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

            System.out.println("Creating an Boarding Pass object...");
           CustomerTrainTicket ticket = new CustomerTrainTicket(first, last, email,phoneNumber,age,Gender,date,origin,destination,ETA,departureTime,ticketPrice);


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
    public CustomerTrainTicket readCustomerRow(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        CustomerTrainTicket customer= session.get(CustomerTrainTicket.class,id);
        System.out.println("Customer: "+ customer);
        return customer;

    }


    public void readTicketRow(int id) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        CustomerTrainTicket tic= session.get(CustomerTrainTicket.class,id);
        System.out.println("Train Ticket: "+ tic);

    }
/*
    public void queryRow(String x, String word) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List workers= session.createQuery("from Customer c where c."+x+"='"+word+"'").list();
        printT(workers);
        session.getTransaction().commit();
        factory.close();


    }

*/
   public CustomerTrainTicket queryRow() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List workers= session.createQuery("from CustomerTrainTicket ").list();
       CustomerTrainTicket current= printT(workers);
        session.getTransaction().commit();
        factory.close();
        return current;

    }



   public List<CustomerTrainTicket> queryRow(String email) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List workers= session.createQuery("from CustomerTrainTicket where Email = '"+email+"'").list();
        //printT(workers);
        session.getTransaction().commit();
        factory.close();
        return workers;
    }

    public CustomerTrainTicket printT(List<CustomerTrainTicket>e)
    {
        Scanner in = new Scanner(System.in);
        int x=1;
        for(CustomerTrainTicket a:e)
        {
            System.out.println(x+". "+a);
            x++;
        }
        System.out.print("Choose a number: ");
        int id=in.nextInt()-1;
        while(id>x||id<=0)
        {
            id=in.nextInt()-1;
        }

        return e.get(id);
    }
    public void deleteRow(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        CustomerTrainTicket Emp= session.get(CustomerTrainTicket.class,id);
        System.out.println("Delete employee: "+ Emp.getFirstName()+" "+Emp.getLastName());
        session.delete(Emp);
        session.getTransaction().commit();
        factory.close();
    }
}
