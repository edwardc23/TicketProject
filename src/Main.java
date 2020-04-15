import entity.Customer;
import entity.TrainTicket;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static CRUD crud= new CRUD();
    static Customer current;
    static TrainTicket ticket;
    public static void main(String[] args) {
        System.out.println("For New Customer type 1 and  for returning customer type 2");
        int ans= in.nextInt();

        while(ans!=1&&ans!=2)
        {
            System.out.println("Try Again");
           ans=in.nextInt();
        }

        if(ans==1)
        {
            createCustomer();
        }
        else if(ans==2)
        {
            int limit= crud.queryRow();
            System.out.print("Choose a number: ");
            int id=in.nextInt();
            while(id>limit||id<=0)
            {
                id=in.nextInt();
            }
            current=crud.readCustomerRow(id-1);
        }



        System.out.println("Did it");


    }
    public static void createCustomer()
    {
        System.out.print("First name: ");
        String fName=in.next();
        System.out.println();
        System.out.print("Last name: ");
        String lName=in.next();
        System.out.println();
        System.out.print("Email: ");
        String email=in.next();
        System.out.println();
        System.out.println("Phone Number");
        String phoneNumber=in.next();
        System.out.println();
        System.out.println("Age");
        int age =in.nextInt();
        System.out.println();
        System.out.println("Gender");
        String Gender = in.next();
        current=crud.createCustomer(fName,lName,email,phoneNumber,age,Gender);

    }
    public static void getPrice(Customer customer, TrainTicket ticket)
    {
        if(customer.getAge()<=12)
        {
            ticket.setTicketPrice(ticket.getTicketPrice()*.50);
        }
        else if(customer.getAge()>=60)
        {
            ticket.setTicketPrice(ticket.getTicketPrice()*.40);
        }
        if(customer.getGender().toLowerCase().equals("female".toLowerCase()))
        {
            ticket.setTicketPrice(ticket.getTicketPrice()*.75);
        }

    }

}