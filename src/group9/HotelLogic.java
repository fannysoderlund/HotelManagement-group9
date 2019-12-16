package group9;

import java.util.ArrayList;
import java.util.Scanner;


class HotelLogic {

    ArrayList<Rooms> roomsList = new ArrayList<>();
    ArrayList<Booking> bookingList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();


    void listOfRooms() {

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

    void listOfCustomer() {

        Customer firstCustomer = new Customer("Kim", "900928-4334", "Stockholm street 39", 74543401, true);
        Customer secondCustomer = new Customer("Fisher", "800938-6834", "Macao Millie-Rose gate 4", 745670401, false);
        Customer thirdCustomer = new Customer("Susanna ", "700928-0934", "Berlin street 34", 740456543, true);
        Customer fourthCustomer = new Customer("Millie-Rose", "950978-7634", "Sauna street 49", 740456454, false);
        customerList.add(firstCustomer);
        customerList.add(secondCustomer);
        customerList.add(thirdCustomer);
        customerList.add(fourthCustomer);


    }

    void listOfBookings() {
        Booking firstBooking = new Booking(roomsList.get(0), 190214, 190216, 30.50, customerList.get(0));
        Booking secondBooking = new Booking(roomsList.get(2), 190403, 190406, 35.50, customerList.get(2));

        bookingList.add(firstBooking);
        bookingList.add(secondBooking);


    }


    void addRoom() {
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

    void addCustomer() {
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


    void addBooking() {
        Scanner input = new Scanner(System.in);

        Rooms room;
        int choiceOfRoom;
        long checkInDate;
        long checkOutDate;
        double price;
        Customer customer;


        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "]" + customerList.get(i).toString());
            customer = customerList.get(input.nextInt());
        }

        System.out.println("What customer wants to make a booking?");

        customer = customerList.get(input.nextInt());
        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i).toString());
        }
        System.out.println("Choose a room to book:  ");
        choiceOfRoom = input.nextInt();
        room = roomsList.get(choiceOfRoom);


        System.out.print("Enter the check in date: ");
        checkInDate = input.nextLong();
        System.out.print("Enter the check out date:  ");
        checkOutDate = input.nextLong();
        price = roomsList.get(choiceOfRoom).getPrice();

        System.out.printf("The price for a night is %f kr. ", price);

        Booking booking = new Booking(room, checkInDate, checkOutDate, price, customer);
        bookingList.add(booking);
    }

    void removeCustomer() {

        listOfCustomer();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter SSN: ");
        String SSN = input.nextLine();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getSSN().equalsIgnoreCase(SSN)) {
                customerList.remove(i);
                System.out.printf("Guest with SSN: %s is removed%n", SSN);
            }
        }

    }

    void editCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("What customer do you want to edit the information of?");
       Customer customer = customerList.get(input.nextInt());
            System.out.printf("\nName: " + customer.getName() +
                    "\n SSN: " + customer.getSSN() +
                    "\n address: " + customer.getAddress() +
                    "\n phone number: " + customer.getPhone() +
                    "\n CheckedIn : " + customer.isCheckedIn() + "\n \"\n ");

            System.out.println("Enter the new name  for costumer :");
            String newName = input.next();
            customer.setName(newName);
            System.out.println("Enter the new phone number for costumer :");
            long newPhone = Long.parseLong(input.next());
            customer.setPhone(newPhone);
            System.out.println("Enter the new address  for costumer :");
            String newAddress = input.next();
            customer.setAddress(newAddress);
            System.out.println("Enter the new check In  for costumer :");
            boolean CheckedIns = Boolean.parseBoolean(input.next());
            customer.setCheckedIn(CheckedIns);
        }



    void removeRooms() {
        listOfRooms();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i));
        }
        System.out.println("What room do you want to remove?");
        int roomToRemove = input.nextInt();
        roomsList.remove(roomToRemove);
        System.out.print(" The room is now removed");

    }

    void editRooms() {
        Scanner input = new Scanner(System.in);
        System.out.println("What room do you want to edit?");
        Rooms rooms = roomsList.get(input.nextInt());

            System.out.print("Room number: " + rooms.getRoomNo() +
                    "\n Number of beds: " + rooms.getNoOfBeds() +
                    ", " + rooms.isBalcony() +
                    "\n Price: " + rooms.getPrice() +
                    "  SEK " +
                    "\n Availability : " + rooms.isAvailability() + "\n \"\n ");


            System.out.println("Enter the new room number for the room : ");
            int newRoomNo = Integer.parseInt(input.next());
            rooms.setRoomNo(newRoomNo);
            System.out.println("Enter the new  number of beds for the room :");
            int newNoOfBeds = Integer.parseInt(input.next());
        
            rooms.setNoOfBeds(newNoOfBeds);
            System.out.println("Enter the new price for the room :");
            double newPrice = Double.parseDouble(input.next());
            rooms.setPrice(newPrice);
            System.out.println("Is it Available ? ");
            boolean newAvailability = Boolean.parseBoolean(input.nextLine());
            rooms.setAvailability(newAvailability);
        }


   public void removeBooking() {
        listOfBookings();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < bookingList.size(); i++) {
            System.out.println("[" + i + "]" + bookingList.get(i));
        }
        System.out.println("Which booking do you want to remove?");
        int removeBooking = input.nextInt();

        bookingList.remove(removeBooking);
        System.out.printf(" The booking is now removed ");
    }

    void editBooking() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a booking to edit");
     Booking booking = bookingList.get(input.nextInt());

            System.out.print(" \nRoom number : " + booking.getRoom() +
                    "\nCheck in on: " + booking.getCheckInDate() +
                    " \n Check out on: " + booking.getCheckOutDate() +
                    " \n Price: " + booking.getPrice() + "  SEK" +
                    " \n   - Customer who booked: " + booking.getCustomer() + "\n \"\n ");

            System.out.println("Enter the new price : ");
            double newBookingPrice = Double.parseDouble(input.next());
            booking.setPrice(newBookingPrice);
            System.out.println("Enter the new new check in date : ");
            long newCheckInDate = Long.parseLong(input.next());
            booking.setCheckInDate(newCheckInDate);
            System.out.println("Enter the new new check out date :");
            long newCheckOutDate = Long.parseLong(input.nextLine());
            booking.setCheckOutDate(newCheckOutDate);
        }


    void checkOut() {
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