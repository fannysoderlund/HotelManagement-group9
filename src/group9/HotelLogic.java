package group9;

import java.util.*;

public class HotelLogic {
        HotelLogic myApp = new HotelLogic();


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



    public void addRoom() {
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
        System.out.print("Does the room have a balcony (type in true or false):  ");
        balcony = input.hasNext();
        System.out.print("Enter the price: ");
        price = input.nextDouble();
        availability = true;

        Rooms rooms = new Rooms(roomNo, noOfBeds, balcony, price, availability);
        roomsList.add(rooms);



    }




    public void addBooking() {

        Scanner input = new Scanner(System.in);
        int room;
        int roomNo;
        long checkInDate;
        long checkOutDate;
        double price;

        System.out.println("Choose a room to book:  ");

        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" +i + "]"+ roomsList.get(i).toString());
        }
        room = input.nextInt();
        roomNo=roomsList.get(room).getRoomNo();
        System.out.print("Enter the check in date: ");
        checkInDate = input.nextLong();
        System.out.print("Enter the check out date:  ");
        checkOutDate = input.nextLong();
        price = roomsList.get(room).getPrice();
        System.out.printf("The price for a night is %f kr. ", price);

        Booking booking = new Booking(roomNo, checkInDate, checkOutDate, price);
        bookingList.add(booking);






    }

        }



