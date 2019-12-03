package group9;

import java.util.*;

public class HotelLogic {



    public static void main(String[] args) {
        HotelLogic myApp = new HotelLogic();
        myApp.addCustomer();
        myApp.addrooms();
        myApp.addbooking();

    }

    public ArrayList<Customer> customerList = new ArrayList<>();
    public ArrayList<Rooms> roomsList = new ArrayList<>();
    public ArrayList<Booking> bookingList = new ArrayList<>();





    public void addCustomer() {
        Scanner input = new Scanner(System.in);
        String name;
        String SSN;
        String address;
        long phone;
        boolean checkedIn;
        System.out.print("Enter name: ");
        SSN = input.nextLine();
        System.out.print("Enter SSN: ");
        name = input.nextLine();
        System.out.print("Enter address: ");
        address = input.nextLine();
        System.out.print("Enter phone number: ");
        phone = input.nextLong();
        System.out.print("Checked in:  ");
        checkedIn = input.hasNext();
        Customer customer = new Customer(name, SSN, address, phone, checkedIn);
        customerList.add(customer);
    }


  /*  private void addrooms() {
        int roomNo = 0;
        int noOfBeds = 2;
        boolean balcony = true;
         double price = 300.00;
        boolean availability = true;




            for (int i=0;i<10;i++)
            {

                int j=i+1;
                Rooms room=new Rooms(j);
                room.setRoomNo(0);
                room.setNoOfBeds(2);
                room.isBalcony();
                room.setPrice(300.00);
                room.isAvailability();

                Rooms rooms = new Rooms(roomNo, noOfBeds, true, price, true);
                roomsList.add(rooms);

            }

  */

    public void addrooms() {
        Scanner input = new Scanner(System.in);
        int roomNo;
        int noOfBeds;
        boolean balcony;
         double price;
        boolean availability;

        System.out.print("Enter number of room :  ");
        roomNo = input.nextInt();
        System.out.print("Enter number of beds :  ");
        noOfBeds = input.nextInt();
        System.out.print("Do you want with a balcony :  ");
        balcony = input.hasNext();
        System.out.print("Enter the price: ");
        price = input.nextDouble();
        System.out.print("Is the room available:  ");
        availability = input.hasNext();

        Rooms rooms = new Rooms(roomNo, noOfBeds, balcony, price, availability);
        roomsList.add(rooms);



    }




    public void addbooking() {

        Scanner input = new Scanner(System.in);
        int roomNo;
        long checkInDate;
        long checkOutDate;
        float price = 500;

        System.out.println("Make a booking:  ");

        System.out.print("Enter a room number: ");
        roomNo = input.nextInt();
        System.out.print("Enter the check in date: ");
        checkInDate = input.nextLong();
        System.out.print("Enter the check out date:  ");
        checkOutDate = input.nextLong();
        System.out.println("The price for a night is 500 kr. ");

        Booking booking = new Booking(roomNo, checkInDate, checkOutDate, price );
        bookingList.add(booking);






    }

        }



