package group9;

import java.util.ArrayList;
import java.util.Scanner;


public class HotelLogic {

    public ArrayList<Customer> customerList = new ArrayList<>();
    public ArrayList<Rooms> roomsList = new ArrayList<>();
    public ArrayList<Booking> bookingList = new ArrayList<>();


    //list of Rooms for the Demo.

    Rooms firstRoom = new Rooms(100,2,true,700,false);
    Rooms secondRoom = new Rooms(200,1,false,800,true);
    Rooms thirdRoom = new Rooms(300,2,true,900,false);
    Rooms fourthRoom = new Rooms(400,3,false,500,true);
    Rooms fifthRoom = new Rooms(500,2,true,600,false);


    //list of Customer for the Demo.

    Customer firstCustomer = new Customer("Kim","900928-4334","Stockholm street 39",074543401,true);
    Customer secondCustomer = new Customer("Fisher","800938-6834","Macao Millie-Rose gate 4",0745670401,false);
    Customer thirdCustomer = new Customer("Susanna ","700928-0934","Berlin street 34",0740456543,true);
    Customer fourthCustomer = new Customer("Millie-Rose","950978-7634","Sauna street 49",0740456454,false);



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