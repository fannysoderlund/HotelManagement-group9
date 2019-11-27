package group9;

import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
   private  HotelLogic call = new HotelLogic();
    public static void main(String[] args) {
        Main myApp = new Main();

        String user = myApp.signIn();

        //use the string user to call correct menu

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
                    EmployeeMenu();
                    break;
                } else if (user.toCharArray().length == 10 && (user.matches("[0-9]+"))) {
                    user = "Customer";
                    MenuCustomer();
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
    System.out.println("Welcome to Employees Menu of HKR Hotel,please Enter your LoginID");
int id = input.nextInt();

int choice ;
boolean cont = true;
while (cont) {
   printfirst();
    System.out.println("Please Make your choice :- ");
    choice = input.nextInt();
  switch (choice) {
      case 1 :
          call.listOfCustomer();
          break;
      case 2 :
          call.RoomInfo();
          break;
      case 3 :
          call.AddRoom();
          break;
      case 4 :
          call.addCustomer();
          break;
      case 5 :
          call.RemoveCustomer();
          break;
      case 6 :
          call.EditRoom();
          break;
      case 7:
          call.listOfRooms();
          break;
      case 8 :
          cont = false;
  break;
  }
}
}
private void MenuCustomer (){
    System.out.println("Welcome to HKR Hotel, Please Enter your Bookking Number");
    int booking = input.nextInt();
    int choice;
    boolean cont = true;
    while (cont) {
       printMenu2();
        System.out.println("Please Make your choice");
        choice = input.nextInt();
        switch (choice) {
            case 1 :
call.MakeBooking();
break;
            case 2 :
                call.viewInfo();
                break;
            case 3:
                call.EditBooking();
                break;
            case 4:
                call.EditInfo();
                break;
            case 5 :
                call.searchBooking();
                break;
            case 6 :
                call.checkout();
                break;
            case 7:
                cont = false;
                break;
        }
    }
    }
private void printfirst() {
    System.out.println("1- List Of Customers");
    System.out.println("2- Room Information");
    System.out.println("3- Add Room");
    System.out.println("4- Add Customer");
    System.out.println("5- Remove Customer");
    System.out.println("6- Edit Room");
    System.out.println("7- List Of All Avillable Rooms");
    System.out.println("Exit");
}
private void printMenu2() {
    System.out.println("1- Make a Booking");
    System.out.println("2- View Customer Info");
    System.out.println("3- Edit Booking");
    System.out.println("4- Edit Customer Information");
    System.out.println("5- Search Booking");
    System.out.println("6- Check out");
    System.out.println("Exit");
}
}
