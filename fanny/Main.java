package fanny;
import java.util.Scanner;
public class Main {
Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Main myApp=new Main();
        String user = myApp.signIn();
        if (user.contains(".hotel")) {
            user = "Employee";
            //call menu employee
        }else {
            user= "Customer";
            //call menu customer
        }
    }

    public String signIn() {
        System.out.println("Please log in\nIf you are a customer, sign in with your SSN(YYMMDDXXX)\n" +
                "If you are an employee, sign in with your login.hotel\n");
        return input.nextLine();
    }
}
