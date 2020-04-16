import entity.CustomerTrainTicket;

import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
    static CRUD crud= new CRUD();

    static CustomerTrainTicket current;
    public static void main(String[] args) {

        createCustomerTicket();
//        System.out.println("For New Customer type 1 and  for returning customer type 2");
//        int ans= in.nextInt();
//
//        while(ans!=1&&ans!=2)
//        {
//            System.out.println("Try Again");
//           ans=in.nextInt();
//        }
//
//        if(ans==1)
//        {
//            createCustomer();
//        }
//        else if(ans==2)
//        {
//            int limit= crud.queryRow();
//            System.out.print("Choose a number: ");
//            int id=in.nextInt();
//            while(id>limit||id<=0)
//            {
//                id=in.nextInt();
//            }
//            current=crud.readCustomerRow(id-1);
//        }
//
//
//
//        System.out.println("Did it");


    }

    public static void createCustomerTicket()
    {

        System.out.print("First name: ");
        String fName=new Scanner(System.in).next();;
        System.out.println();
        System.out.print("Last name: ");
        String lName=new Scanner(System.in).next();;
        System.out.println();
        System.out.print("Email: ");
        String email=new Scanner(System.in).next();;
        System.out.println();
        System.out.print("Phone Number: ");
        String phoneNumber=new Scanner(System.in).next();;
        System.out.println();
        System.out.print("Age: ");
        int age =new Scanner(System.in).nextInt();;
        System.out.println();
        System.out.print("Gender: ");
        String Gender = new Scanner(System.in).next();;
        System.out.print("Date: ");
        String date=new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("Origin: ");
        String origin=new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("Destination: ");
        String dest=new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("ETA: ");
        String ETA=new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("Departure time: ");
        String dept =new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("Ticket Price: ");
        double price = new Scanner(System.in).nextDouble(); // clear buffer for scanner.
        current=crud.createTicket(fName,lName,email,phoneNumber,age,Gender,date,origin,dest,ETA,dept,price);

    }
    public static void getPrice(CustomerTrainTicket ticket)
    {
        if(ticket.getAge()<=12)
        {
            ticket.setTicketPrice(ticket.getTicketPrice()*.50);
        }
        else if(ticket.getAge()>=60)
        {
            ticket.setTicketPrice(ticket.getTicketPrice()*.40);
        }
        if(ticket.getGender().toLowerCase().equals("female".toLowerCase()))
        {
            ticket.setTicketPrice(ticket.getTicketPrice()*.75);
        }

    }

}