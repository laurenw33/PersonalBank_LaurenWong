import java.util.Scanner;


public class Runner {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        User account1 = null;

        System.out.println("Welcome to your personal banking system!");
        System.out.print("What would you like to do? Create, Withdraw, Deposit, or Balance: ");
        String answer = s.nextLine();

        if (answer.equalsIgnoreCase("create"))
        {
            System.out.print("Please enter a username: ");
            String user = s.nextLine();

            System.out.print("Please enter a four-digit pin: ");
            int pin = s.nextInt();
            int lenPin = String.valueOf(pin).length();

            if (lenPin == 4)
            {
                System.out.println("Account created successfully with username: " + user);
                account1 = new User(user, pin);
            }


            else if (lenPin != 4)
           {
                System.out.print("Error! Please enter a four-digit pin: ");
                int pin1 = s.nextInt();
                account1 = new User(user, pin1);
                System.out.println("Account created successfully with username: " + user);
           }
        }

        else if (answer.equalsIgnoreCase("withdraw"))
        {
            System.out.print("Please re-enter your username: ");
            String newUser = s.nextLine();
            boolean userVer = account1.verifyUser(newUser);

            if (userVer == true) {
                System.out.print("Please re-enter your pin: ");
                int newPin = s.nextInt();
                System.out.print("Please enter your deposit amount: ");
                int depositAmt = s.nextInt();
                account1.withdraw(depositAmt, newPin);
            }
            else
            {
                System.out.println("That account does not exist!");
            }
        }


    }
}

