package group9;

import java.awt.print.Book;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class HotelLogic {

    DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
    Date date = new Date();
    long dateNow = Long.parseLong(dateFormat.format(date));


    ArrayList<Rooms> roomsList = new ArrayList<>();
    ArrayList<Booking> bookingList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();


    void listOfRooms() {


        Rooms firstRoom = new Rooms(100, 2, true, 700, false);
        Rooms secondRoom = new Rooms(200, 1, false, 800, true);
        Rooms thirdRoom = new Rooms(300, 2, true, 900, true);
        Rooms fourthRoom = new Rooms(400, 3, false, 500, true);
        Rooms fifthRoom = new Rooms(500, 2, true, 600, false);
        roomsList.add(firstRoom);
        roomsList.add(secondRoom);
        roomsList.add(thirdRoom);
        roomsList.add(fourthRoom);
        roomsList.add(fifthRoom);
    }

    void listOfCustomer() {

        Customer firstCustomer = new Customer("Kim", "9009284334", "Stockholm street 39", "74543401", true);
        Customer secondCustomer = new Customer("Fisher", "8009386834", "Macao Millie-Rose gate 4", "745670401", false);
        Customer thirdCustomer = new Customer("Susanna ", "7009280934", "Berlin street 34", "740456543", true);
        Customer fourthCustomer = new Customer("Millie-Rose", "9509787634", "Sauna street 49", "740456454", false);
        customerList.add(firstCustomer);
        customerList.add(secondCustomer);
        customerList.add(thirdCustomer);
        customerList.add(fourthCustomer);

    }


    void listOfBookings() {

        Booking firstBooking = new Booking(roomsList.get(0), 190214, 190216, 30.50, customerList.get(0));
        Booking secondBooking = new Booking(roomsList.get(2), 190403, 190406, 35.50, customerList.get(2));
        Booking thirdBooking = new Booking(roomsList.get(2), 200403, 200406, 35.50, customerList.get(2));

        bookingList.add(firstBooking);
        bookingList.add(secondBooking);
        bookingList.add(thirdBooking);


    }


    void addRoom() {
        Scanner input = new Scanner(System.in);
        int roomNo;
        int noOfBeds;
        String answer;
        boolean balcony = false;
        double price;
        boolean availability = false;

        System.out.print("Enter the room number :  ");
        roomNo = input.nextInt();
        System.out.print("Enter number of beds :  ");
        noOfBeds = input.nextInt();
        do {
            System.out.println("Does the room have a balcony? ");
            answer = input.nextLine();
        } while (!answer.matches("[yesno]+"));
        if (answer.equals("yes")) {
            balcony = true;
        } else if (answer.equals("no")) {
            balcony = false;
        }
        do {
            System.out.println("Enter the price: ");
            answer = input.nextLine();
        } while (!answer.matches("[0-9]+"));
        price = Double.parseDouble(answer);
        do {
            System.out.println("Is it available? ");
            answer = input.nextLine();
        } while (!answer.matches("[yesno]+"));
        if (answer.equals("yes")) {
            availability = true;
        } else if (answer.equals("no")) {
            availability = false;
        }
        Rooms rooms = new Rooms(roomNo, noOfBeds, balcony, price, availability);
        roomsList.add(rooms);

    }

    void addCustomer() {
        Scanner input = new Scanner(System.in);
        String typed;
        String name;
        String SSN;
        String address;
        String phone;
        boolean checkedIn = false;


        do {
            System.out.println("Enter name: ");
            typed = input.nextLine();
        } while (!typed.matches("[A-Za-z]+"));
        name = typed;

        do {
            System.out.println("Enter SSN: ");
            typed = input.nextLine();
        } while (!typed.matches("[0-9]{10}"));
        SSN = typed;


        System.out.println("Enter address: ");
        address = input.nextLine();

        do {
            System.out.println("Enter phone number: ");
            typed = input.nextLine();
        } while (!typed.matches("[0-9]{10}"));
        phone = typed;

        do {
            System.out.println("Is customer checked in? ");
            typed = input.nextLine();
        } while (!typed.matches("[yesno]+"));
        if (typed.equals("yes")) {
            checkedIn = true;
        } else if (typed.equals("no")) {
            checkedIn = false;
        }


        Customer customer = new Customer(name, SSN, address, phone, checkedIn);
        customerList.add(customer);
    }


    void addBooking() {
        Scanner input = new Scanner(System.in);

        Rooms room;

        long checkInDate;
        long checkOutDate;
        double price;
        Customer customer;


        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "]" + customerList.get(i).toString());

        }

        System.out.println("What customer wants to make a booking?");
        while (true) {
            try {
                customer = customerList.get(input.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("Not a real customer");
            }
        }

        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i).toString());
        }
        System.out.println("Choose a room to book:  ");
        while (true) {
            try {
                room = roomsList.get(input.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("Not a real room");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter the check in date");
                checkInDate = input.nextLong();
                System.out.println(dateNow);
                while (checkInDate < dateNow) {
                    System.out.println("Not a future date");
                    checkInDate = input.nextLong();
                }

                System.out.println("Enter the check out date");
                checkOutDate = input.nextLong();
                while (checkOutDate < checkInDate) {
                    System.out.println("You cannot go back in time");
                    checkOutDate = input.nextLong();
                }
                break;
            } catch (Exception e) {
                System.out.println("Not a date");
                input.nextLine();
            }
        }

        price = room.getPrice();

        System.out.printf("The price for a night is %.2f kr%n", price);

        Booking booking = new Booking(room, checkInDate, checkOutDate, price, customer);
        bookingList.add(booking);


    }

    void removeCustomer() {
        int choice;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "]" + customerList.get(i).toString());
        }

        System.out.println("What customer do you want to remove?");
        while (true) {
            try {
                choice = input.nextInt();
                customerList.get(choice);
                break;
            } catch (Exception e) {
                System.out.println("Not a real customer");
            }
        }

        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getCustomer().equals(customerList.get(choice))) {
                bookingList.remove(i);
            }
        }
        customerList.remove(choice);


    }


    void editCustomer() {
        String typed;
        String name;
        String SSN;
        String address;
        String phone;
        int choice;


        Scanner input = new Scanner(System.in);

        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "]" + customerList.get(i));
        }
        System.out.println("What customer do you want to edit?");
        choice = input.nextInt();
        while (choice > customerList.size()) {
            System.out.println("Not an option");
            choice = input.nextInt();
        }
        Customer customer = customerList.get(choice);


        System.out.println(customer.toString());
        input.nextLine();
        do {
            System.out.println("Enter new name: ");
            typed = input.nextLine();
        } while (!typed.matches("[A-Za-z]+"));
        name = typed;
        customer.setName(name);

        do {
            System.out.println("Enter new SSN: ");
            typed = input.nextLine();
        } while (!typed.matches("[0-9]{10}"));
        SSN = typed;
        customer.setSSN(SSN);


        System.out.println("Enter new address: ");
        address = input.nextLine();
        customer.setAddress(address);

        do {
            System.out.println("Enter new phone number: ");
            typed = input.nextLine();
        } while (!typed.matches("[0-9]{10}"));
        phone = typed;
        customer.setPhone(phone);


        do {
            System.out.println("Is customer checked in? ");
            typed = input.nextLine();
        } while (!typed.matches("[yesno]+"));
        if (typed.equals("yes")) {
            customer.setCheckedIn(true);
        } else if (typed.equals("no")) {
            customer.setCheckedIn(false);
        }
    }


    void removeRooms() {
        listOfRooms();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i));
        }

        System.out.println("What room do you want to remove?");
        int roomToRemove = input.nextInt();
        while (roomToRemove > roomsList.size()) {
            System.out.println("That's not an option");
            roomToRemove = input.nextInt();
        }
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getRoom().equals(roomsList.get(roomToRemove))) {
                bookingList.remove(i);
            }

            roomsList.remove(roomToRemove);
            System.out.println(" The room is now removed");

        }
    }

    void editRooms() {
        String typed;
        Scanner input = new Scanner(System.in);
        boolean checkedIn = false;

        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i));
        }
        System.out.println("What room do you want to edit?");
        Rooms rooms = roomsList.get(input.nextInt());

        System.out.println(rooms.toString());


        System.out.println("Enter the new room number for the room : ");
        int newRoomNo = Integer.parseInt(input.next());
        rooms.setRoomNo(newRoomNo);

        System.out.println("Enter the new  number of beds for the room :");
        int NoOfBeds = Integer.parseInt(input.next());
        rooms.setNoOfBeds(NoOfBeds);

        input.nextLine();
        do {
            System.out.println("Does the room have a balcony? ");
            typed = input.nextLine();
        } while (!typed.matches("[yesno]+"));
        if (typed.equals("yes")) {
            rooms.setBalcony(true);
        } else if (typed.equals("no")) {
            rooms.setBalcony(false);
        }

        do {
            System.out.println("Enter the price: ");
            typed = input.nextLine();
        } while (!typed.matches("[0-9]+"));
        rooms.setPrice(Double.parseDouble(typed));

        do {
            System.out.println("Is it available? ");
            typed = input.nextLine();
        } while (!typed.matches("[yesno]+"));
        if (typed.equals("yes")) {
            rooms.setAvailability(true);
        } else if (typed.equals("no")) {
            rooms.setAvailability(false);
        }
    }


    void removeBooking() {
        listOfBookings();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < bookingList.size(); i++) {
            System.out.println("[" + i + "]" + bookingList.get(i));
        }
        System.out.println("Which booking do you want to remove?");
        int removeBooking = input.nextInt();


        bookingList.remove(removeBooking);
        System.out.print(" The booking is now removed ");


        bookingList.get(removeBooking).getRoom().setAvailability(true);
    }

    void editBooking() {
        Scanner input = new Scanner(System.in);
        Booking booking;
        long checkInDate;
        long checkOutDate;
        String typed;
        double price = 0;

        for (int i = 0; i < bookingList.size(); i++) {
            System.out.println("[" + i + "]" + bookingList.get(i));
        }
        System.out.println("Choose a booking to edit");
        while (true) {
            try {
                booking = bookingList.get(input.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("Not a booking");
            }
        }

        System.out.println(booking.toString());


        while (true) {
            try {
                System.out.println("Enter the new check in date");
                checkInDate = input.nextLong();

                while (checkInDate < dateNow) {
                    System.out.println("Not a future date");
                    checkInDate = input.nextLong();
                }

                System.out.println("Enter the new check out date");
                checkOutDate = input.nextLong();
                while (checkOutDate < checkInDate) {
                    System.out.println("You cannot go back in time");
                    checkOutDate = input.nextLong();
                }
                break;
            } catch (Exception e) {
                System.out.println("Not a date");
                input.nextLine();
            }

        }
        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i));
        }

        System.out.println("Chose a new room");
        int newRoom = input.nextInt();
        while (newRoom >= roomsList.size()) {
            System.out.println("That's not an option");
            newRoom = input.nextInt();
            input.nextLine();
            roomsList.get(newRoom);
        }
        do {
            System.out.println("Enter the price: ");
            typed = input.nextLine();
        } while (!typed.matches("[0-9]+"));
        roomsList.get(newRoom).setPrice(Double.parseDouble(typed));


        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);
        booking.setPrice(price);
        booking.setRoom(roomsList.get(newRoom));
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

    public void viewInfo(String user) {

        listOfCustomer();

        for (Customer customer : customerList)
            if (customer.getSSN().equalsIgnoreCase(user)) {
                System.out.printf(" Name: %s%n" + "SSN:  %s%n" + "Phone number:  %s%n" + "Address: %s%n",
                        customer.getName(), customer.getSSN(), customer.getPhone(), customer.getAddress());

            }
    }

    public void searchByCustomerSSN() {
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("Please Enter Customer SSN \n.............\nin YYMMDDXXXX form : \n");
            String search = input.nextLine();

            if ((search.matches("[0-9]{10}"))) {
                for (Customer customer : customerList)
                    if (customer.getSSN().equals(search)) {
                        System.out.printf(" Name: %s%n" + "SSN:  %s%n" + "Phone number:  %s%n" + "Address: %s%n",
                                customer.getName(), customer.getSSN(), customer.getPhone(), customer.getAddress());
                        break;
                    } else {
                        System.out.println("No Customer with this SSN \n");
                    }

            } else {
                System.out.println("Enter correct SSN \n");

            }
        }
    }

    public void searchByCustomerName() {
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("Please Enter Customer Name : \n............. \n");
            String search = input.nextLine();

            for (Customer customer : customerList)
                if (customer.getName().equals(search)) {
                    System.out.printf(" Name: %s%n" + "SSN:  %s%n" + "Phone number:  %s%n" + "Address: %s%n",
                            customer.getName(), customer.getSSN(), customer.getPhone(), customer.getAddress());
                    break;
                } else {
                    System.out.println("No Customer with this Name \n");
                }
        }
    }

    void searchAvailableRooms() {
        long first;
        long second;
        Scanner input = new Scanner(System.in);
        System.out.println("Between what dates do you want to see?");
        while (true) {
            try {
                System.out.println("Enter the first date");
                first = input.nextLong();

                while (first < dateNow) {
                    System.out.println("Not a future date");
                    first = input.nextLong();
                }

                System.out.println("Enter the second date");
                second = input.nextLong();
                while (second < first) {
                    System.out.println("You cannot go back in time");
                    second = input.nextLong();
                }
                break;
            } catch (Exception e) {
                System.out.println("Not a date");
                input.nextLine();
            }

        }

        ArrayList<Rooms> roomsToPrint = (ArrayList<Rooms>) roomsList.clone();

        for (int i = 0; i < bookingList.size(); i++) {

            if (first <= bookingList.get(i).getCheckInDate() && bookingList.get(i).getCheckInDate() <= second) {
                if (first <= bookingList.get(i).getCheckOutDate() && bookingList.get(i).getCheckOutDate() <= second) {
                    roomsToPrint.remove(bookingList.get(i).getRoom());
                }
            }

        }
        System.out.println(roomsToPrint);
        }
    }
