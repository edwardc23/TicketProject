import entity.CustomerTrainTicket;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static CRUD crud= new CRUD();

    static CustomerTrainTicket current;
    public static void main(String[] args) {
        System.out.println(getETA("11:00 pm"));
       // createCustomerTicket();
//        System.out.println("For New Customer type 1 and for returning customer type 2");
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
//            createCustomerTicket();
//
//        }
//        else if(ans==2)
//        {
//            int limit= crud.queryRow();
//            System.out.print("Choose a number: ");
//            int id=in.nextInt();
//            while(id>limit||id<=0)
//            {
//                id=in.nextInt()-1;
//            }
//            current=crud.readCustomerRow(id);
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
        String Gender = new Scanner(System.in).next();
        System.out.println();

        System.out.print("Date: ");
        String date=new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("Origin: ");
        String origin=new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("Destination: ");
        String dest=new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("Departure time: ");
        String dept =new Scanner(System.in).next(); // clear buffer for scanner.
        System.out.println();

        System.out.print("ETA: ");
        String ETA=getETA(dept); // clear buffer for scanner.
        System.out.println();

        System.out.print("Ticket Price: ");
        double price =getPrice(50.00,age,Gender); // clear buffer for scanner.
        current=crud.createTicket(fName,lName,email,phoneNumber,age,Gender,date,origin,dest,ETA,dept,price);

    }
    public static String getETA(String depart)
    {
        String hr="";
        String newTime="";
        if(depart.length()==7)
        {
            hr=String.valueOf(Integer.parseInt(String.valueOf(depart.charAt(0)))+2);
            newTime=hr+depart.substring(1);
        }
        else if(depart.length()==8) {
            if (!depart.substring(0, 2).equals("12")) {
                hr = String.valueOf(Integer.parseInt(String.valueOf(depart.substring(0, 2))) + 2);
                if (Integer.parseInt(hr) <= 12) {
                    if (depart.substring(6).equals("am")) {
                        newTime = hr + depart.substring(2, 5) + " pm";
                    } else if (depart.substring(6).equals("pm")) {
                        newTime = hr + depart.substring(2, 5) + " am";
                    }

                } else {
                    hr = String.valueOf(Integer.parseInt(hr) - 12);
                    if (depart.substring(6).equals("am")) {
                        newTime = hr + depart.substring(2, 5) + " pm";
                    } else if (depart.substring(6).equals("pm")) {
                        newTime = hr + depart.substring(2, 5) + " am";

                    }
                }

            }
            else{
                hr = String.valueOf(Integer.parseInt(depart.substring(0, 2)) + 2);
                hr = String.valueOf(Integer.parseInt(hr) - 12);
                newTime = hr + depart.substring(2);

                }
        }
        return newTime;
    }
    public static double getPrice(double price, int age, String Gender)
    {
        System.out.println("Original Price: "+price);
        if(age<=12)
        {
           price=price*.50;
            System.out.println("Reduced Price: "+price);
        }
        else if(age>=60)
        {
            price=price*.40;
            System.out.println("Reduced Price: "+price);
        }
        if(Gender.toLowerCase().equals("female".toLowerCase()))
        {
            price=price*.75;
            System.out.println("Reduced Price: "+price);
        }

        return price;
    }

}