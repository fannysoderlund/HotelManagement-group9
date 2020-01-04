package group9;

import java.util.Scanner;


public class Main {
    Scanner input = new Scanner(System.in);
    private HotelLogic call = new HotelLogic();

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

       call.listOfRooms();
        call.listOfCustomer();
        call.listOfBookings();

        System.out.println("Welcome to Employees Menu of HKR Hotel");
        int choice = 0;
        int typed = 0;
        while (choice != 16) {
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

                    for (int i = 0; i < call.bookingList.size(); i++) {
                        if (call.bookingList.get(i).getCheckOutDate() < call.dateNow) {
                            call.bookingList.get(i).getCustomer().setCheckedIn(false);
                        }
                    }
                    for (Customer c : call.customerList) {
                        System.out.println(c.toString());
                    }
                    break;
                case 2:

                    for (int i = 0; i < call.bookingList.size(); i++) {
                        if (call.bookingList.get(i).getCheckOutDate() < call.dateNow) {
                            call.bookingList.get(i).getRoom().setAvailability(true);
                        }
                    }
                    for (Rooms r : call.roomsList) {
                        System.out.println(r.toString());
                    }

                    break;
                case 3:
                    System.out.println(call.dateNow);

                    for (int i = 0; i < call.bookingList.size(); i++) {
                        if (call.bookingList.get(i).getCheckOutDate() < call.dateNow) {
                            call.bookingList.get(i).getRoom().setAvailability(true);
                            call.bookingList.get(i).getCustomer().setCheckedIn(false);
                        }
                    }
                    for (Booking b : call.bookingList)
                        System.out.println(b.toString());
                    break;
                case 4:

                    call.addCustomer();
                    break;
                case 5:

                    call.removeCustomer();
                    break;
                case 6:

                    call.editCustomer();
                    break;
                case 7:
                    call.addRoom();
                    break;
                case 8:

                    call.removeRooms();
                    break;
                case 9:

                    call.editRooms();
                    break;
                case 10:

                    call.addBooking();
                    break;
                case 11:

                    call.removeBooking();
                    break;
                case 12:

                    call.editBooking();
                    break;
                case 13:
                    System.out.println("Chose a customer to checkout");

                    call.checkOut();
                    break;
                case 14:
                    call.searchByCustomerName();
                    break;
                case 15:
                    call.searchByCustomerSSN();
                case 16:
                    signIn();

                    break;
                case 17:
                    System.exit(0);
                    break;

            }
        }
    }
        private void MenuCustomer (String user){
            System.out.println("Welcome to the HKR Hotel");
            call.listOfRooms();
            call.listOfCustomer();
            call.listOfBookings();
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
                          call.viewInfo(user);
                        break;
                    case 3:
                        //   call.editBooking();
                        break;
                    case 4:
                        // call.editInfo();
                        break;
                    case 5:
                        //  call.removeBookings();
                        break;
                    case 6:
                        // call.checkOut();
                        break;
                    case 7:
                        call.searchAvailableRooms();
                        break;
                    case 8:
                        signIn();

                        break;
                    case 9:
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
        System.out.println("14. Search by customer name");
        System.out.println("15. Search by customer SSN");
        System.out.println("14. Exit Employee Menu");
        System.out.println("15. Exit");

    }

    private void printCustomer() {
        System.out.println("1. Make a booking");
        System.out.println("2. View your information");
        System.out.println("3. Edit one of your bookings");
        System.out.println("4. Edit your information");
        System.out.println("5. Remove one of your bookings");
        System.out.println("6. Check out");
        System.out.println("7. Search for available rooms");
        System.out.println("8. Exit Customer Menu");
        System.out.println("9. Exit");

    }


}
