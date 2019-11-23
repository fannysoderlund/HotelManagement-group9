package fanny;

import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);

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
                    break;
                } else if (user.toCharArray().length == 10 && (user.matches("[0-9]+"))) {
                    user = "Customer";
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
}
