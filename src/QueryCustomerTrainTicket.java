import entity.CustomerTrainTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryCustomerTrainTicket {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CustomerTrainTicket.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

            //Query Student: All Students
            List<CustomerTrainTicket> theCustomer = session.createQuery("from CustomerTrainTicket").getResultList();
            //Display Students
//          session.createQuery("from Customer").getResultList();

            //Query CustomerTrainTicket from CustomerTrainTicket table where: ='female'
            theCustomer = session.createQuery("select Boarding_Pass_Num, lastName from CustomerTrainTicket c where c.Gender='female'").getResultList();
            //Display results
            System.out.println("\nDisplaying all the Customers that are female.");
            displayStudents(theCustomer);

            //Query Student: lastName='Skywalker' OR firstName='Ellie'
            theCustomer = session.createQuery("from Student s where lastName='Skywalker' OR firstName='Ellie'").getResultList();
            //Display results
            System.out.println("\nDisplaying all the students with last name Skywalker or first name Ellie...");
            displayStudents(theCustomer);

            //Query Student: where email LIKE '%too@gmail.com'
            theCustomer = session.createQuery("from Student s where s.email LIKE '%too@gmail.com'").getResultList();
            //Display results
            System.out.println("\nDisplaying all the students with the everett@code.com email address...");
            displayStudents(theCustomer);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<CustomerTrainTicket> theCustomer) {
        for(CustomerTrainTicket tempCustomer : theCustomer) {
            System.out.println(tempCustomer);
        }
    }
}
