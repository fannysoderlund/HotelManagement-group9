package group9;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class HotelLogic {

    DateFormat dateFormat = new SimpleDateFormat("yymmdd");
    Date date = new Date();
    long dateNow = Long.parseLong(dateFormat.format(date));


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
        boolean availability = false;

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

        System.out.println("Is room available ? ");
        String answerAvailability = input.next();

        if (answerAvailability == ("yes")) {
            availability = true;
        } else if (answerAvailability == ("no")) {
            availability = false;
        } else
            System.out.println("Incorrect reply");
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
        } while (!typed.matches("[0-9]+"));
        SSN = typed;


        System.out.println("Enter address: ");
        address = input.nextLine();

        do {
            System.out.println("Enter phone number: ");
            typed = input.nextLine();
        } while (!typed.matches("[0-9]+"));
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
        long digits = 6;
        String typed;
        long checkInDate;
        long checkOutDate;
        double price;
        Customer customer = null;


        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "]" + customerList.get(i).toString());

        }

        System.out.println("What customer wants to make a booking?");
        while (true) {
        try {
            customer = customerList.get(input.nextInt());
            break;
        }catch (Exception e) {
            System.out.println("Not a real customer");
        }}

        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i).toString());
        }
        System.out.println("Choose a room to book:  ");
        while (true) {
         try {
             room = roomsList.get(input.nextInt());
             break;
         }catch (Exception e) {
             System.out.println("Not a real room");
         }}

        while (true) {
            try {
                do {

                        System.out.print("Enter the check in date: ");
                        checkInDate = input.nextLong();

                        System.out.print("Enter the check out date: ");
                        checkOutDate = input.nextLong();


                } while (checkInDate < checkOutDate && checkInDate <= dateNow);
                break;
            }catch (Exception e) {
                System.out.println("Not a date in YYMMDD");
            }
        }
        price = room.getPrice();

        System.out.printf("The price for a night is %.2f kr%n", price);

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
        boolean checkedIn = false;

        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("[" + i + "]" + customerList.get(i));
        }
        System.out.println("What customer do you want to edit?");
        Customer customer = customerList.get(input.nextInt());

        System.out.print("customer name: " + customer.getName() +
                "\n customer SSN : " + customer.getSSN() +
                "\n customer checked in  : " + customer.isCheckedIn() +
                "\n customer address: " + customer.getAddress() +
                "\n customer phone : " + customer.getPhone() +
                "\n \"\n ");


        System.out.print("Enter name: ");
        String name = input.nextLine();
        while (!input.hasNext("[A-Za-z]+")) {
            System.out.println(" Error! Please type in correct name:  ");
            input.nextLine();
        }
        customer.setName(name);

        System.out.print("Enter SSN: ");
        String SSN = input.nextLine();
        while (!input.hasNext("[0-9]+")) {
            System.out.println(" Error! Please type in correct SSN:  ");
            input.nextLine();
        }
        customer.setSSN(SSN);

        System.out.print("Enter phone number: ");
        String phone = input.nextLine();
        while (!input.hasNext("[0-9]+")) {
            System.out.println(" Error! Please type in correct phone number:  ");
            input.nextLine();
        }
        customer.setPhone(phone);


        System.out.print("Enter address: ");
        String address = input.nextLine();
        while (!input.hasNext("[A-Za-z]+")) {
            System.out.println(" Error! Please type in correct Adress:  ");
            input.nextLine();
        }
        customer.setAddress(address);

        System.out.println("Is customer in checked ? ");
        String answer = input.next();

        if (answer.equals("yes")) {
            checkedIn = true;
        } else if (answer.equals("no")) {
            checkedIn = false;
        } else
            System.out.println("Incorrect reply");

        customer.setCheckedIn();
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
        boolean checkedIn = false;

        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i));
        }
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
        int NoOfBeds = Integer.parseInt(input.next());
        rooms.setNoOfBeds(NoOfBeds);

        System.out.println("Enter the new price for the room :");
        double Price = Double.parseDouble(input.next());
        rooms.setPrice(Price);

        boolean balcony = false;
        System.out.println("Does the room have a balcony (yes/no) :  ");
        String answerB = input.next();
        if (answerB.equals("yes")) {
            balcony = true;
        } else if (answerB.equals("no")) {
            balcony = false;
        } else
            System.out.println("Incorrect reply");

        rooms.setBalcony(balcony);

        System.out.println("Is it Available ? ");
        String answer = input.next();
        if (answer.equals("yes")) {
            checkedIn = true;
        } else if (answer.equals("no")) {
            checkedIn = false;
        } else
            System.out.println("Incorrect reply");

        rooms.setAvailability(checkedIn);
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
    }

    void editBooking() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < bookingList.size(); i++) {
            System.out.println("[" + i + "]" + bookingList.get(i));
        }
        System.out.println("Choose a booking to edit");
        Booking booking = bookingList.get(input.nextInt());

        System.out.print("Room booked: " + booking.getRoom() +
                "\nCheck in on: " + booking.getCheckInDate() +
                ", Check out on: " + booking.getCheckOutDate() +
                ", Price: " + booking.getPrice() + "SEK" +
                " \n   - Customer who booked: " + booking.getCustomer());

        System.out.print("Enter new check in date: ");
        long newCheckInDate = input.nextLong();

        while (!input.hasNext("[0-9]+")) {
            System.out.println(" Error! Please type a date YYMMDD:  ");
            input.nextLine();
        }
        System.out.print("Enter new check out date: ");
        long newCheckOutDate = input.nextLong();
        while (!input.hasNext("[0-9]+")) {
            System.out.println(" Error! Please type a date YYMMDD:  ");
            input.nextLine();
        }
        System.out.print("Enter new price: ");
        double newPrice = input.nextDouble();
        while (!input.hasNext("[0-9]+")) {
            System.out.println(" Error! Please type in correct phone number:  ");
            input.nextLine();

        }
        for (int i = 0; i < roomsList.size(); i++) {
            System.out.println("[" + i + "]" + roomsList.get(i));
        }
        System.out.println("Chose a new room");
        Rooms newRoom = roomsList.get(input.nextInt());

        booking.setCheckInDate(newCheckInDate);
        booking.setCheckOutDate(newCheckOutDate);
        booking.setPrice(newPrice);
        booking.setRoom(newRoom);

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
                customerList.get(customerToCheckOut).setCheckedIn();
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


        String SSN = user;

        for (Customer customer : customerList)
            if (customer.getSSN().equalsIgnoreCase(SSN)) {
                System.out.printf(" Name: %s%n" + "SSN:  %s%n" + "Phone number:  %s%n" + "Adress: %s%n",
                        customer.getName(), customer.getSSN(), customer.getPhone(), customer.getAddress());

            }
    }
}