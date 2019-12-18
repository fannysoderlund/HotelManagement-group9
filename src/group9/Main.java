package group9;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Main {
    Scanner input = new Scanner(System.in);
    private HotelLogic call = new HotelLogic();

    DateFormat dateFormat = new SimpleDateFormat("yymmdd");
    Date date = new Date();
    long dateNow = Long.parseLong(dateFormat.format(date));

    public static void main(String[] args) {
        Main myApp = new Main();

            String user = myApp.signIn();
            if (user.equals("Employee")) {
                myApp.EmployeeMenu();
              
            } else  {
                myApp.MenuCustomer(user);
            }

    }
    public String signIn() {
        String user;
        while (true) {
            try {
                System.out.println("Please log in\n.............\nIf you are a customer, sign in with your SSN (YYMMDDXXXX)\n" +
                        "If you are an employee, sign in with your login.hotel\n");
                user = input.nextLine();
                if (user.contains(".hotel")) {
                    user = "Employee";
                    break;
                } else if ((user.matches("[0-9]{10}"))) {
                    user = user;
                    break;
                } else {
                    System.out.println("Please enter a correct log in\n");
                }
            } catch (Exception e) {
                System.out.println("Please enter a correct log in\n");
            }
        }
        return user;
    }

    public void EmployeeMenu() {
        System.out.println("Welcome to Employees Menu of HKR Hotel");
        int choice = 0;
        int typed = 0;
        while (choice != 14) {
            printEmployee();

            while (true) {
                try {
                    System.out.print("Make your choice: ");
                    typed = input.nextInt();
                    while (typed > 15) {
                        System.out.println("This option doesn't exist");
                        try {
                            typed = input.nextInt();
                        } catch (Exception e) {
                            input.next();
                        }
                    }
                } catch (Exception e) {
                    input.next();
                }
                choice = typed;
                break;
            }

            switch (choice) {
                case 1:
                    call.listOfCustomer();

                    for (int i = 0; i < call.bookingList.size(); i++) {
                        if (call.bookingList.get(i).getCheckOutDate() < dateNow) {
                            call.bookingList.get(i).getCustomer().setCheckedIn();
                        }
                    }
                    for (Customer c : call.customerList) {
                        System.out.println(c.toString());
                    }
                    break;
                case 2:
                    call.listOfRooms();

                    for (Rooms r : call.roomsList) {
                        System.out.println(r.toString());
                    }

                    break;
                case 3:
                    call.listOfCustomer();
                    call.listOfRooms();
                    call.listOfBookings();

                    for (int i = 0; i < call.bookingList.size(); i++) {

                        if (call.bookingList.get(i).getCheckOutDate() < dateNow) {
                            call.bookingList.get(i).getRoom().setAvailability(false);
                        }
                    }

                    for (Booking b : call.bookingList) {
                        System.out.println(b.toString());
                    }
                    break;
                case 4:
                    call.listOfCustomer();
                    call.addCustomer();
                    break;
                case 5:
                    call.listOfCustomer();
                    call.removeCustomer();
                    break;
                case 6:

                    call.listOfCustomer();
                    call.editCustomer();
                    break;
                case 7:
                    call.addRoom();
                    break;
                case 8:
                    call.listOfRooms();
                    call.removeRooms();
                    break;
                case 9:
                    call.listOfRooms();
                    call.editRooms();
                    break;
                case 10:
                    call.listOfRooms();
                    call.listOfCustomer();
                    call.addBooking();
                    break;
                case 11:
                    call.listOfBookings();
                    call.removeBooking();
                    break;
                case 12:
                    call.listOfBookings();
                    for (Booking b : call.bookingList) {
                        System.out.println(b.toString());
                    }
                    call.editBooking();
                    break;
                case 13:
                    System.out.println("Chose a customer to checkout");
                    call.listOfCustomer();
                    call.checkOut();
                    break;
                case 14:
                    signIn();

                    break;
                case 15:
                    System.exit(0);
                    break;

            }
        }
    }
        private void MenuCustomer (String user){
            System.out.println("Welcome to the HKR Hotel");
            int booking;
            int choice;
            boolean cont = true;
            while (cont) {
                printCustomer();
                System.out.println("- Please Make your choice");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        //    call.makeBooking();
                        break;
                    case 2:
                        //  call.viewInfo();
                        break;
                    case 3:
                        //   call.editBooking();
                        break;
                    case 4:
                        // call.editInfo();
                        break;
                    case 5:
                        //  call.searchBookings();
                        break;
                    case 6:
                        // call.checkOut();
                        break;
                    case 7:
                        signIn();


                        break;
                    case 8:
                        cont = false;

                        break;
                }
            }
        }

    private void printEmployee() {
        System.out.println("1. View list of customers");
        System.out.println("2. View list of rooms");
        System.out.println("3. View list of bookings");
        System.out.println("4. Add customer");
        System.out.println("5. Remove customer");
        System.out.println("6. Edit customer");
        System.out.println("7. Add room");
        System.out.println("8. Remove room");
        System.out.println("9. Edit room");
        System.out.println("10. Add booking");
        System.out.println("11. Remove booking");
        System.out.println("12. Edit booking");
        System.out.println("13. Check out a customer");
        System.out.println("14. Exit Employee Menu");
        System.out.println("15. Exit");

    }

    private void printCustomer() {
        System.out.println("1. Make a booking");
        System.out.println("2. View your information");
        System.out.println("3. Edit one of your bookings");
        System.out.println("4. Edit your information");
        System.out.println("5. Search available bookings");
        System.out.println("6. Check out");
        System.out.println("7. Exit Customer Menu");
        System.out.println("8. Exit");

    }
}
