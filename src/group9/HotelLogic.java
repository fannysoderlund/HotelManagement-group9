package group9;

import java.util.ArrayList;
import java.util.Scanner;


public class HotelLogic {

    ArrayList<Rooms> roomsList = new ArrayList<>();
    ArrayList<Booking> bookingList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();


    public void listOfRooms() {

        Rooms firstRoom = new Rooms(100, 2, true, 700, false);
        Rooms secondRoom = new Rooms(200, 1, false, 800, true);
        Rooms thirdRoom = new Rooms(300, 2, true, 900, false);
        Rooms fourthRoom = new Rooms(400, 3, false, 500, true);
        Rooms fifthRoom = new Rooms(500, 2, true, 600, false);
        roomsList.add(firstRoom);
        roomsList.add(secondRoom);
        roomsList.add(thirdRoom);
        roomsList.add(fourthRoom);
        roomsList.add(fifthRoom);


    }

    public void listOfCustomer() {

        Customer firstCustomer = new Customer("Kim", "900928-4334", "Stockholm street 39", 074543401, true);
        Customer secondCustomer = new Customer("Fisher", "800938-6834", "Macao Millie-Rose gate 4", 0745670401, false);
        Customer thirdCustomer = new Customer("Susanna ", "700928-0934", "Berlin street 34", 0740456543, true);
        Customer fourthCustomer = new Customer("Millie-Rose", "950978-7634", "Sauna street 49", 0740456454, false);
        customerList.add(firstCustomer);
        customerList.add(secondCustomer);
        customerList.add(thirdCustomer);
        customerList.add(fourthCustomer);


    }

    public void listOfBookings() {
        Booking firstBooking = new Booking(100, 190214, 190216, 30.50, customerList.get(0));
        Booking secondBooking = new Booking(200, 190403, 190406, 35.50, customerList.get(2));

        bookingList.add(firstBooking);
        bookingList.add(secondBooking);


    }


    public void addRoom() {
        Scanner input = new Scanner(System.in);
        int roomNo;
        int noOfBeds;
        String answer;
        boolean balcony = false;
        double price;
        boolean availability;

        System.out.print("Enter the room number :  ");
        roomNo = input.nextInt();
        System.out.print("Enter number of beds :  ");
        noOfBeds = input.nextInt();
        System.out.print("Does the room have a balcony (yes/no) :  ");
        answer = input.next();
        if (answer.equals("yes")) {
            balcony = true;
        } else if (answer.equals("no")) {
            balcony = false;
        } else
            System.out.println("Incorrect reply");
        System.out.print("Enter the price : ");
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
        Customer customer;


        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "]" + customerList.get(i).toString());
        }
        System.out.println("What customer wants to make a booking?");

        customer = customerList.get(input.nextInt());
        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i).toString());
        }
        System.out.println("Choose a room to book:  ");
        room = input.nextInt();
        roomNo = roomsList.get(room).getRoomNo();
        System.out.print("Enter the check in date: ");
        checkInDate = input.nextLong();
        System.out.print("Enter the check out date:  ");
        checkOutDate = input.nextLong();
        price = roomsList.get(room).getPrice();
        System.out.printf("The price for a night is %f kr. ", price);

        Booking booking = new Booking(roomNo, checkInDate, checkOutDate, price, customer);
        bookingList.add(booking);


    }
    public void removeCustomer() {

        listOfCustomer();
        Scanner input = new Scanner (System.in);
        System.out.println("Enter SSN: ");
        String SSN = input.nextLine();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getSSN().equalsIgnoreCase(SSN)){
                customerList.remove(i);
                System.out.printf("Guest with SSN: %s is removed%n", SSN);
            }
        }

    }
    public void removeRooms() {
        listOfRooms();
        Scanner input = new Scanner (System.in);
        System.out.println("Enter the room number; ");
        int roomNo = input.nextInt();

        for (int i = 0; i <roomsList.size() ; i++) {
            if (roomsList.get(i).getRoomNo()==(roomNo)){
                roomsList.remove(i);
            }
            System.out.printf(" The added room %d is now removed ", roomNo);

        }

    }

    public void removeBooking() {
        listOfBookings();
        Scanner input = new Scanner (System.in);
        System.out.println("Enter the room number: ");
        int roomNo = input.nextInt();


        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getRoomNo()==(roomNo)) {
                bookingList.remove(i);
                System.out.printf(" The booked room %d is now removed ", roomNo);
            }

        }

    }


    public void checkOut() {
        Scanner input = new Scanner(System.in);
        int customerToCheckOut;

        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "] " + customerList.get(i).toString());
        }
        while (true) {
            try {
                customerToCheckOut = input.nextInt();
                customerList.get(customerToCheckOut).setCheckedIn(false);
                break;

            } catch (Exception e) {
                System.out.println("That customer doesn't exist, try again");
            }
        }
        for (int i = 0; i < bookingList.size(); i++) {

            if (customerList.get(customerToCheckOut) == bookingList.get(i).getCustomer()) {
                roomsList.get(i).setAvailability(false);
            }

        }
    }
}